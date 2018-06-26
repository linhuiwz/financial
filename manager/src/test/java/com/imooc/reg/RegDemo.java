package com.imooc.reg;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo {

    public static void main(String[] args) {
        String str = "23453463456";
        Pattern pattern = Pattern.compile("[1-9]\\d{5,15}");
        Matcher matcher = pattern.matcher(str);
        boolean bMatch = matcher.matches();
        System.out.println("match=" + bMatch);

    }

    @Test
    public void testMobile() {
        String str = "13989482215";
        //^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])d{8}$
        Pattern pattern = Pattern.compile("1[34578][0-9]{9}");
        Matcher matcher = pattern.matcher(str);
        boolean bMatch = matcher.matches();
        System.out.println("match=" + bMatch);
    }
}
