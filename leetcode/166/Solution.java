public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (num == 0) return "0";
        boolean negative = false;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            negative = true;
        if (num < 0) num = -num;
        if (den < 0) den = -den;
        String before = String.valueOf(num / den);
        num = num % den;
        if (num == 0) return negative ? "-" + before : before;
        String after = ".";
        num *= 10;
        HashMap<Long, Long> remainder  = new HashMap<>();
        long idx = 1;
        long loop = -1;
        while (true) {
            long r = num % den;
            long x = num / den;
            if (remainder.containsKey(num)) {
                loop = remainder.get(num);
                break;
            } else {
                remainder.put(num, idx);
            }
            after += x;
            num = r;
            num *= 10;
            idx++;
        }
        if (loop != -1)
            after = after.substring(0, (int) loop) + "(" + after.substring((int) loop) + ")";
        if (after.endsWith("(0)"))
            after = after.substring(0, after.length() - 3);
        return negative ? "-" + before + after : before + after;
    }
}