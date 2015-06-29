public class Solution {
     public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        int shift = n - m;
        for (int i = 0; i < 32; i++) {//判断每一位
            if (bitOf(m, i) == 0) continue;
            int period = (1 << i);
            if (lower(m, i - 1) + shift >= period)
                result = setBitOf(result, i, 0);
        }
        return result;
    }

    private int lower(int n, int i) {//包括第i位
        int x = 0;
        for (int j = 0; j <= i; j++) {
            x = setBitOf(x, j, 1);
        }
        return n & x;
    }

    private int bitOf(int n, int i) {
        return (n >> i) & 1;
    }

    private int setBitOf(int n, int i, int set) {
        if (set == 0) {//将该位置为0，与上0,与1不变
            n = n & (~(1 << i));
        } else {      //将该位置为1，或上1,或0不变
            n = n | (1 << i);
        }
        return n;
    }
}