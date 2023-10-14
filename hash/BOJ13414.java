package hash;

import java.io.*;
import java.util.*;

public class BOJ13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken()); // 1 <= 수강 가능 인원 <= 100,000
        int L = Integer.parseInt(st.nextToken()); // 1 <= 대기 목록 길이 <= 500,000

        Map<String, Integer> map = new HashMap<>();

        int ss = 0;
        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            map.put(num, ss++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (i >= list.size())
                break;
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);
    }

}
