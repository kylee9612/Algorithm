package programmers;

import java.util.Stack; 

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        //	size = board의 길이
        final int size = board.length;
        
        //	스택 컬렉션 선언
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < moves.length; i++) {
        	for(int j = 0 ; j < size; j++) {
        		//	moves = 크레인의 인덱스
        		//	크레인은 board 인덱스 + 1의 값을 가지고 있으므로,
        		//	-1 을 해준다
        		//	j는 높이
        		if(board[j][moves[i]-1] != 0) {
        			//	stack이 비어있지 않거나 -> 오류 방지용.
        			//	비어있는 상태에서 peek || pop을 실행하면 오류발생
        			//	스택의 맨 윗 부분(peek)이 지금 뽑은 인형과 같다면
        			//	pop으로 현재 스택 맨 윗부분을 삭제해준다
        			if(!st.empty() && st.peek()==board[j][moves[i]-1]) {
        				st.pop();
        				answer+=2;
        			}
        			//	비어있거나, 같지 않다면 그냥 스택위에 쌓아준다
        			else 
        				st.push(board[j][moves[i]-1]);
        			//	크레인으로 뽑은 위치는 0으로 바꾸어주며
        			//	break로 계속해서 아래로 내려가지않도록 반복문을 탈출
        			board[j][moves[i]-1] = 0;
        			break;
        		}
        	}
        }
        return answer;
    }
}

public class CraneDollPicking {
	public static void main(String[] args) {
		Solution so = new Solution();
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}	
				};
		int[] moves = {1,5,3,5,1,2,1,4};	// 4, 3, 1, 1, 3, 
		
		System.out.println(so.solution(board, moves));
	}
}
