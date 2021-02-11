package org.sber.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class removeDuplicatesCharsTest {
    @Test
    public void testGetDivide() throws Exception {
        assertEquals("Привет, Сбер!", RemoveDuplicatesChars.removeDuplicates("ППппрррриииивеееет, Сссссбббеееер!"));
    }

}