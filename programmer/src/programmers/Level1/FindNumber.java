package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/86051?language=java
 * 
 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 */

class Find{
	public int solution(int[] numbers) {
        int answer = 0;
        for(int i = 0 ; i < 10;i++) {
        	answer+=i;
        }
        for(int i = 0; i < numbers.length; i++)
        	answer -= numbers[i];
        
        return answer;
    }
}

public class FindNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
