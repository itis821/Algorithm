package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ16401 {
    static int M;
    static int N;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 1<= 조카의 수(M)<= 1,000,000
        N = Integer.parseInt(st.nextToken()); // 1<= 과자의 수(N) <= 1,000,000

        snacks = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < snacks.length; i++) {
            snacks[i] = Integer.parseInt(st.nextToken()); // 1 <= 과자 길이 <= 10억
        }

        // 과자를 나눠 먹을 수 있는
        // 막대 과자의 최대 길이 구하기
        // 조건 특정 길이에 막대 과자를 나눠 먹을 수 있나?
        System.out.println(binarySearch());

    }

    // 과자 최대 길이 출력
    static int binarySearch() {
        int lo = 1;
        int hi = 1000000000;

        if (check(lo) == false) {
            return 0;
        }

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid) == check(lo)) {
                lo = mid;
            } else {
                hi = mid;
            }

        }

        return lo;
    }

    // 조카들에게 모두 나눠줄 수 있는지
    static boolean check(int length) {
        int cnt = 0;

        for (int i = 0; i < snacks.length; i++) {
            cnt += snacks[i] / length;
        }

        if (cnt >= M) {
            return true;
        } else {
            return false;
        }
    }
}
