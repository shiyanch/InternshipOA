package LinkedIn;

import java.util.HashSet;
import java.util.Set;

/**
 * count different palindrome in a String
 */
public class DifferentPalindrome {
    public int differentPalindrome(String s) {
        boolean[][] pair = new boolean[s.length()][s.length()];
        Set<String> set = new HashSet<String>();

        for(int i=0;i<s.length();i++) {
            for(int j=0;j<=i;j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j<=1 || pair[j+1][i-1])) {
                    pair[j][i] = true;
                    set.add(s.substring(j, i+1));
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new DifferentPalindrome().differentPalindrome("ababa"));
    }
}
