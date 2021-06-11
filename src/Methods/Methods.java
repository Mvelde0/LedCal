
package Methods;

public class Methods {

    private static float R = Vvars.LedProps.getResistor();
    private static float P = Vvars.LedProps.getPowerSupply();
    private static float V = Vvars.LedProps.getLedPowerDrop();
    private static float mA = Vvars.LedProps.getLedCurrent();
    private static float N = Vvars.LedProps.getLedNumbers();

    private int LForm = Vvars.LedProps.getFormulaType();

    public static void calculate(int FormulaType) {

        float RSet;
        System.out.println("\n PARAMATERS ARE:" + "\n PowerSupply: " + P);

        if (FormulaType == 0) {
            System.out.println("Series Formula selected");
            RSet = ((P - (V * N)) / (mA / 1000));
            Vvars.LedProps.setResistor(RSet);

        } else if (FormulaType == 1) {
            System.out.println("Parallel Formula selected");
            RSet = ((P - V) / (mA * N / 1000));
            Vvars.LedProps.setResistor(RSet);
        } else {
            System.err.println("No LED Series selected");
        }
        System.out.println("Resistor is: " + Math.round(R));

    }
}
