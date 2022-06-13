package programmers;

import java.util.LinkedList;

class Node{
	int number;
	boolean target;
	
	public Node(int num, boolean target) {
		this.number = num;
		this.target = target;
	}
}

class Print {
	LinkedList<Node> list = new LinkedList<>();
	int numbers[] = new int[10];

	public int solution(int[] priorities, int location) {
		int answer = 0;
		Node target = null;
		int size = priorities.length;
		for(int i = 0 ; i < size; i++) {
			numbers[priorities[i]]++;
			if(i != location)
				list.add(new Node(priorities[i],false));
			else {
				Node tar = new Node(priorities[i],true);
				target = tar;
				list.add(target);
			}
		}
		
		int max = findMaxPriority();
		
		while(!list.isEmpty()) {
			if(list.peek().number == max) {
				answer++;
				numbers[max]--;
				if(numbers[max] == 0)
					max = findMaxPriority();
				if(list.peek().equals(target))
					break;
				list.poll();
			}
			else
				list.add(list.poll());
		}
		return answer;
	}

	public int findMaxPriority() {
		for (int i = 9; i >= 0; i--) {
			if (numbers[i] > 0) {
				return i;
			}
		}
		return 0;
	}
}

public class Printer {
	public static void main(String[] args) {

		int[] pro = { 1, 1, 9, 1, 1, 1};
		int loc = 0;
		Print pr = new Print();
		pr.solution(pro, loc);
		
	}
}
