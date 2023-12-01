package simulation;

import java.io.*;
import java.util.*;

class BOJ13460 {

    static int ans = 999;
    static char[][] map;
    static int[] point = new int[4]; // {rx, ry, bx, by}
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'R') {
                    map[i][j] = '.';
                    point[0] = i;
                    point[1] = j;
                } else if (map[i][j] == 'B') {
                    map[i][j] = '.';
                    point[2] = i;
                    point[3] = j;
                }
            }
        }

        // logic
        backtracking(0, false, false);

        // output (문제 해결의 최소 경우의 수 찾기), 999 일 경우 실패
        if (ans == 999) {
            System.out.println(-1);
        } else if (ans != 999) {
            System.out.println(ans);
        }

    }// main

    static void backtracking(int depth, boolean isEnd, boolean isSuccess) {

        // 10번 움직였거나, isEnd(결과가 나왔나), isSuccess(목표에 도달했나)
        if (depth == 10 || isEnd) {

            if (isSuccess) {
                // System.out.println("SUCCESS DEPTH : " + depth);
                ans = Math.min(depth, ans);
            }

            return;
        }

        // 기울이기
        for (int d = 0; d < 4; d++) {
            int[] temp = Arrays.copyOf(point, 4);
            boolean[] result = tilt(map, d);
            // printMap(map);
            backtracking(depth + 1, result[0], result[1]);
            point = Arrays.copyOf(temp, 4);
        }
    }

    static boolean[] tilt(char[][] myMap, int d) {
        boolean isEnd = false;
        boolean isSuccess = false;

        int[] dx = { -1, 1, 0, 0 }; // 상하좌우
        int[] dy = { 0, 0, -1, 1 };

        int rx = point[0];
        int ry = point[1];
        int bx = point[2];
        int by = point[3];
        // isEnd 조건(파란 구슬 또는 빨간 구슬이 구멍에 빠짐)
        // isSuccess 조건(빨간 구슬이 구멍에 빠짐 && !파란 구슬이 구멍에 빠짐)

        // 파란 구슬 굴리기
        while (map[bx + dx[d]][by + dy[d]] == '.') {
            bx += dx[d];
            by += dy[d];
        }

        if (map[bx + dx[d]][by + dy[d]] == 'O') {
            isEnd = true;
            isSuccess = false;
            return new boolean[] { isEnd, isSuccess };
        }

        // 빨간 구슬

        if (rx <= 0 || rx >= N - 1 || ry <= 0 || ry >= M - 1) {
            System.out.println("--------------------");
            System.out.println("rx : " + rx + ", ry : " + ry);
            System.out.println("dx : " + dx[d] + ", dy : " + dy[d]);
            System.out.println((rx + dx[d]) + ", " + (ry + dy[d]));
            printMap(map);
        }
        while (map[rx + dx[d]][ry + dy[d]] == '.') {
            rx += dx[d];
            ry += dy[d];
        }

        if (map[rx + dx[d]][ry + dy[d]] == 'O') {
            isEnd = true;
            isSuccess = true;
            return new boolean[] { isEnd, isSuccess };
        }

        // 빨간 구슬 파란 구슬 겹침
        if (rx == bx && ry == by) {
            if (d == 0) { // 위로 굴리기
                if (point[0] > point[2]) { // 빨간 구슬이 밑에
                    rx++;
                } else if (point[0] < point[2]) { // 파란 구슬이 밑에
                    bx++;
                }
            } else if (d == 1) { // 밑으로 굴리기
                if (point[0] > point[2]) { // 빨간 구슬이 밑에
                    bx--;
                } else if (point[0] < point[2]) { // 파란 구슬이 밑에
                    rx--;
                }
            } else if (d == 2) { // 좌로 굴리기
                if (point[1] > point[3]) { // 빨간 구슬이 오른쪽에
                    ry++;
                } else if (point[1] < point[3]) { // 파란 구슬이 오른쪽에
                    by++;
                }

            } else if (d == 3) { // 우로 굴리기
                if (point[1] > point[3]) { // 빨간 구슬이 오른쪽에
                    by--;
                } else if (point[1] < point[3]) { // 파란 구슬이 오른쪽에
                    ry--;
                }
            }
        }
        point[0] = rx;
        point[1] = ry;
        point[2] = bx;
        point[3] = by;

        return new boolean[] { isEnd, isSuccess };
    }

    static void printMap(char[][] myMap) {
        System.out.println("--------------------");
        for (int i = 0; i < myMap.length; i++) {
            for (int j = 0; j < myMap[0].length; j++) {
                if (i == point[0] && j == point[1]) {
                    System.out.print('R');
                } else if (i == point[2] && j == point[3]) {
                    System.out.print('B');
                } else {
                    System.out.print(myMap[i][j]);
                }

            }
            System.out.println();
        }
    }
}