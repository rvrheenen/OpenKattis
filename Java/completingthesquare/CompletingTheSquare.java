// Team effort during the preliminaries.
import java.io.*;
import java.util.*;

public class CompletingTheSquare {
    public static void main(String[] args) throws IOException {
        IO io = new IO(System.in);

        double[] x = new double[5];
        double[] y = new double[5];

        x[0] = io.nextDouble();
        y[0] = io.nextDouble();
        x[1] = io.nextDouble();
        y[1] = io.nextDouble();
        x[2] = io.nextDouble();
        y[2] = io.nextDouble();

        double maxdist = 0;
        int point = -1;
        double dist01 = Math.sqrt(Math.pow(Math.abs(x[0] - x[1]), 2) + Math.pow(Math.abs(y[0] - y[1]), 2));
        double dist02 = Math.sqrt(Math.pow(Math.abs(x[0] - x[2]), 2) + Math.pow(Math.abs(y[0] - y[2]), 2));
        double dist12 = Math.sqrt(Math.pow(Math.abs(x[1] - x[2]), 2) + Math.pow(Math.abs(y[1] - y[2]), 2));

        if (dist01 > maxdist) {
            maxdist = dist01;
            point = 2;
        }
        if (dist02 > maxdist) {
            maxdist = dist02;
            point = 1;
        }
        if (dist12 > maxdist) {
            maxdist = dist12;
            point = 0;
        }
        double slope = 0;
        double xoff = 0;
        if (point == 0) {
            if (x[1] == x[2]) {
                x[3] = x[0] + (int) (maxdist);
                y[3] = y[0];
                x[4] = x[0] - (int) (maxdist);
                y[4] = y[0];
            } else {
                slope = (y[1] - y[2]) / (x[1] - x[2]);
                if (slope == 0) {
                    xoff = 0;
                    x[3] = x[0];
                    y[3] = y[0] + (int) (maxdist);
                    x[4] = x[0];
                    y[4] = y[0] - (int) (maxdist);

                } else {
                    slope = (1 / slope) * -1;
                    xoff = Math.sqrt(maxdist * maxdist / (1 + slope * slope));
                    x[3] = x[0] + round(xoff);
                    y[3] = y[0] + round(xoff * slope);
                    x[4] = x[0] - round(xoff);
                    y[4] = y[0] + round(xoff * -1 * slope);
                }
            }

            double dist31 = Math.sqrt(Math.pow(Math.abs(x[3] - x[1]), 2) + Math.pow(Math.abs(y[3] - y[1]), 2));
            double dist32 = Math.sqrt(Math.pow(Math.abs(x[3] - x[2]), 2) + Math.pow(Math.abs(y[3] - y[2]), 2));
            if (dist31 == dist32 && dist31 == dist01) {
                System.out.printf("%.0f %.0f\n", x[3], y[3]);
            } else {
                System.out.printf("%.0f %.0f\n", x[4], y[4]);
            }
        }
        if (point == 1) {
            if (x[0] == x[2]) {
                x[3] = x[1] + (int) (maxdist);
                y[3] = y[1];
                x[4] = x[1] - (int) (maxdist);
                y[4] = y[1];
            } else {
                slope = (y[0] - y[2]) / (x[0] - x[2]);
                if (slope == 0) {
                    xoff = 0;
                    x[3] = x[1];
                    y[3] = y[1] + (int) (maxdist);
                    x[4] = x[1];
                    y[4] = y[1] - (int) (maxdist);
                } else {
                    slope = (1 / slope) * -1;
                    xoff = Math.sqrt(maxdist * maxdist / (1 + slope * slope));
                    x[3] = x[1] + round(xoff);
                    y[3] = y[1] + round(xoff * slope);
                    x[4] = x[1] - round(xoff);
                    y[4] = y[1] + round(xoff * -1 * slope);
                }
            }

            double dist30 = Math.sqrt(Math.pow(Math.abs(x[3] - x[0]), 2) + Math.pow(Math.abs(y[3] - y[0]), 2));
            double dist32 = Math.sqrt(Math.pow(Math.abs(x[3] - x[2]), 2) + Math.pow(Math.abs(y[3] - y[2]), 2));

            if (dist30 == dist32 && dist30 == dist12) {
                System.out.printf("%.0f %.0f\n", x[3], y[3]);
            } else {
                System.out.printf("%.0f %.0f\n", x[4], y[4]);
            }
        }
        if (point == 2) {
            if (x[0] == x[1]) {
                x[3] = x[2] + (int) (maxdist);
                y[3] = y[2];
                x[4] = x[2] - (int) (maxdist);
                y[4] = y[2];
            } else {
                slope = (y[1] - y[0]) / (x[1] - x[0]);
                if (slope == 0) {
                    xoff = 0;
                    x[3] = x[2];
                    y[3] = y[2] + (int) (maxdist);
                    x[4] = x[2];
                    y[4] = y[2] - (int) (maxdist);
                } else {
                    slope = (1 / slope) * -1;
                    xoff = Math.sqrt(maxdist * maxdist / (1 + slope * slope));
                    x[3] = x[2] + round(xoff);
                    y[3] = y[2] + round(xoff * slope);
                    x[4] = x[2] - round(xoff);
                    y[4] = y[2] + round(xoff * -1 * slope);
                }
            }
            double dist31 = Math.sqrt(Math.pow(Math.abs(x[3] - x[1]), 2) + Math.pow(Math.abs(y[3] - y[1]), 2));
            double dist30 = Math.sqrt(Math.pow(Math.abs(x[3] - x[0]), 2) + Math.pow(Math.abs(y[3] - y[0]), 2));
            if (dist31 == dist30 && dist31 == dist12) {
                System.out.printf("%.0f %.0f\n", x[3], y[3]);
            } else {
                System.out.printf("%.0f %.0f\n", x[4], y[4]);
            }
        }

        io.close();

    }

    public static int round(double getal) {
        if (getal < 0) {
            getal -= 0.5;
        } else {
            getal += 0.5;
        }
        return (int) getal;
    }

    static class IO extends PrintWriter {
        static BufferedReader r;
        static StringTokenizer t;

        public IO(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
            t = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!t.hasMoreTokens()) {
                t = new StringTokenizer(r.readLine());
            }
            return t.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
