package LinkedIn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanch on 11/15/16.
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int maxPoints = 1;
        Map<Double, Integer> map = new HashMap<Double, Integer>();

        for (int i = 0; i < points.length - 1; i++) {
            map.clear();
            map.put((double)Integer.MIN_VALUE, 1);
            int dup = 0;

            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                double k = points[j].x - points[i].x == 0 ?
                        Integer.MIN_VALUE :
                        1.0 * (points[i].x - points[j].x) / (points[i].y - points[j].y);

                if (!map.containsKey(k)) {
                    map.put(k, 2);
                }
                else {
                    map.put(k, map.get(k) + 1);
                }
            }

            for(int temp : map.values()) {
                maxPoints = Math.max(maxPoints, temp + dup);
            }

        }
        return maxPoints;
    }

    public static void main(String[] args) {
        Point[] points = new Point[2];
        points[0] = new Point(1,1);
        points[1] = new Point(1,1);
//        points[2] = new Point(1,1);
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }
}
