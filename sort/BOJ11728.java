package sort;

import java.io.*;
import java.util.*;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];
        int[] AB = new int[N + M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int a_idx = 0;
        int b_idx = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < AB.length; i++) {
            if (a_idx < A.length && b_idx < B.length) {
                if (A[a_idx] <= B[b_idx]) {
                    AB[i] = A[a_idx];
                    a_idx++;
                } else {
                    AB[i] = B[b_idx];
                    b_idx++;
                }
            } else if (a_idx >= A.length && b_idx < B.length) {
                AB[i] = B[b_idx];
                b_idx++;
            } else if (a_idx < A.length && b_idx >= B.length) {
                AB[i] = A[a_idx];
                a_idx++;
            } else {
                System.out.println("EXCEPTION!");
            }
            sb.append(AB[i]).append(" ");
        }

        System.out.println(sb);

    }

}
