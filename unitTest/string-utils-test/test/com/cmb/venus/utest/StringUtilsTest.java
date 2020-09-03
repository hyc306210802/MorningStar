package com.cmb.venus.utest;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {


    @Test
    public void should_is_empty_when_str_is_null() {
        String str = null;
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isEmpty(str), true);

    }//1

    @Test
    public void should_is_empty_when_str_is_blank() {
        String str = "";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isEmpty(str), true);
    }

    @Test
    public void should_is_not_empty_when_str_has_letter() {
        String str = "a";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isEmpty(str), false);
    }
//test
    @Test
    public void should_is_blank_when_str_is_null() {
        String str = null;
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isBlank(str),true);
    }
//test
    @Test
    public void should_is_blank_when_str_is_empty() {
        String str = "";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isBlank(str),true);

    }

    @Test
    public void should_is_blank_when_str_is_space() {
        String str = " ";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isBlank(str),true);
    }

    @Test
    public void should_is_not_blank_when_str_has_letter() {
        String str = "has letter";   //buhaonong
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isBlank(str),false);
    }

    @Test
    public void should_is_not_alpha_when_str_is_null() {
        String str = null;
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isAlpha(str),false);
    }

    @Test
    public void should_is_not_alpha_when_str_is_blank() {
        String str = "";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isAlpha(str),false);
    }

    @Test
    public void should_is_alpha_when_str_only_has_letter() {
        String str = "hasletter";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isAlpha(str),true);
    }

    @Test
    public void should_is_not_alpha_when_str_has_number() {
        String str = "has number123";
        StringUtils stringUtils = new StringUtils(str);
        Assert.assertEquals(stringUtils.isAlpha(str),false);
    }
}