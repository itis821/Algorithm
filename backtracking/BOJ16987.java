package backtracking;

import java.io.*;
import java.util.*;

class BOJ16987 {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 input
        int N = Integer.parseInt(br.readLine()); // 1<= N <= 8

        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 2 ~ (2+N) input
        int[] s = new int[N]; // 1 <= s <= 300
        int[] w = new int[N]; // 1 <= w <= 300

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        breakingEggs(0, N, s, w);

        // output
        System.out.println(max);
    }

    static void breakingEggs(int curr, int N, int[] s, int[] w) {
        if (curr == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (s[i] <= 0) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        boolean breaking = false;

        for (int pick = 0; pick < N; pick++) {

            // 현재 계란이 깨진 경우 패스
            if (s[curr] <= 0) {
                breakingEggs(curr + 1, N, s, w);
                continue;
            }

            // 현재 계란이 선택한 계란이면 다음 계란 선택
            if (pick == curr)
                continue;

            // 선택한 계란이 꺠지면 다음 계란 선택
            if (s[pick] <= 0)
                continue;

            // 계란 깨기
            breaking = true;
            s[curr] -= w[pick];
            s[pick] -= w[curr];
            breakingEggs(curr + 1, N, s, w);
            s[pick] += w[curr];
            s[curr] += w[pick];
        }

        if (!breaking) {
            breakingEggs(curr + 1, N, s, w);
        }
    }
}