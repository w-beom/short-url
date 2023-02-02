package com.woo.shorturl.presentation;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public class ShortUrlRequestDTO {
    @NotNull
    @URL(regexp = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)", message = "유효하지 않은 URL입니다.")
    private String url;

    public ShortUrlRequestDTO() {
    }

    public ShortUrlRequestDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
