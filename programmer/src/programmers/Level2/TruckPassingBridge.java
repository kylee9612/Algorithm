package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
 * 
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
 * 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
 *  무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 *  
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 * 
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
 *  다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
 *   이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요
 */

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