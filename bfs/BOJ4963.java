package bfs;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int COL = -1;
        int ROW = -1;

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        boolean[][] isVisited;
        int[][] map;
        int cnt;
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> land;

        // 테스트 케이스
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            COL = Integer.parseInt(st.nextToken());
            ROW = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (ROW == 0 && COL == 0)
                break;

            isVisited = new boolean[ROW][COL];
            map = new int[ROW][COL];
            land = new LinkedList<>();
            cnt = 0;

            for (int r = 0; r < ROW; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < COL; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] == 1) {
                        land.offer(new int[] { r, c });
                    }
                }
            }

            if (land.isEmpty()) {
                sb.append(0).append('\n');
                continue;
            }

            int[] curr = land.poll();
            q.offer(curr);
            isVisited[curr[0]][curr[1]] = true;
            cnt++;

            while (!q.isEmpty()) {
                curr = q.poll();
                int nr, nc;

                for (int i = 0; i < dr.length; i++) {
                    nr = curr[0] + dr[i];
                    nc = curr[1] + dc[i];

                    // 범위 검사
                    if (nr < 0 || nr >= ROW || nc < 0 || nc >= COL)
                        continue;

                    // 유효성 검사
                    if (map[nr][nc] == 0)
                        continue;

                    // 방문 검사
                    if (isVisited[nr][nc])
                        continue;

                    // 방문 체크
                    q.offer(new int[] { nr, nc });
                    isVisited[nr][nc] = true;
                }

                if (q.isEmpty()) {
                    if (!land.isEmpty()) {
                        int[] tmp = land.poll();

                        while (isVisited[tmp[0]][tmp[1]] && !land.isEmpty()) {
                            tmp = land.poll();
                        }

                        if (!isVisited[tmp[0]][tmp[1]]) {
                            q.offer(tmp);
                            isVisited[tmp[0]][tmp[1]] = true;
                            cnt++;
                        }

                    }
                }
            }

            sb.append(cnt).append('\n');

        }
        System.out.print(sb);
    }

}
