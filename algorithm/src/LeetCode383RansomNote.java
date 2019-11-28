/*
Given an arbitrary ransom note string and another string containing 
letters from all the magazines, write a function that will return 
true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public class LeetCode383RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[52];
        for (char c : magazine.toCharArray()) {
            if (c >= 'a' && c <= 'z') cnt[c - 'a']++;
            else if (c >= 'A' && c <= 'Z') cnt[c - 'A' + 26]++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            int idx = -1;
            if (c >= 'a' && c <= 'z') {
                idx = c - 'a';
            } else if (c >= 'A' && c <= 'Z') {
                idx = c - 'A' + 26;
            }
            
            if (--cnt[idx] < 0) return false;
        }
        
        return true;
    }
}