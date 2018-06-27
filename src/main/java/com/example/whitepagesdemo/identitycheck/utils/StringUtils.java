package com.example.whitepagesdemo.identitycheck.utils;

public class StringUtils {

    public static boolean isBlank(String string) {
        if(string == null || string.trim().equals("")) {
            return true;
        }
        return false;
    }
}
