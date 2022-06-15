package programmers;

class mathLose {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] temp = new int[3];
		int[] count = new int[3];
		int cnt = 0;
		int[][] guess = {
				{1,2,3,4,5},
				{2,1,2,3,2,4,2,5},
				{3,3,1,1,2,2,4,4,5,5}};
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
