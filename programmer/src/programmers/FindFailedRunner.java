package programmers; 

import java.util.HashMap;

class Solutions {
	public String solution(String[] participant, String[] completion) {
		//	이름, 해당이름의 숫자
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String answer = "";

		for (String a : participant) {
			//	key가 이미 존재하면, value값을 +1
			if(map.containsKey(a)) {
				int count = map.get(a);
				map.put(a, ++count);
			}
			//	존재하지 않으면 value는 1
			else
				map.put(a, 1);
		}
		
		for(String a : completion) {
			//	value가 1보다 클 경우 value를 줄여준다
			if(map.get(a) > 1) {
				int count = map.get(a);
				map.put(a, --count);
			}
			//	value가 1이면 key 삭제
			else
				map.remove(a);
		}
		
		//	존재하는 키를 string으로 반환
		answer = map.keySet().toString().substring(1);
		//	특수문자 제거
		answer = answer.substring(0,answer.length()-1);

		return answer;
	}
}

public class FindFailedRunner {
	public static void main(String[] args) {
		Solutions so = new Solutions();
		String[] temp = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] temp2 = { "josipa", "filipa", "marina", "nikola" };

		System.out.println(so.solution(temp, temp2));
	}
}
