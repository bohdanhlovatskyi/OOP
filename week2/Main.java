import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = compress(s);
        System.out.println(s);
        System.out.println(decompress(s));
    }


    /**
     * Compresseas strings according to the following method:
     * If string contains more than 2 chars in a row they should be removed
     * and encoded like char+numberOfChars
     * For instance, "aaaabbbcc" a4b3c2.
     *
     * a4b3c2 into aaaabbbcc
     */
    public static String compress(String target){
        ArrayList<Character> out = new ArrayList<>(target.length());
        int repeats = 1;

        char[] arr = target.toCharArray();
        char prev = arr[0];
        char cur;

        for (int i = 1; i < arr.length; i++) {
            cur = arr[i];
            // System.out.printf("%c %c %d %s\n", cur, prev, repeats, out);
            if (cur == prev) {
                repeats++;
            } else {
                out.add(prev);
                if (repeats > 1) {
                    out.add((char)(repeats + '0'));
                    repeats = 1;
                }
            }
            prev = cur;
            // System.out.printf("--- %c %c %d %s\n", cur, prev, repeats, out);
        }

        out.add(prev);
        if (repeats > 1) {
            out.add((char)(repeats + '0'));
        }

        return out.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }



    public static String decompress(String target){
        ArrayList<Character> target_msg = new ArrayList<>(target.length());
        char prev_letter, cur_letter;
        prev_letter = target.charAt(0);
        for (int i = 0; i < target.length(); i++) {
            cur_letter = target.charAt(i);
            if (Character.isLetter(cur_letter) || Character.isSpaceChar(cur_letter)) {
                target_msg.add(cur_letter);
                prev_letter = cur_letter;
            }
            if (Character.isDigit(cur_letter)) {
                for (int j = 0; j < Character.digit(cur_letter, 10) - 1; j++) {
                    target_msg.add(prev_letter);
                }
            }
        }
        // this converts ArrayList of characters to a string
        return target_msg.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}

class Fib {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BigInteger[] arr = new BigInteger[n + 1];
        // little handler of bad cases
        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }

        System.out.println(arr[n]);
    }
}

class Sos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calculate(s));

    }


    /**
     * Sami's spaceship crashed on Mars! She sends a series of SOS messages to Earth for help.
     * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
     *
     * Given the signal received by Earth as a string, determine how many letters of Sami's SOS
     * have been changed by radiation.
     * For example, Earth receives SOSTOT. Sami's original message was SOSSOS.
     * Two of the message characters were changed in transit.
     *
     * Function  should return an integer representing the number of letters changed during transmission.
     * Note: As the original message is just SOS repeated  n  times, so string length will be a multiple of 3
     */
    public static int calculate(String target){
        int lettersChanged = 0;
        for (int i = 0; i < target.length(); i += 3) {
            lettersChanged += calcultaForTriplet(target.substring(i, i+3));
        }
        return lettersChanged;
    }

    public static int calcultaForTriplet(String triplet) {
        int lettersChanged = 0;
        String strToCompare = new String("SOS");
        for (int i = 0; i < 3; i++) {
            if (strToCompare.charAt(i) != triplet.charAt(i)) {
                lettersChanged += 1;
            }
        }

        return lettersChanged;
    }
}

class Mtx {

    /**
     * For the input N create matrix NxN that will have next values.
     *
     *     Example for N = 5
     *
     *    [[ 1,  2,  3,  4,  5],
     *     [16, 17, 18, 19,  6],
     *     [15, 24, 25, 20,  7],
     *     [14, 23, 22, 21,  8],
     *     [13, 12, 11, 10,  9]]
     *
     *     [[1 2],
     *      [4 3]]
     *
     *      [[1 2 3],
     *       [8 9 4],
     *       [7 6 5]]
     *
     *       0 1 2 | 5 8 | 7 6 4 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = rows;

        Integer[][] arr = new Integer[rows][cols];
        System.out.println(Arrays.deepToString(arr));
        traverseRectangle(arr, 1);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void traverseRectangle(Integer[][] mtx, Integer cur_num) {
        int right = mtx[0].length - 1;
        int bottom = mtx.length - 1;
        if (right == 0 || bottom == 0) {
            // recursion base case
            mtx[0][0] = cur_num;
            return;
        }
        int top = 0;
        int left = 0;
       //  System.out.printf("%d %d %d %d\n", left, right, top, bottom);

        while (left < right) {
            System.out.printf("at the beginning: %d  %d %d %d\n ", left, right, top, bottom);
            System.out.println(Arrays.deepToString(mtx));
            for (; left < right; left++) {
                mtx[top][left] = cur_num;
                cur_num++;
            }

            for (; top <= bottom; top++) {
                mtx[top][left] = cur_num;
                cur_num++;
            }

            top--; // as we increment it in the loop
            left--;
            for (; left >= 0; left--) {
                mtx[top][left] = cur_num;
                cur_num++;
            }

            left++;
            for (; top > 0; top--) {
                mtx[top][left] = cur_num;
                cur_num++;
            }

            // make the bounds smaller
            // why on earth does the recursion not work???
            left++;
            right--;
            top++;
            bottom--;
        }
    }

    public static Integer[][] submtx(Integer[][] mtx) {
        // copyOfRange conducts shallow copy if applied to wrapper
        Integer[][]res = Arrays.copyOfRange(mtx, 1, mtx.length - 1);

        for (int i = 0; i < res.length; i++) {
            res[i] = Arrays.copyOfRange(res[i], 1, res[i].length - 1);
        }

        return res;
    }
}

class MtxTranspose {
    /**
     * Implement rotation of X-image on 90 degrees.
     * Let X = [[1, 2, 3], [4, 5, 6], [7, 8, 9]],
     * where each element of the matrix is a corresponding pixel in the image.
     * The result of rotating the image X will be [[7, 4, 1], [8, 5, 2], [9, 6, 3]].
     * Use Arrays.deepToString(m) for converting array to String.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n_x = scanner.nextInt();
        int n_y = scanner.nextInt();

        Integer[][] mtx = createMatrix(n_x, n_y);

        System.out.println(Arrays.deepToString(mtx));
        simpleRotate(mtx);
        System.out.println(Arrays.deepToString(mtx));
    }

    public static Integer[][] createMatrix(int n_x, int n_y) {
        Integer[][] mtx = new Integer[n_x][n_y];
        int cur_num = 1;
        for (int i = 0; i < n_x; i++) {
            for (int j = 0; j < n_y; j++) {
                mtx[i][j] = cur_num;
                cur_num++;
            }
        }

        return mtx;
    }

    public static void simpleRotate(Integer[][] mtx) {
        int size = mtx.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int temp = mtx[i][j];
                mtx[i][j] = mtx[size - 1 - j][i];
                mtx[size - 1 - j][i] = mtx[size - 1 - i][size - 1 - j];
                mtx[size - 1 - i][size - 1 - j] = mtx[j][size - 1 - i];
                mtx[j][size - 1 - i] = temp;
            }
        }
    }
}
