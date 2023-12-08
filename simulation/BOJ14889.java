package simulation;

import java.io.*;
import java.util.*;

class BOJ14889 {
    static int ans = Integer.MAX_VALUE;

    static int[] teamA;
    static int[] teamB;
    static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 4<= N <= 20, 짝수
        S = new int[N][N]; // 1<= S[i][j] <= 100, 정수
        teamA = new int[N / 2];
        teamB = new int[N / 2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(teamA.length, 0, 0, N, teamA);
        System.out.println(ans);
    }

    static void comb(int n, int depth, int at, int N, int[] result) {
        // N명 중 n개 뽑기
        if (depth == n) {
            fillTeamB(N);
            int powerA = getPower(teamA);
            int powerB = getPower(teamB);
            ans = Math.min(ans, Math.abs(powerA - powerB));
            return;
        }

        for (int i = at; i < N; i++) {
            result[depth] = i;
            comb(n, depth + 1, i + 1, N, result);
        }
    }

    static int getPower(int[] team) {
        int[] power = new int[1];
        int[] pair = new int[2];
        comb2(team, power, 0, 0, pair);
        return power[0];
    }

    static void comb2(int[] team, int[] power, int depth, int at, int[] pair) {
        if (depth == 2) {
            power[0] += S[pair[0]][pair[1]];
            power[0] += S[pair[1]][pair[0]];
            return;
        }

        for (int i = at; i < team.length; i++) {
            pair[depth] = team[i];
            comb2(team, power, depth + 1, i + 1, pair);
        }
    }

    static void fillTeamB(int N) {
        boolean[] isTeamA = new boolean[N];

        for (int i = 0; i < teamA.length; i++) {
            isTeamA[teamA[i]] = true;
        }

        int bidx = 0;
        for (int i = 0; i < N; i++) {
            if (!isTeamA[i]) {
                teamB[bidx++] = i;
            }
        }
    }
}
