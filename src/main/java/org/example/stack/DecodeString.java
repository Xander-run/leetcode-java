package org.example.stack;

import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Character pop = null;
        Character top = null;

        for (char theChar : s.toCharArray()) {
            if (theChar == ']') {
                StringBuilder currentStrBuilder = new StringBuilder();
                String currentString;
                StringBuilder currentNum = new StringBuilder();
                while ((pop = stack.pop()) != '[') {
                    currentStrBuilder.append(pop);
                }
                currentString = currentStrBuilder.reverse().toString();

                while (!stack.isEmpty() && Character.isDigit(top = stack.peek())) {
                    currentNum.append(top);
                    stack.pop();
                }
                currentNum.reverse();

                int n = Integer.parseInt(currentNum.toString());
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < currentString.length(); j++) {
                        stack.push(currentString.charAt(j));
                    }
                }
            } else {
                stack.push(theChar);
            }
        }

        char[] chars = new char[stack.size()];
        int n = stack.size();;
        for (int i = 0; i < n; i++) {
            chars[n - i - 1] = stack.pop();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
