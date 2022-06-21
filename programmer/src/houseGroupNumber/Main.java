package houseGroupNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
 * https://www.acmicpc.net/problem/2667
 * 
 * <그림 1>과 같이 정사각형 모양의 지도가 있다.
 * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 
 * 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * 
 * 출력
 * 첫 번째 줄에는 총 단지수를 출력하시오. 
 * 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

 */

class HouseGrouping {
	private BufferedReader br;
	//	단지의 크기를 담을 배열리스트
	private ArrayList<Integer> groupList = new ArrayList<>();
	//	방문했는지 확인하기 위한 배열
	private boolean isCheck[][];
	//	그림을 그리기 위한 지도
	private int[][] map;
	private int size;

	//	생성시 프로그램 실행
	public HouseGrouping() {
		run();
	}

	private void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			size = Integer.parseInt(br.readLine());
			drawMap();
			int count = grouping();
			System.out.println(count);
			Collections.sort(groupList);
			for (Integer i : groupList)
				System.out.println(i);
			br.close();
		} catch (Exception e) {
		}
	}

	//	지도에 데이터 받기
	private void drawMap() {
		map = new int[size][size];
		isCheck = new boolean[size][size];
		try {
			for (int i = 0; i < size; i++) {
				String str;
				str = br.readLine();
				for (int j = 0; j < size; j++)
					map[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//	완전탐색
	private int findGroup(int x, int y, int count) {
		for (int i = -1; i <= 1; i++) {
			//	아웃바운드 방지 if
			if (x + i < size && x + i >= 0) {
				//	해당 위치가 1이면서, 지나가지 않았을 경우 (false 인경우)
				if (map[y][x + i] == 1 && !isCheck[y][x + i]) {
					count++;
					isCheck[y][x + i] = true;
					count = findGroup(x + i, y, count);
				}
			}
			//	아웃바운드 방지 if
			if (y + i < size && y + i >= 0) {
				//	해당 위치가 1이면서, 지나가지 않았을 경우 (false 인경우)
				if (map[y + i][x] == 1 && !isCheck[y + i][x]) {
					count++;
					isCheck[y + i][x] = true;
					count = findGroup(x, y + i, count);
				}
			}
		}
		return count;
	}

	private int grouping() {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1) {
					int count = findGroup(j, i, 0);
					if (count != 0) {
						cnt++;
						groupList.add(count);
					}
				}
			}
		}
		return cnt;
	}
}

public class Main {
	public static void main(String[] args) {
		new HouseGrouping();
	}

}
