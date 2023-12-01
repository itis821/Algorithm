package simulation;

import java.io.*;
import java.util.*;

public class BOJ14502 {
    static int N, M;
    static int[][] map;
    static int[] combArr = new int[3];
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 3 <= N <= 8
        M = Integer.parseInt(st.nextToken()); // 3 <= M <= 8

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);

        System.out.println(ans);
    }

    static void comb(int depth, int at) {
        if (depth == 3) {
            int cnt = bfs();
            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = at; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (map[x][y] != 0)
                continue;

            combArr[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    static int bfs() {
        int cnt = 0;

        // 맵 세팅
        for (int i = 0; i < 3; i++) {
            int x = combArr[i] / M;
            int y = combArr[i] % M;
            map[x][y] = 1;
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        boolean[][] isVisited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    isVisited[i][j] = true;
                    q.offer(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (isVisited[nx][ny] == true)
                    continue;

                if (map[nx][ny] != 0)
                    continue;

                isVisited[nx][ny] = true;
                q.offer(new int[] { nx, ny });
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        // 맵 되돌리기
        for (int i = 0; i < 3; i++) {
            int x = combArr[i] / M;
            int y = combArr[i] % M;
            map[x][y] = 0;
        }

        return cnt;
    }

}
