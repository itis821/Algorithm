package greedy;

import java.io.*;
import java.util.*;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine()); // 1<= N <=50
        Integer[] A = new Integer[N]; // 0<=A[i]<=100
        Integer[] B = new Integer[N]; // 최대 100*100*50 = 500,000
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            answer += A[i] * B[i];
        }
        System.out.println(answer);
    }

}
