package methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import vvars.LedProps;

public class ResistorColorCode {

    /*
     * Will run through the textfields for rangeChecks before continuing to pass the
     * textfield input to the Setters
     */

    public static void convertDoubleValues(Double codeColor) {

        System.out.println("Converter GOT: " + codeColor);

        String doubleToString;
        String newString;

        if (codeColor % 1 != 0) {
            System.out.println("Contains decimals");
            doubleToString = String.valueOf(codeColor);
            newString = doubleToString.replaceAll("\\.", "");
            stringToColor(newString);
        } else {
            System.out.println("Contains whole value");
            doubleToString = String.valueOf(codeColor);
            if (doubleToString.contains("1.0") || doubleToString.contains("10")) {
                newString = doubleToString.replaceAll("\\.", "");
                stringToColor(newString);
            } else {
                newString = doubleToString.replaceAll("\\.0", "");
                stringToColor(newString);
            }
        }
    }

    /*
     * Splits the string and inserts it into a compareList. The list will be
     * iterated through while comparing each element with the Color Code list "bcc".
     * Based on conditions and the position the iterator is at in the compareList,
     * it will assign the appropriate color code.
     * 
     * - CompareLists smaller then 2 have their own assignment (because decimals)
     */
    private static void stringToColor(String stringColor) {

        System.out.println("Converting: " + stringColor);

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
        bcc.put(10, "SILVER");
        bcc.put(11, "GOLD");

        /*
         * Splits and converts the provided String into an Integer and adds them to the
         * compareList.
         */

        for (String retV : stringColor.split("")) {
            int num = Integer.parseInt(retV);
            compareList.add(num);
        }

        System.out.println("Arraylist <Integer>: " + compareList + " Size: " + compareList.size());
        System.out.println("Comparing to: " + bcc);

        Iterator<Integer> itrCompList = compareList.iterator();
        int deci = 0;
        int secondNr = 0;
        int zeros = 0;
        int count = 0;

        /*
         * Iterates through the compareList, taking note of which element is on which
         * indeces. (ex. 0's on the first index will tell the function it is a decimal
         * etc.)
         */

        while (itrCompList.hasNext()) {

            Integer key = itrCompList.next();
            String value = bcc.get(key);

            if (compareList.size() > 2) {
                if (compareList.get(0) == 0 && count == 0) {
                    System.out.println("First character is a 0");
                    resultColorList.add(bcc.get(0));
                    deci++;
                }
                if (compareList.get(1) == 0 && count == 1) {
                    System.out.println("Second character is a 0. Adding " + bcc.get(0));
                    resultColorList.add(bcc.get(0));
                    secondNr++;
                }
                if (compareList.get(2) != 0 && count >= 2) {

                } else if (value == "BLACK" && count >= 2) {
                    System.out.println("FOUND 0");
                    zeros++;
                    System.out.println("Zeroes: " + zeros);
                } else if (value != "BLACK") {
                    System.out.println("deci = " + deci + " - " + key);
                    resultColorList.add(value);
                }
                count++;

            } else if (compareList.size() <= 2) {
                if (compareList.get(0) == 0 && value == "BLACK" && count == 0) {
                    System.out.println("Number is smaller then 1");
                    resultColorList.add(value);
                } else {
                    resultColorList.add(value);
                }
                count++;
            }
            System.out.println(count + " : " + key + " = " + value);
        }

        System.out.println("Counted " + deci + " decimals");
        System.out.println("Counted " + zeros + " zeroes");

        int zeroCount = zeros - (deci + secondNr);

        /*
         * Adds the Third band color based on the size of the arraylist and elements
         * from the iterator. (Ex. adds GOLD as a multiplier if it contains a decimal
         * number and a whole number.)
         */

        if (zeroCount > 0 && compareList.size() > 2) {
            System.out.println("Adding " + zeroCount + " : " + (bcc.get(zeroCount)));
            resultColorList.add(bcc.get(zeroCount));
        } else if (zeroCount == 0 && compareList.size() > 2) {
            resultColorList.add(bcc.get(0));
        } else if (zeroCount == 0 && compareList.size() <= 2) {
            resultColorList.add(bcc.get(11));
        } else if (zeroCount == 0 && compareList.size() <= 0) {
            System.out.println("Result is 0 or smaller");
        }
        System.out.println("Color Band Code is:" + resultColorList);

        try {
            if (compareList.size() >= 1) {
                LedProps.setFirstColorLabel(resultColorList.get(0));
                LedProps.setSecondColorLabel(resultColorList.get(1));
                LedProps.setThirdColorLabel(resultColorList.get(2));
            }
        } catch (Exception e) {
            System.out.println("Can't assign colors because the resutlt is 0 or smaller");
        }

    }
}