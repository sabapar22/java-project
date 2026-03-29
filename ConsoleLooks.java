package com.ecoquest.utils;

public class ConsoleLooks {
    public static void printHeader(String title) {
        System.out.println("\n=======================================================");
        System.out.println("      " + title.toUpperCase());
        System.out.println("=======================================================");
    }
    public static void printSuccess(String msg) {
        System.out.println(">> [SUCCESS] " + msg);
    }
    public static void printError(String msg) {
        System.out.println(">> [ERROR] " + msg);
    }
    public static void printMenu(String... options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print(">> Choose an option: ");
    }
}