package programmers;

import java.util.HashMap;

class Solutionssss {
	public boolean solution(String[] phone_book) {
		HashMap<String, Integer> map = new HashMap<>();

		for(int i = 0; i<phone_book.length;i++)
			map.put(phone_book[i], i);
		
		for(int i = 0 ; i < phone_book.length;i++) {
			for(int j = 1 ; j < phone_book[i].length();j++) {
				if(map.containsKey(phone_book[i].subSequence(0, j)))
					return false;
			}
		}
		return true;
	}
}
public class PhoneBook {

}
