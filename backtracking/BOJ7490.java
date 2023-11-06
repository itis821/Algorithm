package backtracking;

import java.io.*;
import java.util.*;

public class BOJ7490 {
    static char[] gihoArr;
    static char[] giho = { '+', ' ', '-' };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트케이스
        for (int t = 0; t < T; t++) {
            // 3 <= N <= 9
            int N = Integer.parseInt(br.readLine());
            gihoArr = new char[N - 1];
            find(0, N);
        }
    }

    // 백트래킹
    static void find(int depth, int N) {
        if (depth == N - 1) {
            if (calcul(N) == 0) {
                print();
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            gihoArr[depth] = giho[i];
            find(depth + 1, N);
        }
    }

    static int calcul(int N) {
        List<Integer> sootjaList = new LinkedList<>();
        List<Character> gihoList = new LinkedList<>();
        int sum = -1;

        // 숫자 초기화(N개)
        for (int i = 1; i <= N; i++) {
            sootjaList.add(i);
        }

        // 기호 초기화 (N-1개)
        for (int i = 0; i < N - 1; i++) {
            gihoList.add(gihoArr[i]);
        }

        // 공백 처리
        int idx = 0;

        while (idx < gihoList.size()) {

            // 공백인 경우
            if (gihoList.get(idx) == ' ') {
                int a = sootjaList.get(idx);
                int b = sootjaList.get(idx + 1);

                sootjaList.remove(idx);
                sootjaList.remove(idx);

                gihoList.remove(idx);

                sootjaList.add(idx, 10 * a + b);
                idx--;
            }
            idx++;

        }

        // 나머지 계산
        sum = sootjaList.get(0);

        for (int i = 0; i < gihoList.size(); i++) {

            if (gihoList.get(i) == '+') {

                sum += sootjaList.get(i + 1);

            } else if (gihoList.get(i) == '-') {
                sum -= sootjaList.get(i + 1);
            }
        }

        return sum;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < gihoArr.length; i++) {
            sb.append(i + 1).append(gihoArr[i]);
        }
        sb.append(gihoArr.length + 1);

        System.out.println(sb);
    }

}
