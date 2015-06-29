public class Solution {
     public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        int shift = n - m;
        for (int i = 0; i < 32; i++) {//�ж�ÿһλ
            if (bitOf(m, i) == 0) continue;
            int period = (1 << i);
            if (lower(m, i - 1) + shift >= period)
                result = setBitOf(result, i, 0);
        }
        return result;
    }

    private int lower(int n, int i) {//������iλ
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
        if (set == 0) {//����λ��Ϊ0������0,��1����
            n = n & (~(1 << i));
        } else {      //����λ��Ϊ1������1,��0����
            n = n | (1 << i);
        }
        return n;
    }
}