package sort;

import java.io.*;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1000
        int C = Integer.parseInt(st.nextToken()); // 1 <= C <= 10억

        Map<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());

        // LinkedHashMap을 이용하여 입력횟수는 유지하며 counting
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // LinkedHashMap을 List에 삽입
        List<int[]> list = new ArrayList<>();

        for (Integer key : map.keySet()) {
            list.add(new int[] { key, map.get(key) });
        }

        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int[] nums = list.get(i);

            for (int j = 0; j < nums[1]; j++) {
                sb.append(nums[0]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
