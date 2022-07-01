package ChessQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Queen{
	private int size;
	private BufferedReader br;
	private int cnt = 0;
	private Scanner scan = new Scanner(System.in);
	
	public Queen() {
		run();
	}
	
	private void run() {
//		try {
//			br = new BufferedReader(new InputStreamReader(System.in));
//			size = br.read();
//			placeQueen(size);
//			br.close();
//		} catch (IOException e) {
//			System.out.println("IOException");
//		} catch (NumberFormatException f) {
//			System.out.println("Wrong Type");
//		}
		size = scan.nextInt();
		placeQueen(size);
		System.out.println(cnt);
	}
	
	private void placeQueen(int n) {
		for(int i = 0 ; i < size; i++) {
			boolean map [][] = new boolean [size][size];
			checkValid(1,makeInvalid(map,0,i));
		}
	}
	private void checkValid(int idx,boolean[][] map) {
		for(int i = 0; i < size ; i++) {
			if(!map[idx][i]) {
				if(idx == size-1) {
					cnt++;
				}
				else {
					checkValid(idx+1, makeInvalid(map, idx, i));
				}
			}
		}
	}
	private boolean[][] makeInvalid(boolean[][] pmap,int y, int x) {
		boolean[][] map = new boolean[size][size];
		for(int i = 0 ; i < size; i++) {
			map[i] = pmap[i].clone();
		}
		for(int i = 0 ; i < size; i++) {
			map[y][i] = true;
			map[i][x] = true;
			if(y-i>= 0 && x + i < size) {
				map[y-i][x+i] = true;
			}
			if(y-i>= 0 && x - i >= 0) {
				map[y-i][x-i] = true;
			}
			if(y+i < size && x - i >= 0) {
				map[y+i][x-i] = true;
			}
			if(y+i < size && x + i < size) {
				map[y+i][x+i] = true;
			}
		}
		return map;
	}
}

public class Main {
	public static void main(String[] args) {
		new Queen();

	}

}
