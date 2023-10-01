package bfs;

import java.util.*;
import java.io.*;

public class BOJ7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int I;
        int[] init = new int[3];
        int[] targ = new int[2];

        // 이동 경로
        int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
        int[] dc = { -2, -1, 1, 2, -2, -1, 1, 2 };

        // 테스트 케이스
        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            isVisited = new boolean[I][I];

            st = new StringTokenizer(br.readLine(), " ");
            init[0] = Integer.parseInt(st.nextToken());
            init[1] = Integer.parseInt(st.nextToken());
            init[2] = 0;

            st = new StringTokenizer(br.readLine(), " ");
            targ[0] = Integer.parseInt(st.nextToken());
            targ[1] = Integer.parseInt(st.nextToken());

            q.offer(init);
            isVisited[init[0]][init[1]] = true;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int nr, nc, cnt;
                if (curr[0] == targ[0] && curr[1] == targ[1]) {
                    sb.append(curr[2]).append('\n');
                }

                for (int i = 0; i < dr.length; i++) {
                    nr = curr[0] + dr[i];
                    nc = curr[1] + dc[i];
                    cnt = curr[2] + 1;

                    if (nr < 0 || nr >= I || nc < 0 || nc >= I)
                        continue;

                    if (isVisited[nr][nc])
                        continue;

                    isVisited[nr][nc] = true;
                    q.offer(new int[] { nr, nc, cnt });
                }
            }
        }

        System.out.println(sb);
    }
}
