package com.woo.shorturl.domain;

import com.woo.shorturl.exception.URLSyntaxException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortUrlTest {

    @Test
    @DisplayName("유효한 URL 입력 테스트")
    public void test01() {
        String url = "https://www.naver.com";
        assertEquals(url, new ShortUrl(url).getUrl());
    }

    @Test
    @DisplayName("유효하지 않은 URL 입력 테스트")
    public void test02() {
        String url = "htte://www.naver.com";
        Assertions.assertThatThrownBy(() -> new ShortUrl(url)).isInstanceOf(URLSyntaxException.class)
                .hasMessageContaining("유효하지 않은 URL입니다.");
    }
}
