public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int[][] edit = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 && j == 0) {
                    edit[i][j] = 0;
                } else if (i == 0) {
                    edit[i][j] = j;
                } else if (j == 0) {
                    edit[i][j] = i;
                } else {
                    edit[i][j] = Math.min(edit[i - 1][j] + 1, Math.min(edit[i][j - 1] + 1, edit[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)));
                }
            }
        }
        return edit[len1][len2];
    }
}