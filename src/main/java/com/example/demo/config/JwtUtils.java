package com.example.demo.config;

import com.example.demo.Model.TokenDTO;
import com.example.demo.Model.UserDto;
import com.example.demo.mapper.UserMapper;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Component
@RequiredArgsConstructor
public class JwtUtils {

    //jwt생성
    private String secretKey ="webPetHospitalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private String ROLES = "roles";
    private final Long accessTokenValid = 60 * 1000L;
    private final Long refreshTokenValid = 1200000L;
    private final UserDetailsService userDetailsService;
    private final UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes()); // SecretKey Base64로 인코딩
    }


    // JWT 토큰 생성
    public TokenDTO createToken(int userId, List<String> roles) {
        System.out.println("!!!!"  +  roles);
        Claims claims = Jwts.claims().setSubject(Long.toString(userId));
        UserDto userDto = userMapper.findByUserId2(String.valueOf(userId));
        System.out.println("userDto" + userDto.getRole());
        System.out.println("userDto: " + userDto.toString());
        claims.put("roles", roles);
        Date now = new Date();

        //acessToken
        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessTokenValid)) // 토큰 만료일 설정
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화
                .compact();
        //refreshToken
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now.getTime()+ refreshTokenValid))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        TokenDTO tt= TokenDTO.builder()
                .userId(userId)
                .username(userDto.getUsername())
                .role(roles.get(0))
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();
        return tt;
    }
    private Claims parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        }catch(ExpiredJwtException e) {
            return e.getClaims();
        }
    }
    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 유저 이름 추출
    public String getUserId(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Request header에서 token 꺼내옴
    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        // 가져온 Authorization Header 가 문자열이고, Bearer 로 시작해야 가져옴
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }
    public boolean isExpiredToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return claims.getBody().getExpiration().before(new Date());
        }catch(Exception e) {
            return false;
        }
    }

    // JWT 토큰 유효성 체크
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch (SecurityException | MalformedJwtException | IllegalArgumentException exception) {
            logger.info("잘못된 Jwt 토큰입니다");
        } catch (ExpiredJwtException exception) {
            logger.info("만료된 Jwt 토큰입니다");
        } catch (UnsupportedJwtException exception) {
            logger.info("지원하지 않는 Jwt 토큰입니다");
        }

        return false;
    }
}
