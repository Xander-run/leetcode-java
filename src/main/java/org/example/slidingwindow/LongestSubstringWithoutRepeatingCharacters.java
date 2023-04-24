package org.example.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        HashMap<Character, Integer> char2times = new HashMap<>();
        while (right < s.length()) {
            Character theChar = s.charAt(right);
            char2times.putIfAbsent(theChar, 0);
            char2times.put(theChar, char2times.get(theChar) + 1);
            if (char2times.get(theChar) > 1) {
                while (left < right) {
                    Character leftChar = s.charAt(left);
                    char2times.put(leftChar, char2times.get(leftChar) - 1);
                    left++;
                    if (leftChar == theChar) break;
                }
            }
            right++;
            max = Math.max(right - left, max);
        }
        return max;
    }
}
