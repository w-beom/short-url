package com.woo.shorturl.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62Test {

    @Test
    @DisplayName("BASE62 인코딩 테스트")
    public void test01() {
        long id = 123123123L;
        String encode = Base62.encode(id);
        long decode = Base62.decode(encode);
        assertEquals(id, decode);
    }

}
