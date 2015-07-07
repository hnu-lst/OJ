public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> seq = new ArrayList<Integer>();
        Arrays.sort(candidates);
        doSum(candidates, target, res, seq, 0, -1);
        return res;
    }

    private void doSum(int[] candidates, int target, List res, List seq, int sum, int start) {
        if (sum == target && !res.contains(seq))
            res.add(new ArrayList(seq));//机智
        if (sum < target) {
            for (int i = start + 1; i < candidates.length; i++) {
                sum += candidates[i];
                if (sum > target)
                    break;
                else {
                    seq.add(candidates[i]);
                    doSum(candidates, target, res, seq, sum, i);
                    seq.remove(seq.size() - 1);
                    sum -= candidates[i];
                }
            }
        }
    }
}