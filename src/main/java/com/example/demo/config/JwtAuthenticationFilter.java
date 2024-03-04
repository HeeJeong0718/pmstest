package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtUtils jwtUtils;

        //request로 들어오는 JWT의 유효성검증 -JwtProvider.validationToken()을 필터로서 filterChain에 추가
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            String token = jwtUtils.resolveToken((HttpServletRequest) request);
            String requestURI = ((HttpServletRequest) request).getRequestURI();

            Authentication authentication = null;
            if (StringUtils.hasText(token) && jwtUtils.validateToken(token)) {
                 authentication = jwtUtils.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("인증 정보를 저장함"  + requestURI);
            } else {
                System.out.println("유효한 토큰 없음"  + requestURI);
            }


            chain.doFilter(request, response);
        }

    }
