import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

class Task1 {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Reads n - number of ints to process from System.in
     *
     * Prints out min, max, avg, sum and prod
     */
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.printf("You specified %d to process\n", n);
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
            // System.out.printf("%d: %d\n", i, arr[i]);
        }

        // stream - sequence of objects that supports pipelined methods
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        int min = stat.getMin();
        int max = stat.getMax();
        double avg = stat.getAverage();
        int sum = (int) stat.getSum();
        int prod = 1;
        for (int j = 0; j < arr.length; j++) {
            prod *= arr[j];
        }

        // prepares the avg for a nice output
        String avgStr;
        if (avg % 1.0 != 0)
            avgStr = String.format("%s", avg);
        else
            avgStr = String.format("%.0f", avg);

        // System.out.printf("min: %d max: %d avg: %d sum: %d prod: %d\n", min, max, avg, sum, prod);

        System.out.printf("%d %d %s %d %d\n", max, min, avgStr, sum, prod);
    };
};

class Task2 {
    public static Scanner sc = new Scanner(System.in);

    /** The Collatz conjecture is a conjecture in mathematics
     *  that concerns a sequence defined as follows:
     *
     *  start with any positive integer n.
     *  Then each term is obtained from the previous term as follows:
     *      if the previous term is even, the next term is one half the previous term.
     *      If the previous term is odd, the next term is 3 times the previous term plus 1.
     *
     *  The conjecture is that no matter what value of n,
     *  the sequence will always reach 1.
     *  Since the hypothesis is mathematically not yet proven,
     *  then implement a program that, by a given number,
     *  derives the sequence and proves the Collatz conjecture.
     */
    public static void main(String[] args) {
        int n = sc.nextInt();
        int cur = n;

        while (cur != 1) {
            if (cur % 2 == 0) {
                cur /= 2;
            } else {
                cur = 3 * cur + 1;
            }
            System.out.printf("%d ", cur);
        }
        System.out.println();
    }
};

class Task3 {
    public static Scanner sc = new Scanner(System.in);

    // static means that it is related to class itself, not an object
    // with the same type
    public static void main(String[] arg) {
        String input = sc.nextLine();
        char[] letters = input.toCharArray();

        // for-each loop
        for (char letter : letters) {
            letter = getNextChar(letter);
            System.out.printf("%c|", letter);
        }
    }

    /**
     * https://stackoverflow.com/questions/17124992/incrementing-char-type-in-java
     */
    private static char getNextChar(char c) {
        return (char)((c + 1 - 'a') % ('z' - 'a' + 1) + 'a');
    }
}

class Task4 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) {

        String letter = null;
        List<Character> letters = new ArrayList<Character>();
        while (true) {
            if ((letter = sc.nextLine().trim()).length() != 1) {
                break;
            }

            letters.add(letter.charAt(0));
        }

        for (char ltr : letters) {
            System.out.printf("%c=%d\n", ltr, (int)ltr);
        }
    }
}

class Tack5 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) {
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(str1.equals(str2));
    }
}
