package others;

import java.util.*;

public class Point {
    private int x;
    public Point(int x){
        this.x = x;
    }
    public int hashCode(){
        return 2;
    }

    public static void main(String[] args) {
        Point point1 = new Point(1);
        Point point2 = new Point(2);

        Set<Point> set = new HashSet<>();
        set.add(point1);
        set.add(point2);
        set.add(null);

        System.out.println(set.size());
        System.out.println(set);




    }
}
