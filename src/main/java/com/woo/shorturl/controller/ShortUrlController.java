package com.woo.shorturl.controller;

import com.woo.shorturl.dto.ShortUrlRequestDTO;
import com.woo.shorturl.dto.ShortUrlResponseDTO;
import com.woo.shorturl.exception.URLSyntaxException;
import com.woo.shorturl.service.ShortUrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class ShortUrlController {
    private final ShortUrlService shortUrlService;

    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @ExceptionHandler({URLSyntaxException.class})
    public ResponseEntity<Object> handleURLException(Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/short-url")
    public ResponseEntity<ShortUrlResponseDTO> convertUrl(@RequestBody ShortUrlRequestDTO shortUrlRequestDTO, HttpServletRequest request) {
        String shortUrl = shortUrlService.convertUrl(shortUrlRequestDTO);
        String fullUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/origin/" + shortUrl;
        return ResponseEntity.ok(new ShortUrlResponseDTO(fullUrl));
    }

    @GetMapping("/origin/{id}")
    public ResponseEntity<Object> getUrl(@PathVariable String id) throws URISyntaxException {
        String originalUrl = shortUrlService.getOriginalUrl(id);
        URI uri = new URI(originalUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
