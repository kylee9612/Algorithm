package programmers;

class Solutionsss {
	private boolean board[][];
	private boolean check[];
	private int max;
	private int x;
	private int y;
	
    public int solution(int n) {
        board = new boolean[n][n];
        check = new boolean[n];
        max = n;
        int answer = 0;
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int n) {
    	for(int i = n; i < max; i++) {
    		if(!check[i]) {
    			check[i] = true;
    			dfs(i+1);
    		}
    	}
    }
}

public class Programmers_queen {

}
