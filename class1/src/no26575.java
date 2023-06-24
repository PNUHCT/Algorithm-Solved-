import java.io.*;
import java.util.StringTokenizer;

public class no26575 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static double doubleValue, Dogs, FoodPerDog, CostPerPound;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Dogs = Double.parseDouble(st.nextToken());
            FoodPerDog = checkZero(st.nextToken());
            CostPerPound = checkZero(st.nextToken());

            System.out.println(String.format("$%.2f", Dogs * FoodPerDog * CostPerPound));
        }
    }

    private static double checkZero(String input) {
        if(input.charAt(0)=='.') doubleValue = Double.parseDouble("0" + input);
        else doubleValue = Double.parseDouble(input);
        return doubleValue;
    }
}

