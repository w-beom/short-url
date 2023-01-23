package com.woo.shorturl.domain;

import com.woo.shorturl.exception.URLSyntaxException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class ShortUrl {
    private String url;
    private String shortUrl;

    public ShortUrl(String url) {
        validation(url);
        this.url = url;
    }

    private void validation(String url) {
        try {
            new URL(url).toURI();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new URLSyntaxException("유효하지 않은 URL입니다.", e);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public boolean existShortUrl(){
        return StringUtils.hasLength(this.shortUrl);
    }

    public void convertUrl() {

    }
}
