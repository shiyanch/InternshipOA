package Coursera;

import java.util.Scanner;

/**
 * Created by shiyanch on 10/22/16.
 */
public class Problem2 {
    public static void main(String[] args) {
//        String[] steps = {"2 3", "3 7", "4 1"};
        String[] steps = {"1000000 1000000"};
        System.out.println(countX(steps));

    }

    static long countX(String[] steps) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for(String step : steps) {
            String[] location = step.split(" ");
            x = Math.min(x, Integer.parseInt(location[0]));
            y = Math.min(y, Integer.parseInt(location[1]));
        }
        return (long)x*y;
    }
}
