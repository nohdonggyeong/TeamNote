package advanced.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * boj_9663_N_Queen
 */
public class Main {
	static int N, count;
	static int[] arr;
	
	static boolean checkPossible (int depth) {
		for (int i = 0; i < depth; i++) {
			if (arr[depth] == arr[i]) {
				return false;
			} else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	static void backTracking(int depth) {
		if (depth == N) {
			count += 1;
			return;
		}
		
		for (int w = 0; w < N; w++) {
			arr[depth] = w;
			if (checkPossible(depth)) {
				backTracking(depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			count = 0;
			backTracking(0);
			
			bw.write(String.valueOf(count));
			bw.flush();
		}
	}
}
