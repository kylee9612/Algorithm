package programmers;

class Soltion{
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
        int sum = 0;
        
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i : queue1){
            sum1+=i;
        }
        for(int i : queue2){
            sum2+=i;
        }
        sum = sum1 + sum2;
        int target = sum/2;
        
        if(sum % 2 == 1)
            return -1;
        
        int cnt1 = 0;
        int cnt2 = 0;
      
        while(sum1 != target || sum2 != target) {
        	if(sum1 < target && cnt2 != queue2.length) {
        		sum2 -= queue2[cnt2];
        		sum1 += queue2[cnt2++];
        	}else if(sum1 > target){
        		cnt2++;
        	}
        	if(sum2 < target && cnt1 != queue1.length) {
        		sum1 -= queue1[cnt1];
        		sum2 += queue1[cnt1++];
        	}else if(sum2 > target){
        		cnt1++;
        	}
        	if(cnt1 == queue1.length && cnt2 == queue2.length && sum1 != target && sum2 != target) {
        		System.out.println("cnt1 : "+cnt1);
                System.out.println("cnt2 : "+cnt2);
                System.out.println("sum1 : "+sum1);
                System.out.println("sum2 : "+sum2);
        		return -1;
        	}
        }
        
        System.out.println("cnt1 : "+cnt1);
        System.out.println("cnt2 : "+cnt2);
        System.out.println("sum1 : "+sum1);
        System.out.println("sum2 : "+sum2);
        answer = cnt1+cnt2;
		
		return answer;
	}
}

public class MakeQueueSame {
	public static void main(String[] args) {
		Soltion sl = new Soltion();
		int[] queue1 = {1, 2, 1, 2};
		int[] queue2 = {1, 10, 1, 2};
		
		System.out.println(sl.solution(queue1, queue2));
	}
}
