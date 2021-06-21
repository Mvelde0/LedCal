package methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResistorColorCode {

    public static void convertDoubleValues(Double codeColor) {

        System.out.println("Converter GOT: " + codeColor);

        String doubleToString;
        String newString;

        if (codeColor % 1 != 0) {
            System.out.println("Contains Decimals");
            doubleToString = String.valueOf(codeColor);
            newString = doubleToString.replaceAll("\\.", "");
            stringToColor(newString);

        } else {
            System.out.println("Whole Value");
            doubleToString = String.valueOf(codeColor);
            newString = doubleToString.replaceAll("\\.0", "");
            stringToColor(newString);
        }

    }

    private static void stringToColor(String stringColor) {

        System.out.println("Converting: " + stringColor);

        String removedDecimal;

        ArrayList<Integer> compareList = new ArrayList<>();
        ArrayList<String> resultColorList = new ArrayList<>();

        Map<Integer, String> bcc = new HashMap<>();
        bcc.put(0, "BLACK");
        bcc.put(1, "BROWN");
        bcc.put(2, "RED");
        bcc.put(3, "ORANGE");
        bcc.put(4, "YELLOW");
        bcc.put(5, "GREEN");
        bcc.put(6, "BLUE");
        bcc.put(7, "PURPLE");
        bcc.put(8, "GREY");
        bcc.put(9, "WHITE");

        for (String retV : stringColor.split("")) {
            int num = Integer.parseInt(retV);
            compareList.add(num);
        }

        System.out.println("Arraylist <Integer>: " + compareList);
        System.out.println("Comparing to: " + bcc);

        Iterator<Integer> itrCompList = compareList.iterator();

        while (itrCompList.hasNext()) {

            if (compareList.get(0) == 0) {
                System.out.println("First character is a 0");
            } else {
                System.out.println("First character NOT a 0. Therefore no decimal");
            }

            Integer key = itrCompList.next();
            String value = bcc.get(key);
            System.out.println(key + " = " + value);
            resultColorList.add(value);

        }
        System.out.println("Color Band Code is:" + resultColorList);
    }

}