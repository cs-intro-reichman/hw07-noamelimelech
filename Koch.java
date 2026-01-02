public class Koch {
    public static void main(String[] args) {
           curve(Integer.parseInt(args[0]),
          Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
          Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        snowFlake(Integer.parseInt(args[0]));
    }
  
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        } 
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        double x3 = x1 + deltaX / 3.0;
        double y3 = y1 + deltaY / 3.0;
        double x5 = x1 + 2.0 * deltaX / 3.0;
        double y5 = y1 + 2.0 * deltaY / 3.0;
        double x4 = (x1 + x2) / 2.0 + Math.sqrt(3) * (y1 - y2) / 6.0;
        double y4 = (y1 + y2) / 2.0 + Math.sqrt(3) * (x2 - x1) / 6.0;
        curve(n - 1, x1, y1, x3, y3);
        curve(n - 1, x3, y3, x4, y4);
        curve(n - 1, x4, y4, x5, y5);
        curve(n - 1, x5, y5, x2, y2);
    }
    
    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        double x1 = 0.1;
        double y1 = 0.1;
        double x2 = 0.9;
        double y2 = 0.1;
        double x3 = 0.5;
        double y3 = 0.1 + Math.sqrt(3) * 0.8 / 2.0;
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}