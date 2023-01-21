package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) zero.add(i);
            else if (arr.get(i) > 0) plus.add(i);
            else minus.add(i);
        }
        double longPlus = plus.size();
        double longMinus = minus.size();
        double longZero = zero.size();
        double pluss = longPlus / arr.size();
        double minuss = longMinus / arr.size();
        double zeros = longZero / arr.size();

        System.out.println(String.format("%.6f", pluss));
        System.out.println(String.format("%.6f", minuss));
        System.out.println(String.format("%.6f", zeros));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
