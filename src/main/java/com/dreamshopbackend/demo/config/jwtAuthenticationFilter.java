package com.dreamshopbackend.demo.config;

import com.dreamshopbackend.demo.config.JwtService.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
//@RequiredArgsConstructor
public class jwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtServices;
    private final UserDetailsService userDetailsService;

    public jwtAuthenticationFilter(JwtService jwtServices, UserDetailsService userDetailsService) {
        this.jwtServices = jwtServices;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
                final String AuthHeader=request.getHeader("Authorization");
                String jwt;
                final String userEmail;
                if(AuthHeader == null || AuthHeader.startsWith("Bearer ")){
                    filterChain.doFilter(request,response);
                    return;
                }

                jwt= AuthHeader.substring(7);
                userEmail=jwtServices.extractEmail(jwt);
                if(userEmail != null && SecurityContextHolder.getContext().getAuthentication()==null){
                    UserDetails userDetails=this.userDetailsService.loadUserByUsername(userEmail);
                    if(jwtServices.isTokenValid(jwt, userDetails) ){
                        //update the security context
                        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                        authenticationToken.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails((request))
                        );
                        SecurityContextHolder.getContext().setAuthentication((authenticationToken));
                    }
                }
                filterChain.doFilter(request,response);


    }
}
