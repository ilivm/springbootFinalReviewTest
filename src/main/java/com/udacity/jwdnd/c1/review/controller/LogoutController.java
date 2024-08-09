package com.udacity.jwdnd.c1.review.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping
    public String logout(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        Authentication auth = (Authentication) servletRequest.getUserPrincipal();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(servletRequest, servletResponse, auth);
        }

        return "redirect:/login/?logout";
    }
}
