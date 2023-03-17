import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> food = new ArrayList<>();
        List<Integer> drink = new ArrayList<>();

        for(int i=0; i<3;i++) food.add(Integer.parseInt(br.readLine()));
        for(int i=0; i<2;i++) drink.add(Integer.parseInt(br.readLine()));
        int foodMin = Collections.min(food);
        int drinkMin = Collections.min(drink);

        System.out.println(foodMin+drinkMin-50);
    }
}