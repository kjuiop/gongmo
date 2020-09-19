package com.gig.lookBook.api.controller;

import com.gig.lookBook.core.exception.NotFoundException;
import com.gig.lookBook.core.security.LoginUser;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class IndexController {
    
    @RequestMapping
    public ModelAndView index(@AuthenticationPrincipal LoginUser loginUser, HttpServletRequest request) throws NotFoundException, ParseException {
        if (loginUser != null) {
            return new ModelAndView("index-after-login");
        }
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("login")
    public String login() { return "login"; }
}
