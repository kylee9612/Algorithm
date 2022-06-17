package programmers;

import java.util.LinkedList;

class TryDev {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[0];
        int[] temp= new int[100];
        
        int size = 0;
        
        //	진행도와 속도를 저장하는 리스트 생성
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
        		//	에러방지
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
