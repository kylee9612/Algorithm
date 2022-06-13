package programmers;

class Press{
    public String solution(int[] numbers, String hand) {
        String answer = "";
        final String right = "right";
        
        
        int x = 3; 
        int y = 3;
        boolean middleX = false;
        boolean middleY = false;
        
        for(int i = 0 ; i < numbers.length; i++) {
        	if((numbers[i]-1)%3 == 0) {
        		answer+="L";
        		x = (numbers[i]-1)/3; 
        		middleX = false;
        	}
        	else if(numbers[i]%3 == 0 && numbers[i] != 0) {
        		answer+="R";
        		y = (numbers[i]/3)-1;
        		middleY = false;
        	}
        	else if(numbers[i] == 0 || (numbers[i]+1)%3 == 0){
        		int position = ((numbers[i]+1)/3)-1;
        		if(numbers[i] == 0)
        			position = 3;

        		int tempX = Math.abs(x - position);
        		int tempY = Math.abs(y - position);
        		
        		if(!middleX)
        			tempX++;
        		if(!middleY)
        			tempY++;
        		
        		if(tempX > tempY) {
        			answer+="R";
        			y = position;
        			middleY = true;
        		}
        		else if(tempX < tempY) {
        			answer+="L";
        			x = position;
        			middleX = true;
        		}
        		else if(tempX == tempY) {
        			if(hand.equals(right)) {
        				answer+="R";
            			y = position;
            			middleY = true;
        			}
        			else {
        				answer+="L";
            			x = position;
            			middleX = true;
        			}
        		}
        		
        	}
        }
        return answer;
    }
}

public class PressingKeyPad {
	public static void main(String[] args) {
		int temp[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		Press pr = new Press();
		String str = pr.solution(temp, hand);
		System.out.println(str);
	}
}
