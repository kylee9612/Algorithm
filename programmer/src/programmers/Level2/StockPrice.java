package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 * 
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 */
 
import java.util.Stack;

class CountPrice {
	public int[] solution(int[] prices) {
		final int size = prices.length;
		int[] answer = new int[size];

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				answer[i]++;
				if (prices[i] > prices[j])
					break;
			}
		}
		return answer;
	}
}

class CountPrice2{
	//	Using stack
	public int[] solution(int[] prices) {
		final int size = prices.length;
		int answer[] = new int[size];
		Stack <Integer> stock = new Stack<>();
		
		//	스택에 모든 값을 역순으로 할당
		for(int i = size-1; i >=0; i--)
			stock.push(prices[i]);
		
		int count = 0;
		
		//	스택이 비워질때까지 반복
		while(!stock.isEmpty()) {
			//	맨위에있는 스택부터 꺼내오면서 비교하기
			int curPrice = stock.pop();
			//	현재 위치부터 반복문 시작
			for(int i = count; i < size ; i++) {
				//	현재 가격이 해당 위치의 가격보다 높은 경우
				//	정답 배열에 몇초가 걸렸는지 작성한다.
				//	또한 중복으로 돌아가는것을 방지하기 위해 break 사용
				if(curPrice > prices[i]) {
					answer[count] = i - count;
					break;
				}
				//	i가 전체 배열크기의 마지막 인덱스에 도달한 경우
				//	현재위치 - 시작위치를 정답배열에 작성
				if(i == size-1)
					answer[count] = i - count;
			}
			count++;
		}
		return answer;
	}
}

public class StockPrice {
	public static void main(String[] args) {
		CountPrice2 co = new CountPrice2();
		int [] prices = {1, 2, 3, 2, 3};
		int[] temp = co.solution(prices);
		for(int i = 0 ; i < temp.length ; i++)
			System.out.println(temp[i]);
	}
}
