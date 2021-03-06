package com.cmb.venus.utest;

public class StringUtils {

    private final String value;

    public StringUtils(final String value) {
        this.value = value;
    }

    public boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        //this is a test
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlpha(final CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isLetter(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
