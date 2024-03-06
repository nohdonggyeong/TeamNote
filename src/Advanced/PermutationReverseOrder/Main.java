package Advanced.PermutationReverseOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, r;
	static Integer[] input;
	static int[] temp;
	static boolean[] visited;
	static List<int[]> output;
	
	static void permutation(int depth) {
		if (depth == r) {
			output.add(temp.clone());
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = input[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			input = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(input, Collections.reverseOrder());
			
			temp = new int[r];
			visited = new boolean[n];
			output = new ArrayList<>();
			permutation(0);
			
			for (int[] el : output) {
				for (int e : el) {
					sb.append(e).append(" ");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append("\n");
			}
			
			bw.write(sb.toString().trim());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
