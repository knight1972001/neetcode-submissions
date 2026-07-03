class Solution {
    public String intToRoman(int num) {
        String[][] symList = {
            {"I","1"}, {"IV","4"}, {"V","5"}, {"IX","9"}, 
            {"X","10"}, {"XL","40"}, {"L","50"}, {"XC","90"}, 
            {"C","100"}, {"CD","400"}, {"D","500"}, {"CM","900"}, 
            {"M","1000"}
        };

        StringBuilder res = new StringBuilder();

        for(int i = symList.length - 1; i >= 0; i--){
            String sym = symList[i][0];
            int value = Integer.parseInt(symList[i][1]);
            int count = num / value;
            if (count > 0){
                res.append(sym.repeat(count));
            }
            num %= value;
        }

        return res.toString();
    }
}