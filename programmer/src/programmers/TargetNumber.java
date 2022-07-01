package programmers;

import java.util.LinkedList;
import java.util.Queue;

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
	private boolean check[];
	private int target;
	int numbers[];
	int size;
	int answer = 0;
	
	public int solution(int[] numbers, int target) {
        size = numbers.length;
        this.target = target;
        this.numbers = numbers;
        check = new boolean[size];
        int sum = 0;
        for(int i : numbers)
        	sum += i;
        if(sum == target)
        	return 1;
        for(int i = 0; i < size; i++) {
        	dfs(i,-numbers[i]);
        	
        }
        
        return answer;
    }
	
	private void dfs(int idx,int value) {
		check[idx] = true;
		for(int i = 0 ; i < size; i++) {
			if(!check[i]) {
				dfs(i,value-numbers[i]);
				check[i] = false;
			}
			value += numbers[i];
			if(i == size -1 && value == target)
				answer ++;
		}
	}
}
