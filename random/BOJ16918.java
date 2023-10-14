package random;

import java.io.*;
import java.util.*;

public class BOJ16918 {
    static int[][] map;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken()); // 1<= R <= 200
        C = Integer.parseInt(st.nextToken()); // 1<= C <= 200
        int N = Integer.parseInt(st.nextToken()); // 1<= N <= 200
        // R*C*N = 8*10^6

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'O') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        int time = 2;

        while (time <= N) {

            if (time % 2 == 0) { // 짝수(설치)
                // 빈 곳에 폭탄 설치
                sulchi(time);
            } else {
                bomb(time);
            }

            time++;
        }

        StringBuilder sb = new StringBuilder();
        char[][] result = new char[R][C];

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                if (map[i][j] == -1) {
                    result[i][j] = '.';
                } else {
                    result[i][j] = 'O';
                }

                sb.append(result[i][j]);
            }

            sb.append('\n');
        }

        System.out.println(sb);

    } // main

    static void sulchi(int time) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == -1) {
                    map[r][c] = time;
                }
            }
        }
    }

    static void bomb(int time) {
        int[] dr = { -1, 1, 0, 0 };

        int[] dc = { 0, 0, -1, 1 };

        for (int r = 0; r < R; r++) {

            for (int c = 0; c < C; c++) {

                if (map[r][c] + 3 == time) {
                    // 주변 터치기
                    for (int i = 0; i < 4; i++) {

                        int row = r + dr[i];
                        int col = c + dc[i];

                        if (!bumwee(row, col))
                            continue;

                        if (map[row][col] == map[r][c])
                            continue;

                        map[row][col] = -1;
                    }

                    // 본인 터치기
                    map[r][c] = -1;
                }

            }
        }
    }

    static boolean bumwee(int r, int c) {
        if (r >= 0 && r < R && c >= 0 && c < C) {
            return true;
        } else {
            return false;
        }
    }
}
