package com.deekshant.churn_dashboard.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        System.out.println("DEBUG - Request: " + request.getMethod() + " " + request.getRequestURI());
        String authHeader = request.getHeader("Authorization");
        System.out.println("DEBUG - Auth header received: " + authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                String username = jwtUtil.extractUsername(token);
                String role = jwtUtil.extractRole(token);
                System.out.println("DEBUG - Username: " + username + ", Role: " + role);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, Collections.singletonList(() -> "ROLE_" + role.toUpperCase())
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println(
                        "DEBUG - Authentication set: "
                                + SecurityContextHolder.getContext().getAuthentication()
                );
                System.out.println("DEBUG - Authorities: "
                        + SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getAuthorities());
            }
            else {
                System.out.println("DEBUG - Token validation FAILED");
            }
        }
        chain.doFilter(request, response);
    }

}
