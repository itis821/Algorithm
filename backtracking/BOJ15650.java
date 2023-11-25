package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15650 {
    public static StringBuilder sb = new StringBuilder();
    static int[] result;
    static int[] arr;
    static int n, r;

    // 순열 nCr
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 배열 생성
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        result = new int[r];

        comb(0, 0);
        System.out.print(sb);
    }

    static void comb(int at, int depth) {

        if (depth == r) {
            print();
            return;
        }

        for (int i = at; i < n; i++) {

            result[depth] = arr[i];
            comb(i + 1, depth + 1);

        }

    }

    static void print() {
        for (int i = 0; i < r; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");
    }
}
