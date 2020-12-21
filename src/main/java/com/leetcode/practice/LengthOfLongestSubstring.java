package com.leetcode.practice;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    /**
     * 暴力解法
     */
    public int lengthOfLongestSubstring0(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            temp.clear();
            for (int j = i; j < s.length(); j++) {
                if (temp.contains(s.charAt(j))) {
                    break;
                }
                temp.add(s.charAt(j));
                max = Math.max(max, temp.size());
            }

        }
        return max;

    }

    public int lengthOfLongestSubstring1(String str) {

        int max = 0;

        Map<Character, Integer> window = new HashMap<>(16);

        for (int s = 0, e = 0; s < str.length(); s++) {

            if (window.containsKey(str.charAt(s))) {
                e = Math.max(e, window.get(str.charAt(s)) + 1);
            }
            window.put(str.charAt(s), s);
            max = Math.max(max, s - e + 1);
        }

        return max;

    }


    /**
     * 滑动窗口，map存储窗口重复的下一个下标索引
     */
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        Map<Character, Integer> window = new HashMap<>(16);

        for (int start = 0, end = 0; end < s.length(); end++) {

            if (window.containsKey(s.charAt(end))) {
                start = Math.max(window.get(s.charAt(end)), start);
            }
            max = Math.max(max, (end - start + 1));
            window.put(s.charAt(end), end + 1);
        }

        return max;

    }

}
