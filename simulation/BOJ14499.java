package simulation;

import java.io.*;
import java.util.*;

public class BOJ14499 {
    static final int NORTH = 3;
    static final int EAST = 1;
    static final int SOUTH = 4;
    static final int WEST = 2;
    static int x, y, M, N;
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 1<= N <= 20
        M = Integer.parseInt(st.nextToken()); // 1<= M <= 20
        x = Integer.parseInt(st.nextToken()); // 0<= x <= N-1
        y = Integer.parseInt(st.nextToken()); // 0<= y <= M-1
        int K = Integer.parseInt(st.nextToken()); // 1<= K <= 1,000

        int[][] map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int t = 0; t < K; t++) {

            int dir = Integer.parseInt(st.nextToken());

            if (canMove(dir)) { // 이동가능하다면

                // 주사위 굴리기
                roll(dir);

                if (map[x][y] == 0) { // 0인 경우
                    map[x][y] = dice[1];
                } else { // 0이 아닌 경우
                    dice[1] = map[x][y];
                    map[x][y] = 0;
                }

                // 주사위의 윗 면에 쓰여진 수
                System.out.println(dice[0]);

            } else {
                continue;
            }

        }
    }

    static void roll(int dir) {
        int[] dr = { 0, 0, 0, -1, 1 };
        int[] dc = { 0, 1, -1, 0, 0 };

        x = x + dr[dir];
        y = y + dc[dir];

        int[] next = new int[6];

        if (dir == NORTH) { // 북
            next[0] = dice[4];
            next[1] = dice[2];
            next[2] = dice[0];
            next[3] = dice[3];
            next[4] = dice[1];
            next[5] = dice[5];

        } else if (dir == SOUTH) { // 남
            next[0] = dice[2];
            next[1] = dice[4];
            next[2] = dice[1];
            next[3] = dice[3];
            next[4] = dice[0];
            next[5] = dice[5];

        } else if (dir == EAST) { // 동
            next[0] = dice[5];
            next[1] = dice[3];
            next[2] = dice[2];
            next[3] = dice[0];
            next[4] = dice[4];
            next[5] = dice[1];

        } else if (dir == WEST) { // 서
            next[0] = dice[3];
            next[1] = dice[5];
            next[2] = dice[2];
            next[3] = dice[1];
            next[4] = dice[4];
            next[5] = dice[0];
        }

        dice = next;

    }

    static boolean canMove(int dir) {
        int[] dr = { 0, 0, 0, -1, 1 };
        int[] dc = { 0, 1, -1, 0, 0 };

        int row = x + dr[dir];
        int col = y + dc[dir];

        if (row >= 0 && row <= N - 1 && col >= 0 && col <= M - 1) {
            return true;
        } else {
            return false;
        }

    }
}
