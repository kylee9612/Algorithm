package programmers;

class Solutionsss {
    public int solution(int n) {
        int answer = 0;
        
        int temp = n;
        String str = "";
        while(temp > 0) {
        	str = (temp%3) + str;
        	temp/=3;
        }
        String st = "";
        System.out.println(str);
        for(int i = 0 ; i < str.length();i++)
        	st+=str.charAt(str.length()-i-1);
        answer = Integer.parseInt(st,10);
        
        return answer;
    }
}

public class Programmers_queen {

}
