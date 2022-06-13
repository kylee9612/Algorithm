package programmers;

import java.util.LinkedList;

class TrucksToGo{
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int size = truck_weights.length;
        int curWeight = 0;
        int idx = 0;
        LinkedList<int[]> list = new LinkedList<>();
        
        //	첫번째 트럭은 미리 다리위로 올려준다
        list.add(new int[] {truck_weights[0],1});
        curWeight = truck_weights[0];
        
        //	리스트가 비는경우는 모든 트럭이 지나갔을때 뿐이다
        while(!list.isEmpty()) {
        	//	트럭의 위치가 다리의 길이와 같다면,
        	//	현재 무게를 뺴주고, queue에서또한 뺴준다
        	if(list.get(0)[1] == bridge_length) {
        		curWeight -= list.get(0)[0];
        		list.poll();
        	}
        	//	리스트의 길이만큼 순회하여, 트럭의 위치를 추가해준다
        	for(int i = 0 ; i < list.size(); i++) {
        		list.get(i)[1]++;
        	}
        	
        	//	1. 트럭인덱스가 전체 트럭의 갯수보다 작을떄
        	//	2. 리스트의 크기가 다리의 길이보다 작을때 (다리의 길이보다 많은 트럭이 올라가는걸 방지)
        	//	3. 현재 무게 + 다음 트럭의 무게가 다리의 무게한도 이하일때
        	//	1~3의 조건을 충족하였을 때만 트럭을 추가한다.
        	if(idx + 1 < size && list.size() < bridge_length && curWeight + truck_weights[idx+1] <= weight) {
        		curWeight += truck_weights[++idx];
        		list.add(new int[] {truck_weights[idx],1});
        	}
        	answer++;
        }
        
        return answer;
    }
}

public class TruckPassingBridge {

	public static void main(String[] args) {
		int bridge = 100;
		int weight = 100;
		int[] truck = {10,10,10,10,10,10,10,10,10,10};
		TrucksToGo tr = new TrucksToGo();
		int answer = tr.solution(bridge, weight, truck);
		System.out.println(answer);
	}
}