package com.woo.shorturl.controller;

import com.woo.shorturl.dto.ShortUrlRequestDTO;
import com.woo.shorturl.dto.ShortUrlResponseDTO;
import com.woo.shorturl.service.ShortUrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ShortUrlController {
    private final ShortUrlService shortUrlService;

    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/short-url")
    public ResponseEntity<ShortUrlResponseDTO> convertUrl(@RequestBody ShortUrlRequestDTO shortUrlRequestDTO) {
        return ResponseEntity.ok(shortUrlService.convertUrl(shortUrlRequestDTO));
    }

    @GetMapping("/original-url")
    public void getUrl() {
    }
}
