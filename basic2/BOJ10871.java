package basic2;

import java.io.*;

public class BOJ10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);

        String[] str2 = br.readLine().split(" ");

        int a = 0;
        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(str2[i]);
            if (a < x) {
                bw.write(a + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
