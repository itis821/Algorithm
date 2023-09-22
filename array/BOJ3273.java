package array;

import java.io.*;
import java.util.*;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        int cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1<=n<=100,000 , n^2 = 10,000,000,000
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine()); // 1<=x<=2,000,000

        int fi = 0;
        int li = n - 1;

        while (fi < li) {
            if (arr[fi] + arr[li] > x) {
                li--;
            } else if ((arr[fi] + arr[li]) == x) {
                cnt++;
                fi++;
            } else if (arr[fi] + arr[li] < x) {
                fi++;
            }
        }

        System.out.println(cnt);

    }

}
