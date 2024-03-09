package advanced.bfs.벽을_부수는_것이_가능.벽을_몇_개_부숴야_최단경로가_되나;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * boj_1261_알고스팟
 * 출발점에서 도착점까지 부수고 가야하는 벽의 개수를 카운트 함
 */
public class Main {
	private static int N;
	private static int M;
	
	private static int[][] maze;
	private static boolean[][] visited;
	
	private static PriorityQueue<Room> priorityQueue;
	private static Room nowRoom;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static class Room implements Comparable<Room> {
		private int x;
		private int y;
		private int cnt;
		
		Room(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Room room) {
			return this.cnt - room.cnt;
		}
	}

	private static int bfs() {
		priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Room(0, 0, 0));
		visited[0][0] = true;

		while (!priorityQueue.isEmpty()) {
			nowRoom = priorityQueue.poll();
			
			if (nowRoom.x == M - 1 && nowRoom.y == N - 1) {
				return nowRoom.cnt;
			}
			
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = nowRoom.x + dx[i];
				ny = nowRoom.y + dy[i];
				if (nx >= 0 && nx <= M - 1 && ny >= 0 && ny <= N - 1 && !visited[nx][ny]) {
					priorityQueue.offer(new Room(nx, ny, nowRoom.cnt + maze[nx][ny]));
					visited[nx][ny] = true;
				}
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
			
			maze = new int[M][N];
			visited = new boolean[M][N];

			String[] rowData;
			for (int i = 0; i < M; i++) {
				rowData = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					maze[i][j] = Integer.parseInt(rowData[j]);
				}
			}
			
			bw.write(String.valueOf(bfs()));
			bw.flush();
		}
	}
}
