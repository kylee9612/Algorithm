package programmers;

class Addition{
	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length;i++) {
        	if(signs[i])
        		answer+=absolutes[i];
        	else
        		answer-=absolutes[i];
        }
        return answer;
    }
}

public class AddingNegPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("holl");
		System.out.println("반가워요");
	}

}
