package Virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2606
 * 
 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 
 * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 * 
 * 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
 * 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
 * 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
 * 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
 * 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에는 컴퓨터의 수가 주어진다. 
 * 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
 * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
 * 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
 * 
 * 예제 입력 1 
 * 7
 * 6
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 * 
 * 예제 출력 1 
 * 4
 */

class Computer{
	private boolean isCon [];
	
	public Computer(int size) {
		isCon = new boolean[size];
	}
	
	public boolean isCon(int idx) {
		return isCon[idx-1];
	}
	
	public void setCon(int idx) {
		isCon[idx-1] = true;
	}
}

class Virus {
	private boolean com[];
	private int count;
	private int comSize;
	ArrayList <Computer> comList = new ArrayList<>();
	public int solution() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			comSize = Integer.parseInt(br.readLine());
			
			for(int i = 0 ; i < comSize; i++)
				comList.add(new Computer(comSize));
			
			int loop = Integer.parseInt(br.readLine());
			com = new boolean[comSize];
			for(int i = 0; i < loop; i++) {
				String temp = br.readLine();
				StringTokenizer st = new StringTokenizer(temp," ");
				int first =  Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				comList.get(first-1).setCon(second);
				comList.get(second-1).setCon(first);
			}
			com[0] = true;
			dfs(0);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	private void dfs(int idx) {
		for(int i = 0 ; i < comSize; i++) {
			if(comList.get(idx).isCon(i+1) && !com[i]) {
				System.out.printf("%d : %d is hacked\n",idx+1,i+1);
				count++;
				com[i] = true;
				dfs(i);
			}
		}
	}
}

public class Main{
	public static void main(String[] args) {
		Virus vi = new Virus();
		int count = vi.solution();
		System.out.println(count);
	}
}
