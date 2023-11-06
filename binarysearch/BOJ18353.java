package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1<= N <= 2,000

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] byungsa = new int[N];
        for (int i = 0; i < N; i++) { // 1<= N <= 2,000
            // 1 <= byungsa[i] <= 10^7
            byungsa[i] = Integer.parseInt(st.nextToken());
        }

        // 남아있는 병사의 수가 최대가 되도록 하기 위해서
        // 열외해야 하는 병사의 수

    }

}
