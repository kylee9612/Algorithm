package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
 * 
 * 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
 * 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. 
 * (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
 * 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
 */
 
class Color {
	int maxY;
	int maxX;
	int[][] picture;
	boolean check[][];
	
    public int[] solution(int m, int n, int[][] picture) {
    	//	나뉘어진 면적을 세는 용도의 변수
        int numberOfArea = 0;
        //	가장 큰 면적을 저장하는 변수
        int maxSizeOfOneArea = 0;
        
        //	주어진 보드의 넓이
        this.maxX = n;
        //	주어진 보드의 길이
        this.maxY = m;
        //	주어진 보드
        this.picture = picture;
        //	보드의 크기만큼 boolean형 2차원 배열 선언하여
        //	해당 위치를 체크했는지 확인하는 용도
        this.check = new boolean[maxY][maxX];
        
        for(int i = 0 ; i < m; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		//	0은 빈 곳으로 생각하고 카운트하지 않는다.
        		if(picture[i][j] == 0)
        			check[i][j] = true;
        		//	위치가 0이 아니면서		(위의 if문에서 이미 체크한 후 넘어왔으므로 다시 써줄 필요 없다
        		//	해당 위치를 지나가지 않은경우
        		else if(!check[i][j]) {
        			//	면적 갯수 추가
        			numberOfArea++;
        			//	해당 위치를 지나갔다고 체크
        			check[i][j] = true;
        			//	i -> y좌표
        			//	j -> x좌표
        			//	현재 위치를 포함하여 면적 세는 것을 1부터 시작
        			//	현재 위치의 번호를 메소드에게 준다
        			int count = getArea(i,j,1,picture[i][j]);
        			//	count가 현재까지 지나간 가장 큰 면적보다 큰경우,
        			if(count > maxSizeOfOneArea)
        				maxSizeOfOneArea = count;
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int getArea(int y, int x,int count, int given) {
    	//	본인 자리는 지나가지 않는다.
    	for(int i = -1; i <= 1; i+=2) {
    		//	Out Bound 확인용 조건문
    		if(i+y >=0 && i+y < maxY) {
    			//	위 아래 좌표의 숫자가, 현재 위치의 숫자와 같으면서,
    			//	해당 위치를 지나가지 않은경우
    			//	해당 위치를 기점으로 메소드를 다시 불러온다
    			if(picture[i+y][x] == given && !check[i+y][x]) {
    				check[i+y][x] =true;
    				count++;
    				try {
    					Thread.sleep(1000);
    					print();
    				} catch (Exception e) {
    					// TODO: handle exception
    				}
    				count = getArea(y+i,x,count,given);
    			}
    		}
    		//	Out Bound 확인용 조건문
    		if(i+x >= 0 && i+x < maxX) {
    			//	마찬가지로 좌 우를 검사한다.
    			if(picture[y][x+i] == given && !check[y][x+i]) {
    				check[y][x+i] =true;
    				count++;
    				try {
    					Thread.sleep(1000);
    					print();
    				} catch (Exception e) {
    					// TODO: handle exception
    				}
    				count = getArea(y,x+i,count,given);
    			}
    		}
    	}
    	//	면적의 넓이를 return한다
    	return count;
    }
    void print() {
    	for(int i = 0 ; i < maxY; i++) {
    		for(int j = 0;  j < maxX; j++) {
    			if(!check[i][j])
    				System.out.print("0 ");
    			else
    				System.out.printf("%d ",picture[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println("===========================");
    }
}

public class ColoringBook {
	public static void main(String[] args) {
		int[][] map = {
				{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};
		int m = 6;
		int n = 4;
		Color co = new Color();
		co.solution(m, n, map);
	}
}
