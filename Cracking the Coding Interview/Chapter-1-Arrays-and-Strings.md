## Chapter One: Arrays and Strings

#### Hash Tables 

A hash table is a data structure that maps keys to values for highly efficient lookup. In the simplest implementation, we use an array of linked lists and a hash code function. To insert a key (which might be a string or essentially any other data type) and value, we do the following: 

1. First, compute the key's hash code, which will usually be an `int` or `long`. Note that two different keys could have the same hash code. 
2. Then, map the hash code to an index in the array. This could be done with something like `hash(key) % array_length`. Two different hash codes could map to the same index. 
3. At this index, there is a linked list of keys and values. We store the key and value in this index. We must use a linked list because of collisions. 

If the number of collisions is very high, the worst case runtime is O(N), where `N` is the number of keys. However, the average lookup time is O(1) with a good implementation. Alternatively, we could implement the hash table with a balanced binary search tree, which gives an O(NlogN) runtime but with a less space. 

#### ArrayList and Resizable Arrays 

When we need an array-like data structure that offers dynamic resizing, we would use an `ArrayList`. An ArrayList is an array that resizes itself as needed while still providing O(1) access. A typical implementation is that when the array is full, the array doubles in size. Each doubling takes O(1) time, but happens so rarely that its amortized insertion time is still O(1). 

```java
ArrayList<String> merge(String[] words, String[] more) {
    ArrayList<String> sentence = new ArrayList<>();
    for (String w: words) sentence.add(w);
    for (String w: more) sentence.add(w);
    return sentence;
}
```

#### StringBuilder 

To concatenate a list of `n` strings of the same length `x`, we need O(xn<sup>2</sup>) . 

```java
String joinWords(String[] words) {
		String sentence = ""; 
  	for (String w: words) sentence = sentence + w; 
  	return sentence; 
}
```

This is because on each concatenation, a new copy of the string is created, and the two strings are copied over, character by character. The first iteration requires us to copy `x` characters, and the second `2x`, so the total runtime is O(x + 2x + ... + nx), which reduces to O(xn<sup>2</sup>). 

StringBuilder helps us avoid the problem because it creates a resizable array of all the strings, copyiing them back to a string only when necessary. 

```java
String joinWords(String[] words) {
		StringBuilder sentence = new StringBuilder();
  	for (String w: words) sentence.append(w); 
  	return sentence.toString(); 
}
```

#### Interview Questions 

**1.1 Is Unique:** Implement an algorithm to determine whether a string has all unique characters. Then achieve the same goal without using additional data structures. 

We assume the character set is ASCII. We create an array of boolean values, where the flag at index `i` indicates whether character `i` in the alphabet is contained in the string. The second time we see this character, we can immediately flag it as `false`. The time complexity is O(N), where `N` is the length of the string. The space complexity is O(1). 

```java
public boolean Q1S1(String s) {
    boolean[] char_set = new boolean[128];
    if (s.length() > 128) return false;
    for (int i = 0; i < s.length(); i++) {
        int val = s.charAt(i);
        if (char_set[val]) return false;
        char_set[val] = true;
    }
    return true;
}
```

If we cannot use additional data structures, we can do the following: 

1. Compare every character of the string to every other character of the string. This will take O(N<sup>2</sup>) time and O(1) space. 

```java
public boolean Q1S2(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
        for (int j = i + 1; j < s.length(); j++) {
            char curr = s.charAt(i), next = s.charAt(j);
            if (curr == next) return false;
        }
    }
    return true;
}
```

2. We can sort the string in O(NlogN) time and then linearly check the string for neighboring characters that are identical. 

```java
public boolean Q1S3(String s) {
    char[] charArray = s.toCharArray();
    Arrays.sort(charArray);
    for (int i = 0; i < charArray.length - 1; i++) {
        if (charArray[i] == charArray[i + 1]) return false;
    }
    return true;
}
```

---

**1.2 Check Permutation:** Given two strings, write a method to decide if one is a permutation of the other.  

We create a hash table which maps each character to its frequency. We increment the first string, then decrement through the second string. If the strings are permutations, then the array will be zeroes at the end. 

```java
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
```

---

**1.3 URLify:** Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. 



---

**1.4 Palindrome Permutation:** Given a string, write a function to check if it is a permutation of a palindrome. 

In order for a string to be a permutation of a palindrome, we need to have an even number of almost all characters, so that half can be on one side and half can be on the other side. At most one character (the middle character) can have an odd count. Therefore, we use a hash table to count how many times each character appears. Then, we iterate through the hash table and ensure that no more than one character has an odd count. 

```java
public static boolean Q4(String s) {
    int[] hashTable = new int[128];
    int count = 0;
    for (int i = 0; i < s.length(); i++) hashTable[s.charAt(i)]++;
    for (int i = 0; i < 128; i++) {
        if (hashTable[i] % 2 == 1) count++;
        if (count > 1) return false;
    }
    return true;
}
```

---

**1.5 One Away:** There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away. 