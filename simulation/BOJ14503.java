package simulation;

import java.io.*;
import java.util.*;

public class BOJ14503 {
    static int[][] map;
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int cnt = 0;
    static int[] robot = new int[3];
    static int dirty = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 3 <= N <= 50
        M = Integer.parseInt(st.nextToken()); // 3 <= M <= 50

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 3; i++) {
            robot[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    dirty++;
                }
            }
        }

        // 청소 시작
        clean_room(robot);

        // 멈출 때까지 청소 진행
        System.out.println(cnt);
    }// main

    static void clean_room(int[] robot) {
        int row, col;

        while (true) {
            row = robot[0];
            col = robot[1];

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[row][col] == 0) {
                map[row][col] = -1;
                cnt++;
            }

            // 다 청소한 경우
            if (cnt == dirty)
                break;

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            if (!doClean()) {
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 후진
                boolean code = doTwo();

                if (code) {
                    // 1번으로 돌아감
                    continue;
                } else {
                    break;
                    // 유일한 종료조건
                }
            } else {
                doThree();
                // 1번으로 돌아감
                continue;
            }
        }
        return;
    }

    static boolean doTwo() {

        // 바라보는 방향을 유치한 채 한 칸 후진 가능
        if (hugin()) {
            // 1번으로 돌아감
            return true;
        } else {
            // 작동을 멈춤
            return false;
        }
    }

    static boolean hugin() {
        int dir = robot[2]; // 0: 북, 1: 동, 2: 남, 3: 서
        int[] back_row = { 1, 0, -1, 0 };
        int[] back_col = { 0, -1, 0, 1 };

        int r = robot[0] + back_row[dir];
        int c = robot[1] + back_col[dir];

        if (!bumwee(r, c)) // 범위 아님
            return false;

        if (map[r][c] == 1) // 벽 만남
            return false;

        // 후진 진행
        robot[0] = r;
        robot[1] = c;
        return true;
    }

    static void doThree() {
        // 반시계 방향으로 90도 회전
        turn();
        forwardCheck();
    }

    static void turn() {
        if (robot[2] == 0) {
            robot[2] = 3;
        } else {
            robot[2] = robot[2] - 1;
        }
    }

    static void forwardCheck() {
        int dir = robot[2];
        int[] forward_row = { -1, 0, 1, 0 };
        int[] forward_col = { 0, 1, 0, -1 };

        int r = robot[0] + forward_row[dir];
        int c = robot[1] + forward_col[dir];

        // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한칸 전진
        if (!bumwee(r, c)) // 범위
            return;

        if (map[r][c] == 0) {
            robot[0] = r;
            robot[1] = c;
        }

        return;
    }

    static boolean bumwee(int r, int c) {
        if (0 <= r && r <= N - 1 && 0 <= c && c <= M - 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean doClean() {
        int row, col;

        for (int i = 0; i < 4; i++) {
            row = robot[0] + dr[i];
            col = robot[1] + dc[i];

            if (!bumwee(row, col))
                continue;

            if (map[row][col] == 0) {
                return true;
            }
        }

        return false;
    }

    static void print_map() {
        System.out.println("PRINT MAP");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == robot[0] && j == robot[1]) {
                    System.out.println("*" + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
