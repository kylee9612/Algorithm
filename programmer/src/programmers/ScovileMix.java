package programmers;

import java.util.PriorityQueue;

class Mix{
	public int solution(int[] scoville, int K) {
        int answer = 0;
        final int size = scoville.length;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0 ; i < size ; i++) {
        	que.add((int)scoville[i]);
        }
        while(!que.isEmpty()&&que.peek() < K) {
        	if(que.size()==1) {
        		answer = -1;
        		break;
        	}
        	answer++;
        	int toMix1 = que.poll();
        	int toMix2 = que.poll()*2;
        	int result = toMix1+toMix2;
        	que.add(result);
        }
        return answer;
    }
}

public class ScovileMix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int[] num = {1, 2, 3, 9, 10, 12};
		int k = 7;
		Mix mix = new Mix();
		int tem = mix.solution(num, k);
		System.out.println(tem);
	}

}
