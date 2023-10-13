package twopointer;

import java.io.*;
import java.util.*;

public class BOJ1806 {
    static int S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 10 <= 수열 길이 <= 100,000
        S = Integer.parseInt(st.nextToken()); // 0 < 부분합 최소값 <= 1억

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 1<= arr[i] <= 10,000

            if (isOver(arr[i])) { // 1개가 조건 충족
                System.out.println(1);
                return;
            }

            sum += arr[i];
        }

        if (!isOver(sum)) { // 조건 충족 가능 경우가 없음
            System.out.println(0);
            return;
        }

        int ans = find();
        if (ans == -1) {
            System.out.println("Something wrong!");
        } else {
            System.out.println(ans);
        }

    }

    static int find() {
        int len = -1;
        // 누적합이 S이상인 부분 수열 길이 구하기
        // 길이가 1일때 누적합을 넘는가
        // 길이가 2일때 누적합을 넘는가
        // ...
        // 길이가 N일때 누적합을 넘는가
        return len;
    }

    static boolean isOver(int n) {
        if (n >= S) {
            return true;
        } else {
            return false;
        }
    }

}
