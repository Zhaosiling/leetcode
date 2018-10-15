package answer;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-10 下午5:06
 */
public class StringZConvert {
    static public String convert(String s, int numRows) {
        int size = s.length();
        if (size < 2) {
            return s;
        }

        if (numRows < 2) {
            return s;
        }

        int partChars = numRows + (numRows - 2);
        int partCols = numRows - 1;
        int cols = (size / partChars + 1) * partCols;
        char[][] bitmaps = new char[numRows][cols];

        for (int i = 0; i < size; i ++) {
            int p = i % partChars;

            int c = i / partChars * partCols + (p > numRows-1 ? p-numRows+1 : 0);
            int r = p >= numRows ? (numRows-1)*2-p : p;

            bitmaps[r][c] = s.toCharArray()[i];
        }

        int pos = 0;
        char[] value = new char[size];
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j < cols; j++) {
                if (bitmaps[i][j] > 0) {
                    value[pos++] = bitmaps[i][j];
                }
            }
        }

        return String.valueOf(value);
    }

    static public void main(String[] argvs) {
        String p = "PAYPALISHIRING";
        String a = convert(p,3);
        System.out.println(a);

        String p2 = "A";
        String a2 = convert(p2,1);
        System.out.println(a2);

        String case3 = "rsdqxvfbojelwjgercerapacvypxdmqxevpbsucieitctbikdmdfdfkydzvjlngpkvqcsunyeiaxkijnwnvzsfzye";
        String answer3 = convert(case3,75);
        System.out.println(answer3);
    }
}
