package backmirror.backend.global.config.jwt;

import backmirror.backend.domain.user.domain.User;
import backmirror.backend.global.config.user.UserDetailsService;
import backmirror.backend.global.config.user.UserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenProvider implements InitializingBean {

    private final UserDetailsService userDetailsService;
    private static final String AUTHORITIES_KEY = "auth";
    private static final String ACCESS_KEY = "access";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.accesstoken-validity-in-seconds}")
    private int accessExpirationTime;
    private Key key;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String getAccessToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return bearerToken;
    }

    public String generateJwtAccessToken(Long id, Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, accessExpirationTime);  // 만료시간 1시간

        final Date issuedAt = new Date();
        final Date validity = new Date(cal.getTimeInMillis());

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setSubject(id.toString())
                .claim(AUTHORITIES_KEY, authorities)
                .claim("type", ACCESS_KEY)
                .setIssuedAt(issuedAt)
                .setExpiration(validity)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getTokenUserId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info(e.toString());
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    public Authentication userAuthorizationInput(User user) {
        UserDetails userDetails = userDetailsService.loadUserByUserId(user.getId());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                "",
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }

    public Authentication getAuthentication(String token) {
        UserDetails adminDetails = userDetailsService.loadUserByUserId(Long.parseLong(getTokenUserId(token)));
        return new UsernamePasswordAuthenticationToken(adminDetails, token, adminDetails.getAuthorities());
    }
}
