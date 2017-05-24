public class FatKa {
    public static void main(String[] args) {

    }

    public static double area(int x1, int y1, int r1, int x2, int y2, int r2) {
        // distance of two centre of circles
        double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

        // make r1 hold the smaller radius
        if (r1 > r2) {
            double tmp = r1;
            r1 = r2;
            r2 = r1;
        }

        if (r1 + r2 <= distance) {
            // Only one or none intersection point
            return 0.0;
        }
        else if (r2 - r1 >= distance) {
            // Circle 2 encircles circle 1
            return Math.PI * r1 * r1;
        }
        else {
            // angel of left triangle
            double angel1 = Math.acos((r1*r1+distance*distance-r2*r2)/(2.0*r1*distance));

            // angel of right triangle
            double angel2 = Math.acos((r2*r2+distance*distance-r1*r1)/(2.0*r2*distance));

            // intersection area is the sum of areas of two sectors, minus the area of the quadrilateral
            return (angel1*r1*r1 + angel2*r2*r2 - r1*distance*Math.sin(angel1));
        }
    }
}
