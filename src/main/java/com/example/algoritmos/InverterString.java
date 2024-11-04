package com.example.algoritmos;

public class InverterString {
    private static String inverterString(String string) {
        if (string.length() == 1) {
            return string;
        }

        return string.charAt(string.length() - 1) + inverterString(string.substring(0, string.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(inverterString("Hello World"));
    }
}
