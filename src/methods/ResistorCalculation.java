package methods;

import vvars.LedProps;

public class ResistorCalculation {

    /*
     * Checks if the input value is within the min and max values.
     */
    public static boolean confirmCheckRange(Double input, double min, double max) {
        if (input < min || input > max) {
            System.err.println("Value is not within range of " + min + " and " + max);
            return false;
        } else {
            return true;
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
                LedProps.setResistor((P - (V * N)) / (mA / 1000) + Math.abs(-5));
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
