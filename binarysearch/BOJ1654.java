package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1654 {
    static int[] kLines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken()); // 1<= K <=10,000
        int N = Integer.parseInt(st.nextToken()); // 1<= N <= 1,000,000

        kLines = new int[K];
        for (int i = 0; i < kLines.length; i++) {
            kLines[i] = Integer.parseInt(br.readLine());
        } // 1<= kLines[i] <= 2^31-1

        long ans = searching(N);
        if (ans == -1) {
            System.out.println("Something Wrong!");
        } else {
            System.out.println(searching(N));
        }

    }

    static long searching(int N) { // O(Klg(i))
        long st = 1;
        long en = (long) (Math.pow(2, 31)) - 1;

        // 길이가 짧을 수록 갯수 많아짐
        while (st <= en) {
            long mid = (st + en) / 2;
            int value = counting((int) mid);
            // System.out.println("st : " + st + ", en : " + en + ", mid : " + mid);

            if (value < N) {
                en = mid - 1;
            } else if (value >= N) {
                st = mid + 1;
            }
        }

        return en;
    }

    // O(K)
    static int counting(int length) {
        int cnt = 0;
        for (int i = 0; i < kLines.length; i++) {
            cnt += kLines[i] / length;
        }
        return cnt;
    }
}
