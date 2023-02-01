package com.woo.shorturl.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base56Test {

    @Test
    @DisplayName("id를 Base56으로 인코딩 후 디코딩한 결과 값이 같다.")
    public void test01() {
        // given
        long id = 123123123L;

        // when
        String encode = Base56.encode(id);
        long decode = Base56.decode(encode);

        //then
        assertEquals(id, decode);
    }

}
