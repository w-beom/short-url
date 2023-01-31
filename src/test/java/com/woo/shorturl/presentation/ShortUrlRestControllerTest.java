package com.woo.shorturl.presentation;

import com.woo.shorturl.service.ShortUrlService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShortUrlRestController.class)
class ShortUrlRestControllerTest {

    @MockBean
    private ShortUrlService shortUrlService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("변환된 id를 입력 시 원래의 URL로 리다이렉트 한다.")
    public void test01() throws Exception {
        String originalUrl = "http://www.naver.com";

        when(shortUrlService.getOriginalUrl(any())).thenReturn(originalUrl);

        mockMvc.perform(get("/origin/1"))
                .andExpect(status().isSeeOther())
                .andExpect(header().string("Location", originalUrl));
    }

}
