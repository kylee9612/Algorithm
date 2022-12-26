package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
 * 
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 */

import java.util.HashMap;
 
class Solutionss {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>(); // 전체 장르/재생횟수 저장
		HashMap<String, Integer> best1 = new HashMap<>(); // 장르의 best 재생횟수 저장
		HashMap<String, Integer> best2 = new HashMap<>(); // 장르의 best 인덱스
		HashMap<String, Integer> best1_1 = new HashMap<>(); // 장르의 두번째 best 재생횟수 저장
		HashMap<String, Integer> best2_1 = new HashMap<>(); // 장르의 두번째 best 인덱스

		int count = 0;

		for (int i = 0; i < plays.length; i++) {
			if (map.containsKey(genres[i])) {
				// 장르가 이미 추가되어있으면, 값을 추가해준다
				map.put(genres[i], map.get(genres[i]) + plays[i]);
				if (best1.get(genres[i]) < plays[i]) {
					//	best1보다 재생횟수가 많다면
					//	best1을 best2로 옮겨주고, best1에 새로운 정보를 저장
					best2.put(genres[i], best1.get(genres[i]));
					best2_1.put(genres[i], best1_1.get(genres[i]));

					best1.put(genres[i], plays[i]);
					best1_1.put(genres[i], i);
				} else if (!best2.containsKey(genres[i])) {
					// best2가 아직 없다면, best2에 저장
					best2.put(genres[i], plays[i]);
					best2_1.put(genres[i], i);
				} else if (best2.get(genres[i]) < plays[i]) {
					//	best2보다 재생횟수가 많으면 best2에 저장
					best2.put(genres[i], plays[i]);
					best2_1.put(genres[i], i);
				}
			} else {
				//	기존에 장르가 존재하지 않으면
				map.put(genres[i], plays[i]);
				best1.put(genres[i], plays[i]);
				best1_1.put(genres[i], i);
			}
		}
		String str = map.keySet().toString();
		str = str.substring(1, str.length() - 1);
		String[] temp = str.split(", ");
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.size(); j++) {
				if (map.get(temp[i]) > map.get(temp[j])) {
					String tmp = temp[i];
					temp[i] = temp[j];
					temp[j] = tmp;
				}
			}
		}
		count = map.size();
		for (int i = 0; i < map.size(); i++) {
			if (best2_1.containsKey(temp[i]))
				count++;
		}
		int[] answer = new int[count];
		count = 0;

		for (int i = 0; i < map.size(); i++) {
			answer[count++] = best1_1.get(temp[i]);
			if (best2_1.containsKey(temp[i])) {
				answer[count++] = best2_1.get(temp[i]);
			}
		}

		return answer;
	}
}

public class Music_Genre {
	public static void main(String[] args) {

		Solutionss so = new Solutionss();
		String[] genre = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] answer = so.solution(genre, plays);
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}
}
