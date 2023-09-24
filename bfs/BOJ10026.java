package bfs;

import java.io.*;
import java.util.*;

public class BOJ10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1<= N <=100
        char[][] grim = new char[N][N];

        for (int i = 0; i < N; i++) {
            grim[i] = br.readLine().toCharArray();
        }

        boolean[][] isVisited = new boolean[N][N];
        boolean[][] isVisitedSec = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        int normal_cnt = 0;
        int sec_cnt = 0;

        // 상, 하, 좌, 우
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        int r, c;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                // normal
                if (!isVisited[i][j]) {

                    normal_cnt++;
                    q.offer(new int[] { i, j });
                    isVisited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cu = q.poll();

                        for (int k = 0; k < 4; k++) {
                            r = cu[0] + dr[k];
                            c = cu[1] + dc[k];

                            if (0 <= r && r < N && 0 <= c && c < N) {

                                // 방문 검사
                                if (isVisited[r][c])
                                    continue;
                                // 유효성 검사
                                if (grim[cu[0]][cu[1]] != grim[r][c])
                                    continue;
                                // 방문 체크
                                isVisited[r][c] = true;
                                q.offer(new int[] { r, c });
                            }
                        }
                    }

                } // normal end

                // Sec
                if (!isVisitedSec[i][j]) {
                    sec_cnt++;
                    q.offer(new int[] { i, j });
                    isVisitedSec[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cu = q.poll();

                        for (int k = 0; k < 4; k++) {
                            r = cu[0] + dr[k];
                            c = cu[1] + dc[k];

                            if (0 <= r && r < N && 0 <= c && c < N) {

                                // 방문 검사
                                if (isVisitedSec[r][c])
                                    continue;
                                // 유효성 검사
                                if (grim[cu[0]][cu[1]] == 'B') {

                                    if (grim[r][c] != 'B')
                                        continue;

                                } else if (grim[cu[0]][cu[1]] == 'R' || grim[cu[0]][cu[1]] == 'G') {

                                    if (grim[r][c] == 'B')
                                        continue;

                                }

                                // 방문 체크
                                isVisitedSec[r][c] = true;
                                q.offer(new int[] { r, c });
                            }
                        }
                    }

                }

            }
        }

        System.out.println(normal_cnt + " " + sec_cnt);
    }

}
