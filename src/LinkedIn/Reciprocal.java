package LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanch on 11/15/16.
 */
public class Reciprocal {
    public static void main(String[] args) {
        int dividend=1;
//        for(int i=1;i<50;i++){
//            String str = circleDigits(dividend,i);
//            if(str!=null){
//                System.out.println(dividend+"/"+i+"-"+str+"-"+(0.0+dividend)/i);
//            }
//        }

        String str = circleDigits(dividend,36);
        System.out.println(str);
    }

    public static String circleDigits(int dividend, int divisor) {
        if (dividend < 0 || divisor <= 0) {
            return null;
        }
        if (dividend % divisor == 0) {
            return null;
        }
        List<Integer> quotientList = new ArrayList<Integer>();//store a/b
        List<Integer> leftList = new ArrayList<Integer>();//store a%b
        int left= dividend % divisor;
        while(!leftList.contains(left)){
            leftList.add(left);
            left*=10;
            int quotient=left / divisor;
            quotientList.add(quotient);
            left%=divisor;
            if(left==0){
                return null;
            }
        }
        int circleBegin=leftList.indexOf(left);

        StringBuilder sb=new StringBuilder("0.");
        for(int i=0;i<circleBegin;i++) {
            sb.append(quotientList.get(i));
        }

        quotientList = quotientList.subList(circleBegin,quotientList.size());
        for(int i=0,len=quotientList.size();i<len;i++){
            sb.append(quotientList.get(i));
        }
        sb.append(" ");
        for(int i=0,len=quotientList.size();i<len;i++){
            sb.append(quotientList.get(i));
        }

        return sb.toString();
    }
}
