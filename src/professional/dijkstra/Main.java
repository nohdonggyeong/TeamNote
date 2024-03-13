package professional.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * boj_1916_최소비용_구하기
 */
public class Main {
	static int N, M;
	static List<Node>[] graph;
	static int[] dist;
	static final int INF = 100_000_000;
	static PriorityQueue<Node> pq;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	
	static void dijkstra(int start) {
		pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));

		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		Arrays.fill(visited, false);
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if (visited[cur]) {
				continue;
			}
			
			visited[cur] = true;
			
			for (Node next : graph[cur]) {
				if (dist[next.end] > dist[cur] + next.weight) {
					dist[next.end] = dist[cur] + next.weight;
					pq.offer(new Node(next.end, dist[next.end]));
				}
			}
		}
	}
	 
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			StringTokenizer st;
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			graph = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				graph[i] = new ArrayList<Node>();
			}
			
			for (int i = 0; i < M; i ++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[start].add(new Node(end, weight));
			}
			
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			dist = new int[N + 1];
			visited = new boolean[N + 1];
			dijkstra(start);
			
			bw.write(String.valueOf(dist[end]));
			bw.flush();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
