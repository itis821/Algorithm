package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class BOJ7569 {
    static int C, R, H;
    static int[][][] tomatos;
    static boolean[][][] isVisited;
    static int numNoTomato = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 열 (2<= M <=100)
        C = Integer.parseInt(st.nextToken());

        // 행 (2<= N <=100)
        R = Integer.parseInt(st.nextToken());

        // 높이 (1<= H <= 100)
        H = Integer.parseInt(st.nextToken());

        tomatos = new int[R][C][H];
        isVisited = new boolean[R][C][H];

        readTomatos();
        // printTomatos();

        // M*N*H = 1,000,000 O(N) ~ O(NlgN)
        // 1 : 익은 토마토
        // 0 : 익지 않은 토마토
        // -1 : 토마토 없는 칸

        System.out.println(findDate());

    }

    static int findDate() {
        // 상, 하, 북, 남, 동, 서
        int[] dr = { 0, 0, -1, 1, 0, 0 };
        int[] dc = { 0, 0, 0, 0, 1, -1 };
        int[] dh = { 1, -1, 0, 0, 0, 0 };

        int date = -2;
        int eatTomato = 0;

        // q[0] = r, q[1] = c, q[2] = h, q[3] = day
        // 모든 토마토가 익어있는 상태라면 0 출력 (익지 않은 토마토가 없으면)
        if (numNoTomato == 0) {
            return 0;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int nr, nc, nh, nd;

            for (int i = 0; i < dr.length; i++) {
                nr = curr[0] + dr[i];
                nc = curr[1] + dc[i];
                nh = curr[2] + dh[i];
                nd = curr[3] + 1;

                // 범위 체크
                if (nr < 0 || nr >= R || nc < 0 || nc >= C || nh < 0 || nh >= H)
                    continue;

                // 유효성 체크
                if (tomatos[nr][nc][nh] != 0)
                    continue;

                // 방문 검사
                if (isVisited[nr][nc][nh])
                    continue;

                // 방문
                q.offer(new int[] { nr, nc, nh, nd });
                eatTomato++;
                isVisited[nr][nc][nh] = true;
                date = nd;
            }
        }

        if (eatTomato == numNoTomato) {
            return date;
        } else { // 토마토가 모두 익지는 못하는 상황 -1 출력
            return -1;
        }

    }

    static void readTomatos() throws IOException {
        StringTokenizer st;

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < C; c++) {
                    tomatos[r][c][h] = Integer.parseInt(st.nextToken());

                    if (tomatos[r][c][h] == 0)
                        numNoTomato++;

                    if (tomatos[r][c][h] == 1) {
                        q.offer(new int[] { r, c, h, 0 });
                        isVisited[r][c][h] = true;
                    }

                }
            }
        }
    }
}