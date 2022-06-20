package programmers; 

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */

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
