import java.util.Scanner;

/**
 * Created by shiyanch on 10/22/16.
 */
public class Templates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++) {
                nums[i] = scanner.nextInt();
            }

        }
        scanner.close();
    }


}
