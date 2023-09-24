package recursion;

import java.util.*;
import java.io.*;

public class BOJ1629 {
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(recursion(A, B));
    }

    static long recursion(long A, long B) {
        long ans;
        if (B == 1L) {
            return A % C;
        }
        long temp = recursion(A, B / 2);

        if (B % 2 == 0L) {
            ans = temp * temp % C;
        } else {
            ans = (temp * temp % C) * A % C;
        }

        return ans;
    }
}
