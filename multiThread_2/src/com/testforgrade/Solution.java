package com.testforgrade;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 15:07 2021/4/8
 * @ Version:
 */
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();

        char[] cs = new char[len];
        int j = 0;
        int end;
        for (int i = 0; i < len; i += 2 * k) {
            int p;
            //0~k
            int right = i + k > len ? len - 1 : i + k - 1;
            for (p = right; p >= i; p--) {
                cs[j++] = s.charAt(p);
            }
            //k~2k
            end = len > (i + 2) * k ? (i + 2 * k) : len;
            for (p = right + 1; p < end; p++) {
                cs[j++] = s.charAt(p);
            }
        }
        return cs.toString();
    }
}
