package com.woo.shorturl.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShortUrlPresentationController {
    @GetMapping("/main/home")
    public String index() {
        return "index";
    }
}
