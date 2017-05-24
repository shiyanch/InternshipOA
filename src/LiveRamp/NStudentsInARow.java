package LiveRamp;

public class NStudentsInARow {
    public int range(int[] nums) {

        int maxSoFar = nums[0];
        int minSoFar = nums[nums.length-1];
        int firstOurOfOrder = -1;
        int lastOutOfOrder = -1;

        for(int i=1;i<nums.length;i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if(maxSoFar != nums[i]) {
                lastOutOfOrder = i;
            }
        }

        for(int i=nums.length-2;i>=0;i--) {
            minSoFar = Math.min(minSoFar, nums[i]);
            if(minSoFar != nums[i]) {
                firstOurOfOrder = i;
            }
        }

        return lastOutOfOrder - firstOurOfOrder + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,5,4,8,2,1};
        System.out.println(new NStudentsInARow().range(nums));
    }
}
