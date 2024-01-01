package sort;

import java.io.*;
import java.util.*;

public class BOJ7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i] > B[j]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

}
