package com.woo.shorturl.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62Test {

    @Test
    @DisplayName("BASE62 인코딩 테스트")
    public void test01() {
        String str = "http://www.naver.com/sdoajspsaojpsojdjopdspojpadojaspojdpsd";
        String encode = Base62.encode(str);
        System.out.println(encode);
        assertEquals(Base62.encode(str), Base62.encode(str));
    }

}
