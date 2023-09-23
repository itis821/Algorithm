package sort;

import java.io.*;
import java.util.*;

public class BOJ15688 {
    static final int MINUS = 1000000;

    public static void main(String[] args) throws IOException {
        int[] count = new int[1000000 * 2 + 1];
        // count[0] -> 0, count[1] -> 1, count[MINUS + 1] = -1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if (num >= 0) {
                count[num]++;
            } else {
                count[MINUS + Math.abs(num)]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        // minus
        for (int i = count.length - 1; i > MINUS; i--) {
            for (int j = 0; j < count[i]; j++) {
                sb.append('-').append(i - MINUS).append("\n");
            }
        }

        for (int i = 0; i < count[0]; i++) {
            sb.append('0').append('\n');
        }

        for (int i = 1; i <= MINUS; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }

}
