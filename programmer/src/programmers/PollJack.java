package programmers;

import java.util.TreeMap;

class RemoveStone{
	int max;
	int num;
	int target;
	int curdistance;
	boolean check[];
	TreeMap<Integer, Integer> map;
	
	public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        num = rocks.length;
        check = new boolean[num];
        map = new TreeMap<>();
        target = distance;
        
        for(int i = 0 ; i < num; i++) 
        	map.put(i, rocks[i]);
        
        for(int i = 0 ; i < n; i++) {
        	dfs(i,0);
        }
        answer = max;
        return answer;
    }
	public void dfs(int number, int count) {
		if(curdistance == target) {
			int min = 0;
			for(int i = 0 ; i < num; i++) {
				if(!check[i] && map.get(i) < min || min == 0) {
					min = map.get(i);
				}
			}
			if(min > max)
				max = min;
		}
		
		for(int i = 0 ; i < num; i++) {
			if(!check[i] && map.get(i)+curdistance <= target) {
				check[i] = true;
				curdistance += map.get(i);
				dfs(number, count+1);
				curdistance -= map.get(i);
				check[i] = false;
			}
		}
	}
}

public class PollJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] roc = {2, 14, 11, 21, 17};
		int num = 2;
		int dis = 25;
		RemoveStone re = new RemoveStone();
		int cnt = re.solution(dis, roc, num);
		System.out.println(cnt);

	}

}
