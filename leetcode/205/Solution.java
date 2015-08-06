public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (t.length() != len) return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < len; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (!map.containsKey(sch)) {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    if (map.get(it.next()) == tch) return false;
                }
                map.put(sch, tch);
            } else {
                if (map.get(sch) != tch) return false;
            }
        }
        return true;
    }
}