package programmers;

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
