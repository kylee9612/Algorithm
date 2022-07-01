package programmers;

import java.util.ArrayList;

/***************************************************************/
/*	https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
	네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 
	예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 
	컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 
	컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 
	따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

	컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 
	네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

	제한사항

	컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
	각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
	i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
	computer[i][i]는 항상 1입니다.					
/***************************************************************/

class Computer {
	//	컴퓨터 객체에 연결의 유무를 알 수 있는 배열 선언
	private boolean con[];

	public Computer(int n) {
		con = new boolean[n];
	}

	public boolean isCon(int n) {
		return con[n];
	}

	public void setCon(int n) {
		con[n] = true;
	}
}

public class FindComputer {
	private int answer=0;
	private boolean com[];
	private int size;
	private ArrayList<Computer> arr = new ArrayList<>();

	public int solution(int n, int[][] computers) {
		com = new boolean[n];
		size = n;
		for (int i = 0; i < n; i++) {
			arr.add(new Computer(n));
			for (int j = 0; j < n; j++) {
				//	연결 되었다고 표시
				if (computers[i][j] == 1)
					arr.get(i).setCon(j);
			}
		}
		
		//	자기 자신 외, 아무것도 연결되어있지 않거나
		//	이미 이어져 있는 컴퓨터만 연결되어 있는경우를 방지하기 위해
		//	dfs를 n번만큼 반복하되, 연결되지 않은 경우만 dfs 실행
		for(int i = 0 ;i < n; i ++) {
			if(!com[i]) {
				dfs(i);
				answer++;
			}
		}
		return answer;
	}

	private void dfs(int k) {
		for (int i = 0; i < size; i++) {
			//	연결 되어있다면, 다른 연결되어있는
			//	컴퓨터도 찾으러 가기 위해 dfs 실행
			if (!com[i] && arr.get(k).isCon(i)) {
				com[i] = true;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		int i[][] = { 
				{ 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1 }, 
				{ 1, 0, 1, 1 } };

		System.out.println(new FindComputer().solution(4, i));
	}
}
