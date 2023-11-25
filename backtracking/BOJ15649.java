package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15649 {
    // 1부터 N 까지 자연수 중에서 중복 없이 M 개를 고른 수열
    static int[] selected;
    static boolean[] isVisited;

    static int n;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n];
        selected = new int[r];

        comb(0, 0);
    }

    static void comb(int start, int depth) {
        // 종료 조건
        if (depth == r) {
            print(r);
            return;
        }

        for (int i = start; i < r; i++) {
            // 유효성 검사
            if (isVisited[i])
                continue;

            selected[depth] = i + 1;

            // 방문처리
            isVisited[i] = true;
            comb(start + 1, depth + 1);
            isVisited[i] = false;
        }
    }

    static void print(int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(selected[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

}
