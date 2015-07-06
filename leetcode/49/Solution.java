public class Solution {

    private List<String> result;
    private int length;
    private HashMap<String, List<String>> map;

    public List<String> anagrams(String[] strs) {
        result = new LinkedList<String>();
        length = strs.length;
        if (length == 0) return result;
        map = new HashMap<String, List<String>>();
        for (int i = 0; i < length; i++) {
            String key = getKey(strs[i]);
            if (!map.containsKey(key)) {
                List<String> list = new LinkedList<String>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(strs[i]);
            }
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            List<String> list = map.get(key);
            if (list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
    }

    private String getKey(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return String.valueOf(chs);
    }
}