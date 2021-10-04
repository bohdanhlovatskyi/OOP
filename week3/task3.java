import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

class House {
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private double area;
    private double numberOfFloors;

    public House(double area, double numberOfFloors, int numberOfBedrooms, int numberOfBathrooms) {
        this.area = area;
        this.numberOfFloors = numberOfFloors;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
    }

    // The Yosemite II is a 1,366 sq. ft. 3 bedroom, 2 bathroom single-story home.
    // The Burkburnett II 1 story plan, featuring approximately 2469 sq. ft., is a home with 3 bedrooms, 2 bathrooms, and a 2-car attached garage.
    // Name: 23 Oak Ridge Type: Detached Two+ Story Ownership: Fee simple Beds: 4 Beds Baths: 3 Baths Interior Size: 2812 SqFt Lot Size: - Ceiling Heights: -
    // <span style="padding-top: 5px;display:inline-block;">3 Beds</span>
    // <span style="padding-top: 5px;display:inline-block;">2 Baths</span>
    // <span style="padding-top: 5px;display:inline-block;">2 Baths</span>
    // <span style="padding-top: 5px;display:inline-block;">1959 SqFt</span>
    // This elegant 1-story is soaring with 11-foot ceilings and a spacious floor plan!
    public static House createFromText(String text) {
        double area = parseArea(text);
        double numberOfFloors = parseFloorsNumber(text);
        int numberOfBedrooms = parseNumberOfBedrooms(text);
        int numberOfBathrooms = parseNumberOfBathrooms(text);

        return new House(area, numberOfFloors, numberOfBedrooms, numberOfBathrooms);
    }

    public static double parseArea(String descr) {
        Pattern p = Pattern.compile("(\\d+,?\\d{0,}) (sq|SqFt)");
        Matcher m = p.matcher(descr);
        if (m.find()) {
            String ar = m.group(1).trim().replaceAll(",", "");
            return Double.parseDouble(ar);
        } else {
            return 0;
        }
    }


    public static int parseNumberOfBedrooms(String descr) {
        Pattern p = Pattern.compile("(\\d+) (bedroom|Beds)");
        Matcher m = p.matcher(descr);
        if (m.find()) {
            return Integer.parseInt(m.group(1).trim());
        } else {
            return 0;
        }
    }

    public static int parseNumberOfBathrooms(String descr) {
        Pattern p = Pattern.compile("(\\d+) (bathroom|Baths)");
        Matcher m = p.matcher(descr);
        if (m.find()) {
            return Integer.parseInt(m.group(1).trim());
        } else {
            return 0;
        }
    }

    public static double parseFloorsNumber(String descr) {
        if (descr.indexOf("single") != - 1) {
            return 1;
        } else if (descr.indexOf("1 story") != - 1) {
            return 1;
        } else if (descr.indexOf("1-story") != - 1) {
                return 1;
        } else if (descr.indexOf("Two") != - 1) {
            return 2.5;
        }

        return 0;
    } 

    @Override
    public String toString() {
        return String.format(
            "House{numberOfBedrooms=%d, numberOfBathrooms=%d, area=%f, numberOfFloors=%.1f}",
            this.numberOfBedrooms, this.numberOfBathrooms, this.area, this.numberOfFloors
        );
    }
}

public class task3 {
    public static Scanner sc = new Scanner(System.in).useLocale(Locale.FRENCH);

    private static String[] testStrings = {
        "Yosemite II is a 1,366 sq. ft. 3 bedroom, 2 bathroom single-story home.",
        "The Burkburnett II 1 story plan, featuring approximately 2469 sq. ft., is a home with 3 bedrooms, 2 bathrooms, and a 2-car attached garage.",
        "Name: 23 Oak Ridge Type: Detached Two+ Story Ownership: Fee simple Beds: 4 Beds Baths: 3 Baths Interior Size: 2812 SqFt Lot Size: - Ceiling Heights: -",
        """
        <span style="padding-top: 5px;display:inline-block;">3 Beds</span>
        <span style="padding-top: 5px;display:inline-block;">2 Baths</span>
        <span style="padding-top: 5px;display:inline-block;">2 Baths</span>
        <span style="padding-top: 5px;display:inline-block;">1959 SqFt</span>
        This elegant 1-story is soaring with 11-foot ceilings and a spacious floor plan!""",
    };
    public static void main(String[] args) {
        String text = sc.nextLine();
        System.out.println(House.createFromText(text));

        System.out.println("Testing area");
        testArea();
        System.out.println("Testing badroomd");
        testBadrooms();
        System.out.println("Testing bathrooms");
        testBathrooms();
    }

    public static void testArea() {
        String[] areas = {
            "1.366",
            "2469.0",
            "2812.0",
            "1959.0",
        };
        for (int i = 0; i < testStrings.length; i++) {
            String resArea = Double.toString(House.parseArea(testStrings[i]));
            if (!resArea.equals(areas[i])) {
                System.out.printf("Failed %d test: %s\n", i, resArea);
            }
        }
    }

    public static void testBadrooms() {
        String[] areas = {"3", "3", "4", "3"};

        for (int i = 0; i < testStrings.length; i++) {
            String resArea = Integer.toString(House.parseNumberOfBedrooms(testStrings[i]));
            if (!resArea.equals(areas[i])) {
                System.out.printf("Failed %d test: %s\n", i, resArea);
            }
        }
    }

    public static void testBathrooms() {
        String[] areas = {"2", "2", "3", "2"};
        for (int i = 0; i < testStrings.length; i++) {
            String resArea = Integer.toString(House.parseNumberOfBathrooms(testStrings[i]));
            if (!resArea.equals(areas[i])) {
                System.out.printf("Failed %d test: %s\n", i, resArea);
            }
        }
    }
}