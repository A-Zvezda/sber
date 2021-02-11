package org.sber.utils;

public class RemoveDuplicatesChars {
    public static String removeDuplicates(String userKeyword){
        System.out.println(userKeyword.replaceAll("(.)(?iU)\\1+", "$1"));
        return userKeyword.replaceAll("(.)(?iU)\\1+", "$1");
    }
}
