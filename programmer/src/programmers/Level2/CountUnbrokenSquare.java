package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
 * 
 * 가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 
 * 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 
 * 모든 격자칸은 1cm x 1cm 크기입니다. 
 * 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 
 * 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 
 * 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 
 * 새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 
 * 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
 * 가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.
 * 
 * 제한사항
 * W, H : 1억 이하의 자연수
 */

public class CountUnbrokenSquare {
	long solution(int w, int h) {
		long answer = (long) w * h;

		long small = w < h ? w : h;
		long big = w < h ? h : w;

		// 정사각형일때
		if (w == h) {
			return answer - w;
		}

		// 최대공약수 크기만큼의 도형패턴이 이어진다
		long lon = getGCD(small, big);

		// 지워지는 블록의 갯수는
		// 넓이+길이-최대공약수만큼
		long erase = w + h - lon;

		return answer - erase;
	}

	public long getGCD(long w, long h) {
		long lon = 0;
		// 1부터 주어진 작은 수인 w까지 탐색하는것보다
		// w부터 시작하여 하나씩 빼가는게 속도 효율측면에서 더 빠르다
		// 고로 최대공약수를 찾은경우 바로 break하여 반복문을 탈출한다.
		// 예) 8, 12 의 최대공약수는 4인데, 1에서부터 8까지 8번 반복하는 것 보다
		// 8에서 4까지 5번 반복하는 것이 빠르기 때문
		for (long i = w; i >= 1; i--) {
			if (w % i == 0 && h % i == 0) {
				lon = i;
				break;
			}
		}
		return lon;
	}

}
