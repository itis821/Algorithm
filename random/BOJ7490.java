package random;

import java.io.*;
import java.util.*;

public class BOJ7490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] susik = new char[N - 1];

            find(0, N, susik);
        }
    }

    static void find(int depth, int N, char[] susik) {
        if (depth == N - 1) {
            if (calculate(susik) == 0) {
                print(susik);
            }

            return;
        }

        char[] s = { '+', '-', ' ' };

        for (int i = 0; i < 3; i++) {
            susik[depth] = s[i];
            find(depth + 1, N, susik);
        }
    }

}
