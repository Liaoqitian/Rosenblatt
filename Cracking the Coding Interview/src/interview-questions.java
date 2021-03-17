import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ArraysAndStrings {
    /** Implement an algorithm to determine whether a string has all unique characters */
    public static boolean Q1S1(String s) {
        boolean[] char_set = new boolean[128];
        if (s.length() > 128) return false;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    /** Achieve the same goal without using additional data structures */
    public static boolean Q1S2(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                char curr = s.charAt(i), next = s.charAt(j);
                if (curr == next) return false;
            }
        }
        return true;
    }

    public static boolean Q1S3(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) return false;
        }
        return true;
    }

    /** Check Permutation:** Given two strings, write a method to decide if one is a permutation of the other. */
    public static boolean Q2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hashTable = new int[128];
        for (int i = 0; i < s.length(); i++) hashTable[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++) hashTable[t.charAt(i)]--;
        for (int i = 0; i < 128; i++) {
            if (hashTable[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Tests for Q1
        String s = "abcad";
        System.out.println(Q1S1(s));
        System.out.println(Q1S2(s));
        System.out.println(Q1S3(s));

        // Test for Q2
        System.out.println(Q2("dat", "tac"));
    }
}