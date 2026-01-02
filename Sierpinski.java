public class Sierpinski {
    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }
    
    public static void sierpinski(int n) {
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setScale(0, 1);
        double x1 = 0.5;
        double y1 = 0.866;
        double x2 = 0.0;
        double y2 = 0.0;
        double x3 = 1.0;
        double y3 = 0.0;
        sierpinski(n, x1, x2, x3, y1, y2, y3);
    }
    
    private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {
        if (n == 0) {
            double[] x = {x1, x2, x3};
            double[] y = {y1, y2, y3};
            StdDraw.polygon(x, y);
            return;
        }
        double mx12 = (x1 + x2) / 2.0;
        double my12 = (y1 + y2) / 2.0;
        double mx23 = (x2 + x3) / 2.0;
        double my23 = (y2 + y3) / 2.0;
        double mx31 = (x3 + x1) / 2.0;
        double my31 = (y3 + y1) / 2.0;
        sierpinski(n - 1, x1, mx12, mx31, y1, my12, my31);
        sierpinski(n - 1, mx12, x2, mx23, my12, y2, my23);
        sierpinski(n - 1, mx31, mx23, x3, my31, my23, y3);
    }
}