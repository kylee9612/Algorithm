package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 * 
 * 수포자는 수학을 포기한 사람의 준말입니다. 
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... 
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 *  가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요. 
 */

class mathLose {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] temp = new int[3];
		int[] count = new int[3];
		int cnt = 0;
		int[][] guess = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
		for(int i = 0 ; i < answers.length;i++) {
			for(int j = 0 ; j < count.length;j++) {
				if(guess[j][i%guess[j].length] == answers[i])
					count[j]++;
			}
		}
		int max = 0;
		for(int i = 0 ; i < 3; i++) {
			if(count[i] > count[max])
				max = i;
		}
		for(int i = 0 ; i < 3; i++) {
			if(count[max] == count[i])
				temp[cnt++] = i;
		}
		answer = new int[cnt];
		for(int i = 0 ; i < cnt; i++)
			answer[i] = temp[i]+1;
		
		return answer;
	}
}

public class mathLoser {

}
