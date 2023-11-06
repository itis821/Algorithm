package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1<= N <= 10^5
        int k = Integer.parseInt(br.readLine()); // 1<= k <= min(10^9, N^2)

        // 인덱스 1부터 시작
        // B[k] 구하기
        // 1을 제외한 본인 등장횟수
        int[] soinsu = new int[N + 1];
        int[] soonsu = new int[N + 1];
        soinsu[1] = N;

        // i는 곱하는 수
        for (int i = 2; i <= N; i++) {

            // i와 j의 곱이 N보다 작다면
            int j = 1;

            while (i * j <= N) {
                soinsu[i * j]++;
                j++;
            }
        }

        soonsu[1] = 1;
        for (int i = 2; i <= N; i++) {
            soonsu[i] = soonsu[i - 1] + soinsu[i - 1];
        }

        for (int i = 0; i < soonsu.length; i++) {
            System.out.println("i : " + i + ", soonsu : " + soonsu[i]);
        }
        // soonsu[i] = i번쨰 숫자가 시작하는 인덱스
        // k가 soonsu[i] 보다 크거나 같은가

        long lo = 0; // true
        long hi = N * N; // false

        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;

            if (soonsu(mid) <= k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        // soonsu[lo] <= k < soonsu[hi]

        System.out.println(lo);
    }

    // 해당하는 인덱스에 해당하는 값
    static long soonsu(long mid) {
        // 소인수분해 더하기
        // 주어진 것 : 인덱스
        // 구할 것 : 값

        // 해당하는 인덱스의 값 전달
        // N + soinsu(1) +
        return 0;
    }

}
