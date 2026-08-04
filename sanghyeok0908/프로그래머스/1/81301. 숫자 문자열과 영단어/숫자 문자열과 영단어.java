class Solution {
    public int solution(String s) {
        String answer = "";
        String num = "";
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {     
            if (Character.isDigit(arr[i])) {
                answer += arr[i];
                num = "";
                continue;
            }
            
            num += arr[i];
            
            String changeNum = func(num);
            if (changeNum != null) {
                answer += changeNum;
                num = "";   
            }
        }
        return Integer.parseInt(answer);
    }
    
    String func(String str) {
        if (str.equals("zero")) {
            return "0";
        }
        if (str.equals("one")) {
            return "1";
        }
        if (str.equals("two")) {
            return "2";
        }
        if (str.equals("three")) {
            return "3";
        }
        if (str.equals("four")) {
            return "4";
        }
        if (str.equals("five")) {
            return "5";
        }
        if (str.equals("six")) {
            return "6";
        }
        if (str.equals("seven")) {
            return "7";
        }
        if (str.equals("eight")) {
            return "8";
        }
        if (str.equals("nine")) {
            return "9";
        }
        return null;
    }
}