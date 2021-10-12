import java.util.*;

public class PhoneMatcher {

    public static void main(String[] args) {
        String[] originalPhones = {"+14155552671", "801-902-3100"};
        String[] phonesToMatch = {"1 801-902-3100" , "(415) 555-2671"};
        System.out.println(Arrays.toString(PhoneMatcher.matchPhones(originalPhones, phonesToMatch)));
    }

    public static int[] matchPhones(String[] originalPhones, String[] phonesToMatch) {
        // declaration of maps that will store (phone, idx) pairs
        Map<String, Integer> strPos = new TreeMap<>();
        Map<String, Integer> matchPos = new TreeMap<>();

        // final array of indexes to return
        int[] idxs = new int[originalPhones.length];

        // fills the map in O(n) with (phone, idx)
        for (int i = 0; i < originalPhones.length; i++) {
            strPos.put(preprocessPhoneNumber(originalPhones[i]), i);
        }

        // fills the map in O(n) with (phone_to_match, idx)
        for (int i = 0; i < phonesToMatch.length; i++) {
            matchPos.put(preprocessPhoneNumber(phonesToMatch[i]), i);
        }

        System.out.println(strPos.toString());
        System.out.println(matchPos.toString());

        // fill the idx array in O(n)
        for (String phone : strPos.keySet()) {
            idxs[strPos.get(phone)] = matchPos.get(phone);
        }

        return idxs;
     }


     private static String preprocessPhoneNumber(String phone) {
         phone = phone.replaceAll("[^0-9]+", "");

         if (phone.length() != 9) {
             phone = phone.substring(phone.length() - 9);
         }

         return phone;
     }
}


