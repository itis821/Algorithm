package simulation;

import java.io.*;
import java.util.*;

public class BOJ14889 {
    // 차의 절대값
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[][] info;
    static boolean[] isTeam1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 4<= N <= 20

        info = new int[N][N];
        isTeam1 = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken()); // 1<= info <= 100
            }
        }

        // combination을 통해 팀을 뽑음
        // 팀의 능력치 합을 뺌
        comb(0, 0);

        // output
        System.out.println(ans);
    }

    static void comb(int depth, int at) {
        if (depth == N / 2) {
            // int[] sum = calculate();
            // ans = Math.min(ans, Math.abs(sum[0] - sum[1]));

            System.out.println("============");
            for (int i = 0; i < N; i++) {
                System.out.print(isTeam1[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < N; i++) {
                if (isTeam1[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            for (int i = 0; i < N; i++) {
                isTeam1[i] = false;
            }

            return;
        }

        for (int i = at; i < N; i++) {
            isTeam1[i] = true;
            comb(depth + 1, i + 1);
            isTeam1[i] = false;
        }
    }

    // static int[] calculate() {
    // // team1 의 조합 찾기
    // int[] semiTeam1 = new int[2];
    // int[] semiTeam2 = new int[2];

    // combTeam(0, 0, semiTeam1); // team1 중 2명 고르기
    // combTeam(0, 0, semiTeam2); // team1 중 2명 고르기

    // return new int[] { team1Sum, team2Sum };
    // }

    // static void combTeam(int depth, int at, int[] semiTeam) {
    // if (depth == 2) {

    // team1Sum += info[semiTeam[0]][semiTeam[1]];
    // team1Sum += info[semiTeam[1]][semiTeam[0]];

    // return;
    // }

    // for (int i = at; i < teamArr.length; i++) {
    // semiTeam[depth] = teamArr[i];
    // combTeam(depth + 1, i + 1, semiTeam);
    // }
    // }
}
