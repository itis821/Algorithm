package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15649 {
    // 1부터 N 까지 자연수 중에서 중복 없이 M 개를 고른 수열
    static int[] arr;
    static int[] result;
    static boolean[] isVisited;

    static int n, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n];
        result = new int[r];

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        perm(0);
    }

    static void perm(int depth) {
        if (depth == r) {
            print(r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = arr[i];
                perm(depth + 1);
                isVisited[i] = false;
            }
        }
    }

    static void print(int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

}
