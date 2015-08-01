public class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) return false;
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!smap.containsKey(ch)) {
                smap.put(ch, 1);
            } else {
                smap.put(ch, smap.get(ch) + 1);
            }
            ch = t.charAt(i);
            if (!tmap.containsKey(ch)) {
                tmap.put(ch, 1);
            } else {
                tmap.put(ch, tmap.get(ch) + 1);
            }
        }
        Iterator it = smap.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            int sn = smap.get(key);
            int tn = -1;
            if (tmap.containsKey(key))
                tn = tmap.get(key);
            else
                return false;
            if (sn != tn) return false;
        }
        return true;
    }
}