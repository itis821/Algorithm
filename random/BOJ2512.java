package random;

import java.io.*;
import java.util.*;

class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 3<= N <=10,000
        int[] yesanYochung = new int[N]; // 1<= xi <= 100,000;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            yesanYochung[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // N <= M <= 1,000,000,000 -> 1억

        // 정수 상한액 정하기
        Arrays.sort(yesanYochung);
        int yesanHap = 0; // 1,000,000,000 // 최대 1억

        for (int i = 0; i < N; i++) {
            yesanHap += yesanYochung[i];
        }

        // 예산 합이 M보다 작거나 같은 경우
        if (yesanHap <= M) {
            System.out.println(yesanYochung[N - 1]);
            return;

        } else {// 예산 합이 M보다 큰 경우
            // M/N -> 평균을 구해준다.
            // 평균을 상한으로 정하면
            int sanghan = M / N;
            int current = 0;

            for (int i = 0; i < N; i++) {

                // 상한보다 예산을 적게 요청한 경우
                if (yesanYochung[i] <= sanghan) {

                    // 현재 예산에 그 놈을 더함 저장
                    current += yesanYochung[i];

                    sanghan = (M - current) / (N - 1 - i);
                } else {
                    break;
                }

            }

            System.out.println(sanghan);

        }

    }
}