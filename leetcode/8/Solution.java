public class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        int len = str.length();
        if (len == 0) return 0;
        boolean negative = false;
        if (str.charAt(0) == '+') {
            if (len == 1) return 0;
            if (!isDigit(str.charAt(1))) return 0;//第一位必须为数字
            int idx = first(str, 2);
            str = str.substring(1, idx);
        } else if (str.charAt(0) == '-') {
            negative = true;
            if (len == 1) return 0;
            if (!isDigit(str.charAt(1))) return 0;//第一位必须为数字
            int idx = first(str, 2);
            //System.out.println(idx);
            str = str.substring(1, idx);
        } else {
            //if (len == 1) return 0;
            if (!isDigit(str.charAt(0))) return 0;//第一位必须为数字
            int idx = first(str, 1);
            str = str.substring(0, idx);
            //System.out.println(str);
        }
        //到这一步，符号位错误的数都已经返回，且已经去掉符号位
        len = str.length();
        if (len == 0) return 0;//只有一个符号位则返回0
        str = trimZero(str);//
        //到这一步只剩下数字位
        String maxString = String.valueOf(Integer.MAX_VALUE);
        String minString = String.valueOf(Integer.MIN_VALUE).substring(1);
        //判断str的字面值是否超过限制
        if (negative) {
            if (minString.length() < str.length()) return Integer.MIN_VALUE;
            if (minString.length() == str.length()) {
                if (minString.compareTo(str) < 0) return Integer.MIN_VALUE;
            }
            if (str.equals("2147483648")) return -2147483648;
        } else {
            if (maxString.length() < str.length()) return Integer.MAX_VALUE;
            if (maxString.length() == str.length()) {
                if (maxString.compareTo(str) < 0) return Integer.MAX_VALUE;
            }
        }
        return negative ? -Integer.parseInt(str) : Integer.parseInt(str);
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private int first(String s, int from) {
        if (s == null || s.length() == 0) return 0;
        for (int i = from; i < s.length(); i++)
            if (!isDigit(s.charAt(i))) return i;
        return s.length();
    }

    private boolean allZero(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != '0') return false;
        return true;
    }

    private String trimZero(String str) {//去掉先导0，如果全是0则只剩一个0
        if (allZero(str)) return "0";
        int len = str.length();
        int idx = 0;//第一个非0的数的位置
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != '0') {
                idx = i;
                break;
            }
        }
        return str.substring(idx);
    }
}