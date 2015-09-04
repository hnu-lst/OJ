public class Solution {
    private String convert(int num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
            case 100:
                return "Hundred";
            case 1000:
                return "Thousand";
            case 1000000:
                return "Million";
            case 1000000000:
                return "Billion";
            default:
                return "Error";
        }
    }

    private String convertSmaller(int num) {//1000以内
        if (num == 0) return "Zero";
        if (num <= 20) return convert(num);
        if (num == 100) return "One Hundred";
        if (num % 10 == 0 && num < 100) return convert(num);
        String res = "";
        if (num / 1000 != 0)
            res += convert(num / 1000) + " Thousand ";
        num -= (num / 1000) * 1000;
        if (num == 0) return res;
        if (num / 100 != 0)
            res += convert(num / 100) + " Hundred";
        num -= (num / 100) * 100;
        if (num == 0) return res;
        if (num <= 20 && num != 0) {
            res += " " + convert(num);
            return res;
        }
        if (res.length() != 0)
            res += " " + convert((num / 10) * 10);
        else
            res += convert((num / 10) * 10);
        num -= ((num / 10) * 10);
        if (num != 0)
            res += " " + convert(num);
        return res;

    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        if (num / 1000000000 != 0) {
            res += convertSmaller(num / 1000000000) + " Billion";
            num -= (num / 1000000000) * 1000000000;
        }
        if (num / 1000000 != 0) {
            if (res.length() != 0)
                res += " ";
            res += convertSmaller(num / 1000000) + " Million";
            num -= (num / 1000000) * 1000000;
        }
        if (num / 1000 != 0) {
            if (res.length() != 0)
                res += " ";
            res += convertSmaller(num / 1000) + " Thousand";
            num -= (num / 1000) * 1000;
        }
        if (num == 0) return res;
        if (res.length() != 0)
            res += " ";
        res += convertSmaller(num);
        return res;
    }
}
