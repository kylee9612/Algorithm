package programmers;

import java.util.ArrayList;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162?language=java

	n개의 음이 아닌 정수들이 있습니다. 
	이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
	예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	사용할 수 있는 숫자가 담긴 배열 numbers, 
	타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
	타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

	제한사항
	주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
	각 숫자는 1 이상 50 이하인 자연수입니다.
	타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 */

public class TargetNumber {
	private int target;
	private int answer = 0;
	private int numbers[];

	public int solution(int[] numbers, int target) {
		int sum = 0;
		this.target = target;
		this.numbers = numbers;
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i : numbers) {
			sum += i;
			arr.add(i);
		}

		if (sum == target)
			return 1;

		getTarget(arr, sum, 0);

		return answer;
	}

	// 전체 수의 합에서 numbers[i]*2 만큼 뺴주면서 비교하면 된다.
	private void getTarget(ArrayList<Integer> num, int sum, int idx) {
		for (int i = idx; i < num.size(); i++) {
			int prevSum = sum;
			ArrayList<Integer> newNum = new ArrayList<>();
			newNum.addAll(num);
			prevSum -= newNum.get(i) * 2;
			// 목표 숫자보다 작다면,
			// 현재 숫자는 냅두고 다음 숫자를 뺸다
			if (prevSum < target)
				continue;
			// 같다면 정답 + 1
			else if (prevSum == target)
				answer++;
			else {
				// 목표 숫자보다 크다면,
				// 해당 숫자를 배열에서 제거하고,
				// 뺸 값을 기준으로 다시한번 실행한다.
				newNum.remove(i);
				getTarget(newNum, prevSum, i);
			}
		}

	}

	// 프로그래머스 모법 답안 공부용
	
	public int solutions(int[] numbers, int target) {
		int answer = 0;
		//	배열 순서 0부터 시작, sum 또한 0
		answer = dfs(0, 0);
		return answer;
	}

	private int dfs( int n, int sum) {
		if (n == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return dfs( n + 1, sum + numbers[n]) + dfs(n + 1, sum - numbers[n]);
	}
	

	public static void main(String[] args) {
		int[] hi = { 4, 1, 2, 1 };

		System.out.println(new TargetNumber().solution(hi, 4));
	}
}
