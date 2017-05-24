package Coursera;

import java.util.*;

/**
 * Created by shiyanch on 10/22/16.
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {1,1,2,2,3,3};
        int k = 2;
        System.out.println(countParis(nums,k));
    }

    static class Pair {
        private final int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isSame(Pair pair) {
            return (this.x != pair.x && this.y != pair.y) ||
                    (this.x != pair.y && this.y != pair.x);
        }
    }

    static int countParis(int[] numbers, int k) {
        Arrays.sort(numbers);
        List<Pair> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<numbers.length;i++)
            set.add(numbers[i]);

        int prev = -1;
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i] == prev)
                continue;

            if(numbers[i]+k <= numbers[numbers.length-1] && set.contains(numbers[i]+k)) {
                list.add(new Pair(numbers[i], numbers[i]+k));
            }
            prev = numbers[i];
        }

        int diff = 0;
        for(int i=0;i<list.size();i++) {
            Pair curr = list.get(i);
            for(int j=i+1;j<list.size();j++) {
                Pair other = list.get(j);
                if(!curr.isSame(other)) {
                    diff++;
                }
            }
        }

        return diff;
    }

}
