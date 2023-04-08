package org.example.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        char[] ret = new char[s.length()];
        HashMap<Character, Integer> charOccurrence = new HashMap<>();
        for (char theChar : chars) {
            charOccurrence.putIfAbsent(theChar, 0);
            charOccurrence.put(theChar, charOccurrence.get(theChar) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> charOccurPQ = new PriorityQueue<>(Comparator.comparingInt(entry -> -entry.getValue()));
        charOccurPQ.addAll(charOccurrence.entrySet());
        int idx = 0;
        while (!charOccurPQ.isEmpty()) {
            Map.Entry<Character, Integer> entry = charOccurPQ.poll();
            while (idx < ret.length && entry.getValue() > 0) {
                ret[idx] = entry.getKey();
                entry.setValue(entry.getValue() - 1);
                idx += 2;
                if (idx >= ret.length && idx % 2 == 0) {
                    idx = 1;
                }
            }
        }
        for (int i = 0; i < ret.length - 1; i++) {
            if (ret[i + 1] == ret[i]) return "";
        }

        return new String(ret);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
