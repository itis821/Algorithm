package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15649 {
    // 1부터 N 까지 자연수 중에서 중복 없이 M 개를 고른 수열
    public static int[] selected;
    public static boolean[] isVisited;

    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        isVisited = new boolean[N];

        dfs(0);
    }

    public static void dfs(int depth) {
        // 종료 조건
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            // 유효성 검사
            if (isVisited[i])
                continue;

            selected[depth] = i + 1;
            // 방문처리
            isVisited[i] = true;
            dfs(depth + 1);
            isVisited[i] = false;
        }
    }

}
