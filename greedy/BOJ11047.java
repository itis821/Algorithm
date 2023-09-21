package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 1<= N <=10
        int K = Integer.parseInt(st.nextToken()); // 1<= K <= 100,000,000
        int[] m = new int[N];

        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int i = N - 1;
        while (K != 0) {
            if (K >= m[i]) {
                cnt += K / m[i];
                K = K % m[i];

            }
            i--;
        }

        System.out.println(cnt);
    }
}
