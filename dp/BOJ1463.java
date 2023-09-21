package dp;

import java.util.*;
import java.io.*;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] arr = new int[2];
        arr[0] = X;
        arr[1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(arr);

        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == 1) {
                System.out.println(c[1]);
                break;
            }

            if (c[0] % 3 == 0) {
                q.offer(new int[] { c[0] / 3, c[1] + 1 });
            }

            if (c[0] % 2 == 0) {
                q.offer(new int[] { c[0] / 2, c[1] + 1 });
            }

            if (c[0] - 1 > 0) {
                q.offer(new int[] { c[0] - 1, c[1] + 1 });
            }
        }
    }

}
