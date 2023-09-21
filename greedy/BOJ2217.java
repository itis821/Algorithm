package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1<=N<=100,000
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 물체의 최대 중량
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (arr[i] * (N - i) > max) {
                max = arr[i] * (N - i);
            }
        }

        System.out.println(max);
    }

}
