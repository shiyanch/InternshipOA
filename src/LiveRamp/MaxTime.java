package LiveRamp;

import java.util.ArrayList;
import java.util.List;

public class MaxTime {

    public static void main(String[] args) {
        System.out.println(new MaxTime().showTime());
    }

    public String showTime() {
        int[] nums = new int[] {0,0,0,1};
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        backtrack(ans, nums, sb, 0);
        if(ans.isEmpty()) {
            return "NOT POSSIBLE";
        }

        String max = "0000";
        for (String s: ans) {
            if(s.compareTo(max) > 0) {
                max = s;
            }
        }

        return max.substring(0,2) + ":" +max.substring(2);
    }

    private void backtrack(List<String> validTimes, int[] nums, StringBuffer currentTime, int index) {
        if(currentTime.length() == nums.length) {
            if(currentTime.toString().compareTo("2400") < 0) {
                validTimes.add(currentTime.toString());
            }
            return;
        }

        int n = nums[index];
        for(int i=0;i<=currentTime.length();i++) {
            StringBuffer copy = new StringBuffer(currentTime);
            copy.insert(i, n);
            backtrack(validTimes, nums, copy, index+1);
        }
    }
}
