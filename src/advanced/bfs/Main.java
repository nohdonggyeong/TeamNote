package advanced.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_2178_미로_탐색
 */
public class Main {
	private static int N, M;
	
	private static int[][] maze;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static class Node {
		private int x;
		private int y;
		private int minCnt;
		
		Node() {
			this.x = 0;
			this.y = 0;
			this.minCnt = 1;
		}
		
		Node(int x, int y, int minCnt) {
			this.x = x;
			this.y = y;
			this.minCnt = minCnt;
		}
	}
	
	private static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node());
		
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x == N - 1 && node.y == M - 1) {
				return node.minCnt;
			}
			
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (visited[nx][ny]) {
					continue;
				}
				if (maze[nx][ny] != 1) {
					continue;
				}
				
				queue.offer(new Node(nx, ny, node.minCnt + 1));
				visited[nx][ny] = true;
			}
		}
		
		return -1;
	}
	
	public static void main(String args[]) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			maze = new int[N][M];
			for (int i = 0 ; i < N; i++) {
				String[] tmpArr = br.readLine().split("");
				for (int j = 0; j < M; j++) {
					maze[i][j] = Integer.parseInt(tmpArr[j]);
				}
			}
			
			int result = bfs();
			
			bw.write(String.valueOf(result));
			bw.flush();
		}
	}
}
