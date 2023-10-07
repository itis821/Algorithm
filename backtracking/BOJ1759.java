package backtracking;

import java.io.*;
import java.util.*;

public class BOJ1759 {

    static StringBuilder sb = new StringBuilder();
    static int L;
    static int C;
    static char[] alpha;
    static char[] password;
    static boolean[] isVisited;

    static int moemCnt;
    static int jaemCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken()); // 3<=L<=15
        C = Integer.parseInt(st.nextToken()); // 3<=C<=15

        alpha = new char[C];
        password = new char[L];
        isVisited = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        find(0);
        System.out.println(sb);

    }// main()

    static void find(int depth) {

        if (depth == L) {
            for (int i = 0; i < password.length; i++) {
                if (isMoem(password[i])) {
                    moemCnt++;
                } else {
                    jaemCnt++;
                }
            }

            if (moemCnt >= 1 && jaemCnt >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(password[i]);
                }
                sb.append('\n');
            }
            moemCnt = 0;
            jaemCnt = 0;
            return;
        }

        for (int i = 0; i < C; i++) {

            if (isVisited[i])
                continue;

            if (depth > 0) {
                if (password[depth - 1] > alpha[i]) {
                    continue;
                }
            }

            password[depth] = alpha[i];

            isVisited[i] = true;
            find(depth + 1);
            isVisited[i] = false;
        }
    }

    static boolean isMoem(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

}
