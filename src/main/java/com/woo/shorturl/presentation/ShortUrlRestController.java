package com.woo.shorturl.presentation;

import com.woo.shorturl.service.ShortUrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ShortUrlRestController {
    private final ShortUrlService shortUrlService;

    public ShortUrlRestController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping("/short-url")
    public ResponseEntity<ShortUrlResponseDTO> convertUrl(@RequestBody @Valid ShortUrlRequestDTO shortUrlRequestDTO, HttpServletRequest request) {
        String shortUrl = shortUrlService.convertUrl(shortUrlRequestDTO);
        return ResponseEntity.ok(new ShortUrlResponseDTO(shortUrl));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUrl(@PathVariable String id) throws URISyntaxException {
        String originalUrl = shortUrlService.findOriginalUrl(id);

        URI uri = new URI(originalUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
