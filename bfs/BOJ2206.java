package bfs;

import java.io.*;
import java.util.*;

class BOJ2206 {
    static int N;
    static int M;

    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        int ans = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1<= N <= 1,000
        M = Integer.parseInt(st.nextToken()); // 1<= M <= 1,000

        int[][] zeroMap = new int[N][M];
        int[][] endMap = new int[N][M];

        for (int i = 0; i < N; i++) {

            String line = br.readLine();

            for (int j = 0; j < M; j++) {

                if (line.charAt(j) == '0') {
                    zeroMap[i][j] = 0;
                    endMap[i][j] = 0;
                } else if (line.charAt(j) == '1') {
                    zeroMap[i][j] = -1;
                    endMap[i][j] = -1;
                }

            }
        }

        int[] start = { 0, 0 };
        int[] end = { N - 1, M - 1 };

        bfs(start, zeroMap);
        bfs(end, endMap);

        // 벽 안 부수고
        if (zeroMap[N - 1][M - 1] != 0) {
            ans = zeroMap[N - 1][M - 1];
        }

        // 벽 부수고
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                // 벽인 경우
                if (zeroMap[i][j] == -1) {
                    int zeromin = -2;
                    int endmin = -2;
                    int val = 0;

                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];

                        if (isOutOfBound(r, c))
                            continue;

                        // 벽 또는 미발견 아닌 경우
                        if (zeroMap[r][c] != 0 && zeroMap[r][c] != -1) {
                            if (zeromin == -2) {
                                zeromin = zeroMap[r][c];
                            } else {
                                zeromin = Math.min(zeromin, zeroMap[r][c]);
                            }
                        }

                        if (endMap[r][c] != 0 && endMap[r][c] != -1) {
                            if (endmin == -2) {
                                endmin = endMap[r][c];
                            } else {
                                endmin = Math.min(endmin, endMap[r][c]);
                            }
                        }

                    }

                    if (zeromin != -2 && endmin != -2) {
                        val = zeromin + endmin + 1;
                        if (ans == -1) {
                            ans = val;
                        } else {
                            ans = Math.min(ans, val);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int[] start, int[][] map) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(start);
        map[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = curr[0] + dr[i];
                int c = curr[1] + dc[i];

                if (isOutOfBound(r, c))
                    continue;

                if (map[r][c] != 0)
                    continue;

                map[r][c] = map[curr[0]][curr[1]] + 1;
                q.offer(new int[] { r, c });
            }
        }

    }

    static boolean isOutOfBound(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < M) {
            return false;
        }

        return true;
    }
}