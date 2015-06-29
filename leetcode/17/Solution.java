public class Solution {
    private static String[] panel = {
            " ",	/*0*/
            "",		/*1*/
            "abc",	/*2*/
            "def",	/*3*/
            "ghi",	/*4*/
            "jkl",	/*5*/
            "mno",	/*6*/
            "pqrs",	/*7*/
            "tuv",	/*8*/
            "wxyz"	/*9*/
    };
    private static List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new LinkedList<String>();
        digits = digits.replaceAll("1", "");
        if (digits.length() == 0) return result;
        dfs(digits, 0, "");
        Collections.sort(result);
        return result;
    }

    private void dfs(String digits, int pos, String pre) {
        int len = digits.length();
        if (pos == len) {
            result.add(pre);
            return;
        }
        int num = panel[digits.charAt(pos) - '0'].length();
        for (int i = 0; i < num; i++) {
            dfs(digits, pos + 1, pre + panel[digits.charAt(pos) - '0'].charAt(i));
        }
    }
}