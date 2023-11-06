package hash;

import java.io.*;
import java.util.*;

public class BOJ9375 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            int n = Integer.parseInt(br.readLine()); // 0 <= 의상의 수(n) <= 30
            Map<String, Integer> map = new HashMap<>();

            // 의상의 종류
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String category = st.nextToken();

                map.put(category, map.getOrDefault(map.get(category), 1));
            }

            find(map);

            // 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우
            // 종류별 개수
            // headgear : 2
            // eyewear : 1
            // 2 + 1 + 2 -> 5

        } // testcase

        System.out.println(sb);

    }// main

    static void find(Map map) {
        int cnt = 0;

        // 0개인 개인 경우
        if (map.size() == 0) {
            sb.append(0).append('\n');
            return;
        } else {

            int[] mapCnt = new int[map.size()];

            for (String key : map.keySet()) {

            }

            for (int i = 1; i < map.size(); i++) {
                cnt += counting(i);
            }
        }

        sb.append(cnt).append('\n');
    }

}
