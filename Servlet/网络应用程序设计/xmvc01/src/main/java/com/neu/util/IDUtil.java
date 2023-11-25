package com.neu.util;

import java.util.UUID;

public class IDUtil {
    public IDUtil() {
    }

    public static String getID() {
        UUID uuid = UUID.randomUUID();
        String a = uuid.toString();
        a = a.toUpperCase();
        a = a.replaceAll("-", "");
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getID());
    }
}