import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepeatingDecimal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = "";
        String[] line = new String[4];

        while ((inp = br.readLine()) != null) {
            line = inp.split(" ");
            BigDecimal a = new BigDecimal(Integer.parseInt(line[0]));
            BigDecimal b = new BigDecimal(Integer.parseInt(line[1]));
            int c = Integer.parseInt(line[2]);
            System.out.println(a.divide(b, c + 1, RoundingMode.DOWN).setScale(c, RoundingMode.DOWN));
        }
    }
}
