package programmers;

import java.util.LinkedList;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 * 
 * 문제 설명
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * 
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다. 
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요. 
 * 
 * 제한 사항
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 */

class TryDev {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[0];
        int[] temp= new int[100];
        
        int size = 0;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> speed = new LinkedList<>();
        int count = 0;
        
        for(int i = 0 ; i < progresses.length; i++) {
        	list.add(progresses[i]);
        	speed.add(speeds[i]);
        }
        
        while(!list.isEmpty()) {
        	count++;
        	int cnt = 0;
        	while((list.peek())+(speed.peek()*count) >= 100){
        		cnt++;
        		list.poll();
        		speed.poll();
        		if(list.isEmpty())
        			break;
        	}
        	if(cnt != 0) {
        		temp[size++] = cnt;
        	}
        }
        answer = new int[size];
        for(int i = 0 ; i < size; i++)
        	answer[i] = temp[i];
        
        return answer;
    }
}

public class FunctionDev {
	public static void main(String[] args) {
		int pro[] = {95, 90, 99, 99, 80, 99};
		int speed[] = {1, 1, 1, 1, 1, 1};
		
		TryDev tr = new TryDev();
		System.out.println(tr.solution(pro, speed));
	}
}
