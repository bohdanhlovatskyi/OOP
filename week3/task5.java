import java.util.Scanner;

class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String line = sc.nextLine();
        StringBuilder reversed_string = new StringBuilder();
        
        for (String word : line.split("\\W+")) {
            reversed_string.append(new StringBuilder(word).reverse().append(' ').toString());
        }   

        System.out.println(reversed_string);
    }
}