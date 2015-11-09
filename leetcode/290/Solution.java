public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int len = pattern.length();
        String[] strs = str.split(" ");
        if (strs.length != len) return false;
        HashMap<Character, String> c2s = new HashMap<>();
        HashMap<String, Character> s2c = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if (c2s.containsKey(c)) {
                if (!c2s.get(c).equals(s)) return false;
            } else {
                c2s.put(c, s);
            }
            if (s2c.containsKey(s)) {
                if (!s2c.get(s).equals(c)) return false;
            } else {
                s2c.put(s, c);
            }
        }
        return true;
    }
}