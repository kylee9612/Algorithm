package ChessQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Queen{
	private int size;
	private BufferedReader br;
	private boolean map[][];
	private boolean queen[];
	private int cnt = 0;
	
	public Queen() {
		run();
	}
	
	private void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			size = br.read();
			map = new boolean[size][size];
			queen = new boolean [size];
			int count = placeQueen();
			br.close();
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (NumberFormatException f) {
			System.out.println("Wrong Type");
		}
	}
	
	private int placeQueen() {
		int cnt = 0;
		for(int i = 0 ; i < size; i++) {
			if(checkValid(i, 0))
				cnt++;
		}
		
		return cnt;
	}
	private boolean checkValid(int x, int y) {
		
		return false;
	}
	private void makeInvalid(int x, int y) {
		for(int i = 0 ; i < size; i++) {
			map[y][i] = true;
			map[i][x] = true;
		}
		
	}
}

public class Main {
	public static void main(String[] args) {
		new Queen();

	}

}
