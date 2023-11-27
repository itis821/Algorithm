package backtracking;

import java.io.*;
import java.util.*;

class BOJ16987 {
    // 계란으로 계란치기
    // 11월 25일 22:04~

    static boolean[] isBroken;
    static int[][] eggs;
    static int N;

    public static void main(String[] args) throws IOException {
        // (내구도, 무게)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1<= N <=8

        eggs = new int[N][2];
        isBroken = new boolean[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        break_egg(0);
        // N == 2
        // 가장 왼쪽 계란 들기
        // 오른쪽 계란 치기
        // 1. 가장 왼쪽 계란 들기
        // 2. 계란 꺠기
        // 3. 오른쪽 계란 들기
    }

    static void break_egg(int curr) {
        for (int i = 0; i < N; i++) {
            if (i != curr && !isBroken[i]) {
                eggs[curr][0] -= eggs[i][1];
                eggs[i][0] -= eggs[curr][1];

                if (eggs[curr][0] <= 0) {
                    isBroken[curr] = true;
                }

                if (eggs[i][0] <= 0) {
                    isBroken[i] = true;
                }
            }
        }
    }
}