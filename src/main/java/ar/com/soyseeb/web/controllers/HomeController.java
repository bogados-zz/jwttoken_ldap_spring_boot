package ar.com.soyseeb.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sbogado on 01/01/17.
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @RequestMapping(value = { "/", "/encuesta" }, method = RequestMethod.GET)
    public String encuesta(){
        return "/encuesta";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String login(){
        return "/admin";
    }
}
