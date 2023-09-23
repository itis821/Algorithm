package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class BOJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 최대 10만
        Map<Long, Integer> map = new HashMap<>();

        Long key;
        Long min_key = Long.MAX_VALUE;
        int value;
        int max_value = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            key = Long.parseLong(br.readLine());

            if (map.containsKey(key)) {

                value = map.get(key) + 1;
                map.put(key, value);

            } else {
                value = 1;
                map.put(key, value);
            }

            if (value == max_value && min_key > key) {
                min_key = key;
            } else if (value > max_value) {
                min_key = key;
                max_value = value;
            }
        }

        System.out.println(min_key);

    }

}
