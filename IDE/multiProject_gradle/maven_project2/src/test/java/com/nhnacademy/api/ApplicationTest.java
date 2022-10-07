package com.nhnacademy.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest extends TestCase {

    @Test
    public void testConcat(){
        //given
        Application application = new Application();

        //when
        String c = application.concat("aaa","bbb");
        String expected = "aaabbb";

        //then
        Assert.assertEquals(expected,c);

    }

}