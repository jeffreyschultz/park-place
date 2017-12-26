package com.forrent.parkplace.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Default controller method to render the app page.
     *
     * @return
     */
    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
