package methods;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import vvars.LedProps;

public class ResistorCalculation {

    /*
     * Validates if the input is an integer/double.
     */

    public static boolean validateInput(String name, JTextField textField, JTextArea textArea) {

        String tf = textField.getText();
        Pattern VALID_WORD = Pattern.compile("^[A-Za-z]*$");

        if (!VALID_WORD.matcher(tf).matches()) {
            textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            return true;
        } else {
            textArea.setText("");
            System.err.println("Invalid Input for " + name);
            textField.setBorder(new LineBorder(Color.RED, 2));
            return false;
        }
    }

    /*
     * Checks if the input value is within the min and max values.
     */
    public static boolean confirmCheckRange(String name, JTextField textfield, Double input, double min, double max) {
        if (input < min || input > max) {
            System.err.println(name + " is not within range of " + min + " and " + max);
            textfield.setBorder(new LineBorder(Color.RED, 2));
            return false;
        } else {
            textfield.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            return true;
        }
    }

    /*
     * If no exception has been thrown during the 'confirmCheck' function prior,
     * will calculate the properties based on the Formula Type given.
     * (getFormulaType)
     */
    public static void calculate(int FormulaType) {

        double P = LedProps.getPowerSupply();
        double V = LedProps.getLedPowerDrop();
        double mA = LedProps.getLedCurrent();
        int N = LedProps.getLedNumbers();

        LedProps.setValidResult(false);

        System.out.println("\n CALCULATING PARAMATERS:" + "\n PowerSupply: " + P + "\n Power Drop: " + V
                + "\n LED Current: " + mA + "\n LED Numbers: " + N);

        switch (FormulaType) {
            case 1:
                System.out.println("Series Formula selected");
                LedProps.setResistor((P - (V * N)) / (mA / 1000));

                if (LedProps.getResistor() <= 0) {
                    System.err.print("Result is not a positive number. Cannot assign colors");
                    break;
                } else {
                    LedProps.setValidResult(true);
                    break;
                }
            case 2:
                System.out.println("Parallel Formula selected");
                LedProps.setResistor((P - V) / (mA * N / 1000));
                if (LedProps.getResistor() <= 0) {
                    System.err.print("Result is not a positive number. Cannot assign colors");
                    break;
                } else {
                    LedProps.setValidResult(true);
                    break;
                }
            default:
                System.err.println("No LED Series selected");
                break;
        }
    }

    /*
     * Finds the value of array closest to the target value based on a number of
     * conditions: - If the 'target' is the exact value of an array, it will set
     * that as the new 'chosenResistor' value. - If the 'target' value is higher
     * then that of the value in the array, it will pick the value on the next index
     * and set that as the new 'chosenResistor' value.
     */
    public static void findClosest(double[] arr, double target) {

        System.out.println("TARGETTING: " + target);
        double result = 0;

        for (int i = 0; i < arr.length; i++) {
            // System.out.println(i + " : " + arr[i]);

            if (target <= arr[i]) {
                result = arr[i];
                // System.out.println("Chosen Result NOW: " + result);
                break;
            } else if (arr[i] <= target) {
                result = arr[i + 1];
                // System.out.println("Chosen Result NOW: " + result);
            } else {
            }

        }
        System.out.println("End result: " + result);
        LedProps.setChosenResistor(result);
    }

}
