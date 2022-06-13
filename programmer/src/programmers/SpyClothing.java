package programmers;

import java.util.HashMap;

class Solutionsssss {
	HashMap<String, Integer> map = new HashMap<>();

	public int solution(String[][] clothes) {
		int answer = 1;

		
		//	�ش� ī�װ��� �� �����ֱ�
		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1])) {
				int num = map.get(clothes[i][1]);
				map.put(clothes[i][1], num+1);
			} else
				map.put(clothes[i][1], 1);
		}

		//	���� ���� ������
		for(String a : map.keySet()) {
			answer *= (map.get(a)+1);
		}
		
		
		return answer-1;
	}
}
public class SpyClothing {

}
