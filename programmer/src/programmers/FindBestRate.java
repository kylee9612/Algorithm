package programmers;

/*
 * 	주어진 자본금 (capital)을 가지고 최대의 이익을 가질 수 있도록 해야한다.
 * 
 * 	조건)
 * 	각 상품당 최대 투자금액 및 최소 금액이 정해져 있으며, 이율도 각자 다르다
 * 	
 * 	예제)
 * 	자본금이 1,000,000원이 있고,
 * 	투자상품 3가지가 있다
 * 	번호		최소금액		최대금액		이율
 * 	1		500,000		900,000		50%
 * 	2		20,000		50,000		38%
 * 	3		200,000		200,000		40%
 * 	
 * 	이때 상품 1에 90만원을 투자하면 1년뒤 이익은 45만원이지만,
 * 	상품 1에 80만원 상품 3에 20만원을 투자하면 이익은 48만원이 된다.
 * 	
 * 	최대의 이율을 가질 수 있는 투자방법을 찾아, 최대 이율을 출력하시오.
 * 
 * 	배열에는 최소금액, 최대금액, 이율이 담겨있다.
 */

class product{
	private int minInvest;
	private int maxInvest;
	private int invest;
	private int rate;
	private boolean check;
	
	public product(int minInvest, int maxInvest, int rate) {
		this.minInvest = minInvest;
		this.maxInvest = maxInvest;
		this.rate = rate;
	}
	
	public int getMinInvest() {
		return minInvest;
	}
	
	public int getMaxInvest() {
		return maxInvest;
	}
	
	public int getRate() {
		return rate;
	}
	
	public void setInvest(int invest) {
		this.invest = invest;
	}
	
	public int getInvest() {
		return invest;
	}
	
	public void setcheck(boolean i) {
		check = i;
	}
	
	public boolean getCheck() {
		return check;
	}
}

public class FindBestRate {
	int[][] products;
	public int solution(int[][] products,int capital) {
		int answer = 0;
		
		for(int i = 0; i < products.length;i++) {
			int max = products[i][2];
			int maxIdx = i;
			for(int j = i+1 ; j < products.length;j++) {
				if(max < products[j][2]) {
					max = products[j][2];
					maxIdx = j;
				}
			}
			int temp[] = products[i];
			products[i] = products[maxIdx];
			products[maxIdx] = temp;
		}
		
		this.products = products;
		answer = getSum(capital,0,0);
		
		return answer;
	}
	
	private int getSum(int money, int sum,int idx) {
		
		return sum;
	}
	
	public static void main(String[] args) {
		int pro[][] = {
				{500000,900000,50},
				{20000,50000,38},
				{200000,200000,40}
		};
		int cap = 10000000;
		System.out.println(new FindBestRate().solution(pro, cap));
	}
}
