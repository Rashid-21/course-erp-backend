package com.company.courseerpbackend.filters;

import com.company.courseerpbackend.constants.TokenConstants;
import com.company.courseerpbackend.models.mybatis.user.User;
import com.company.courseerpbackend.services.security.AccessTokenManager;
import com.company.courseerpbackend.services.security.AuthBusinessService;
import com.company.courseerpbackend.services.user.UserService;
import io.jsonwebtoken.Claims;
import io.micrometer.common.lang.NonNullApi;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static com.company.courseerpbackend.constants.TokenConstants.EMAIL_KEY;
import static com.company.courseerpbackend.constants.TokenConstants.PREFIX;


@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final AuthBusinessService authBusinessService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        String token = request.getHeader(HttpHeaders.AUTHORIZATION);


        if (Objects.nonNull(token) && token.startsWith(PREFIX)) {

            authBusinessService.setAuthentication
                    (accessTokenManager
                            .getEmail(
                                    token.substring(7)
                            )
                    );

        }

        filterChain.doFilter(request, response);

    }
}