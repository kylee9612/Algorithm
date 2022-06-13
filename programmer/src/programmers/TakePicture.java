package programmers;

import java.util.ArrayList;

class Picture {
	boolean check[] = new boolean[8];
	int answer=0;
	final char[] characs = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	final char[] syms = { '=', '<', '>' };
	
	ArrayList<Conditions> arr = new ArrayList<>();
	ArrayList<Character> stac = new ArrayList<>();
	
	public int solution(int n, String[] data) {
		// ["N~F=0", "R~T>2"]
		/*
		 * 입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data로 주어진다. 
		 * data의 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성되어 있다. 
		 * 제한조건은 아래와 같다.
		 * 
		 * 1 <= n <= 100 data의 원소는 다섯 글자로 구성된 문자열이다.
		 * 각 원소의 조건은 다음과 같다. 
		 * 첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다.
		 * {A, C, F, J, M, N, R, T} 
		 * 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다.
		 * 첫 번째 글자는 조건을 제시한 프렌즈, 세 번째 글자는 상대방이다.
		 * 첫 번째 글자와 세 번째 글자는 항상 다르다. 
		 * 두 번째 글자는 항상 ~이다. 네 번째 글자는 다음 3개 중 하나이다.
		 * {=, <, >} 각각 같음, 미만, 초과를 의미한다.
		 * 다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 
		 * 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
		 */

		//  contition class를 생성하여 조건 저장
		for(int i = 0 ; i < n ; i++) 
			arr.add(new Conditions(data[i].charAt(0),data[i].charAt(2),data[i].charAt(3),data[i].substring(4)));
		
    //  count 0 부터 깊이 탐색 시작
		dfs(0);
		
		return answer;
	}
	
	public void dfs(int count) {
		if(count == 8) {
      // count가 8 인경우는, 8가지 알파벳이 전부 입력되었을때이므로,
      // check 메소드를 통해 문자 arraylist를 검색하여, 조건에 충족하는지 확인후, 경우의 수를 1 추가해준다
			if(check(stac)) {
				answer++;
			}
		}
		
    //  friends가 총 8명이므로, 8번 반복
		for(int i = 0; i < 8; i++) {
			if(!check[i]) {
        //  사용하지 않은 알파벳인 경우, 알파벳을 문자 arraylist 끝에 추가한다
				check[i] = true;
				stac.add(characs[i]);
        //  count가 1 증가한 상태로 깊이탐색 재시작
				dfs(count+1);
        //  깊이탐색이 끝난후, 맨 마지막 문자를 삭제해 주며, 사용하지 않은것으로 돌려놓는다
				stac.remove(stac.size()-1);
				check[i] = false;
			}
		}
	}
	public boolean check(ArrayList<Character> friends) {
		for(int i = 0 ; i < arr.size(); i++) {
      //  가독성을 위해 따로 선언
			char index1 = arr.get(i).from;
			char index2 = arr.get(i).to;
			char sym = arr.get(i).sign;
      //  friend의 간격은 무조건 1씩 차이가 나므로, 사이에 아무도 없는 경우에도, 값은 1이 된다.
      //  예) (a,b)의 간격은 1이나, 사이에는 아무런 friend도 존재하지 않는다.
			int dis = arr.get(i).dis+1;
			int temp = Math.abs(friends.indexOf(index1)-friends.indexOf(index2));
			
      //  값을 충족하지 않는경우, 바로 리턴하여, 종료시켜 속도 향상
			if(sym == this.syms[0] && temp != dis) {
				return false;
			}
			else if(sym == this.syms[1] && temp >= dis) {
				return false;
			}
			else if(sym == this.syms[2] && temp <= dis) {
				return false;
			}
		}
		return true;
	}
}

class Conditions{
	char from;
	char to;
	char sign;
	int dis;
	
	public Conditions(char from, char to, char sign,String dis) {
		this.from = from;
		this.to = to;
		this.sign = sign;
		this.dis = Integer.parseInt(dis);
	}
}

public class TakePicture {
	public static void main(String[] args) {
		String[] str = {"N~F=0", "R~T>2"};
		int num = 2;
		Picture pic = new Picture();
		int count = pic.solution(num, str);
		
		System.out.println(count);
	}
}
