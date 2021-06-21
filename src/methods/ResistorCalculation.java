
package methods;

import java.lang.reflect.Array;

import vvars.LedProps;

public class ResistorCalculation {

    // Checks if the properties are within the allowed values
    public static void confirmCheck() {
        if (LedProps.getPowerSupply() < 3 || LedProps.getPowerSupply() > 24) {
            System.err.println("Power Supply must be within 3 and 24");
        } else if (LedProps.getLedPowerDrop() < 1.6 || LedProps.getLedPowerDrop() > 4) {
            System.err.println("LED Power Drop must be within 1.6 and 4");
        } else if (LedProps.getLedCurrent() < 2 || LedProps.getLedCurrent() > 70) {
            System.err.println("LED current must be within 2 and 70");
        } else if (LedProps.getLedNumbers() < 1 || LedProps.getLedNumbers() > 99) {
            System.err.println("Number of LEDS must be within 1 and 99");
        } else if (LedProps.getFormulaType() > 1) {
            System.err.println("No LED Series selected");

        }
    }

    /*
     * If no exception has been thrown during the 'confirmCheck' function prior,
     * will calculate the properties based on the Formula Type given.
     * (getFormulaType)
     */
    public static void calculate(int FormulaType) {

        double R = LedProps.getResistor();
        double P = LedProps.getPowerSupply();
        double V = LedProps.getLedPowerDrop();
        double mA = LedProps.getLedCurrent();
        int N = LedProps.getLedNumbers();

        System.out.println("\n CALCULATING PARAMATERS:" + "\n PowerSupply: " + P + "\n Power Drop: " + V
                + "\n LED Current: " + mA + "\n LED Numbers: " + N);

        switch (FormulaType) {
            case 1:
                System.out.println("Series Formula selected");
                LedProps.setResistor((P - (V * N)) / (mA / 1000));
                break;
            case 2:
                System.out.println("Parallel Formula selected");
                LedProps.setResistor((P - V) / (mA * N / 1000));
                break;
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
            System.out.println(i + " : " + arr[i]);

            if (target <= arr[i]) {
                result = arr[i];
                System.out.println("Chosen Result NOW: " + result);
                break;
            } else if (arr[i] <= target) {
                result = arr[i + 1];
                System.out.println("Chosen Result NOW: " + result);
            } else {
            }

        }
        System.out.println("End result: " + result);
        LedProps.setChosenResistor(result);
    }

}
