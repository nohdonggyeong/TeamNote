package advanced.bfs.특이한_여러_방법으로_이동;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * boj_13913_숨바꼭질_4
 * 각 방법으로 도착한 곳마다 처음 와본 곳이면
 * 작업 명령 큐로 위치 인덱스 추가
 * 해당 위치 인덱스로 이전 위치 인덱스, 방문시간을 저장
 */
public class Main {
    private static int N;
    private static int K;
    private static int[] visitCheck = new int[100001]; // 수빈이 방문한 위치로 도달하게 된 시간 저장할 것
    private static int[] prev = new int[100001]; // 수빈이 방문한 위치의 이전 위치 저장

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int index;
        visitCheck[N] = 0;

        queue.add(N);
        while (!queue.isEmpty()) {
            index = queue.remove();
            if (index == K) {
                return visitCheck[index];
            }

            if (index - 1 >= 0 && visitCheck[index - 1] == 0) {
                visitCheck[index - 1] = visitCheck[index] + 1;
                queue.add(index - 1);
                
                prev[index - 1] = index;
            }
            
            if (index + 1 <= 100000 && visitCheck[index + 1] == 0) {
                visitCheck[index + 1] = visitCheck[index] + 1;
                queue.add(index + 1);
                
                prev[index + 1] = index;
            }
            
            if (index * 2 <= 100000 && visitCheck[index * 2] == 0) {
                visitCheck[index * 2] = visitCheck[index] + 1;
                queue.add(index * 2);
                
                prev[index * 2] = index;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) throws IOException {
    	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
    		StringBuilder sb  = new StringBuilder();
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int ouputInt = bfs();
            bw.write(String.valueOf(ouputInt));
            bw.newLine();

            Stack<Integer> stack = new Stack<>();
            stack.push(K);
            int i = K;
            while (i != N) {
                stack.push(prev[i]);
                i = prev[i];
            }
            
            while (!stack.isEmpty()) {
                sb.append(String.valueOf(stack.pop()));
                sb.append(" ");
            }
            
            bw.write(sb.toString().trim());
            bw.flush();
    	}
    }
}
