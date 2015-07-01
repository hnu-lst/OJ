public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int max = 1 << n;
        for (int i = 0; i < max; i++) {
            List<Integer> list = new LinkedList<Integer>();
            for (int j = 0; j < 32; j++) {
                if (((i >> j) & 1) == 1)
                    list.add(j + 1);
            }
            if (list.size() == k)
                result.add(list);
        }
        return result;
    }
}