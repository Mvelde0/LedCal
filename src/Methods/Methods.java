
package methods;

import vvars.LedProps;

public class Methods {

    // Checks if the properties are within the allowed values
    public static void confirmCheck() {
        if (LedProps.getPowerSupply() < 3 || LedProps.getPowerSupply() > 24) {
            System.err.println("Power Supply must be within 3 and 24");
        }
        if (LedProps.getLedPowerDrop() < 1.6 || LedProps.getLedPowerDrop() > 4) {
            System.err.println("LED Power Drop must be within 1.6 and 4");
        }
        if (LedProps.getLedCurrent() < 2 || LedProps.getLedCurrent() > 70) {
            System.err.println("LED current must be within 2 and 70");
        }
        if (LedProps.getLedNumbers() < 1 || LedProps.getLedNumbers() > 99) {
            System.err.println("Number of LEDS must be within 1 and 99");
        }
    }

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

    public static double comparefromE12Array(double arr[], double doubleResult) {
        double n = arr.length;

        // Corner cases
        if (doubleResult <= arr[0])
            return arr[0];
        if (doubleResult >= arr[(int) n - 1])
            return arr[(int) n - 1];

        int i = 0, j = (int) n, mid = 0;

        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == doubleResult)
                return arr[mid];

            // /*
            //  * If target is less than array element, then search in left
            //  */
            // if (doubleResult < arr[mid]) {

            //     // If target is greater than previous
            //     // to mid, return closest of two
            //     if (mid > 0 && doubleResult > arr[mid - 1])
            //         return getClosest(arr[mid - 1], arr[mid], doubleResult);

            //     /* Repeat for left half */
            //     j = mid;
            }

        }

    }
}