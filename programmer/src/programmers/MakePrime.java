package programmers;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

	제한사항
	numbers는 길이 1 이상 7 이하인 문자열입니다.
	numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */

public class MakePrime {
	private boolean visited[];
	private int size;
	private int answer;
	private ArrayList<String> list = new ArrayList<>();
	private HashMap<String,Boolean> map = new HashMap<>();

	public int solution(String numbers) {
        answer = 0;
        size = numbers.length();
        visited = new boolean[numbers.length()];
        
        for(int i =0 ; i < numbers.length(); i++) {
        	list.add((numbers.substring(i,i+1)));
        }
        
        for(int i =0 ;  i < size ;i++) {
        	dfs(i,list.get(i));
        }
        return answer;
    }
	
	private void dfs(int idx,String sub) {
		for(int i = 0; i < size; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sub+=list.get(i);
				checkPrime(sub);
				dfs(i+1,sub);
				sub = sub.substring(0,sub.length());
				visited[i] = false;
			}
		}
	}
	
	private void checkPrime(String temp) {
        if(temp.charAt(0) == '0' || map.containsKey(temp))
            return;
		int tmp = Integer.parseInt(temp);
		int cnt= 0;
		for(int i = 2 ; i < tmp; i++) {
			if(tmp%i == 0)
				cnt++;
		}
		if(cnt == 0) {
			map.put(temp, true);
			answer++;
		}
	}
	
	public static void main(String[] args) {
		String str = "011";
		System.out.println(new MakePrime().solution(str));;
	}
}
