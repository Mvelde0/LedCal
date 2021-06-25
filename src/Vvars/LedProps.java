package vvars;

public class LedProps {

    // LED Properties
    private static double P_PowerSupply;
    private static double R_Resistor;
    private static double V_LedPowerDrop;
    private static double mA_LedCurrent;
    private static int N_LedNumbers;

    // Function Properties
    private static int FormulaType;
    private static double ChosenResistor;
    private static String labelTip;
    private static boolean valuesValidated;
    private static boolean formulaValidated;
    private static boolean validInput;
    private static boolean validResult;

    // Result Properties

    private static String firstColorLabel;
    private static String secondColorLabel;
    private static String thirdColorLabel;

    // E12 Resistance values

    private static double[] e12val = { 0, 0.5, 1.0, 1.2, 1.5, 1.8, 2.2, 2.7, 3.3, 3.9, 4.7, 6.8, 8.2, 10, 10.2, 10.5,
            10.7, 11, 11.3, 11.5, 11.8, 12, 12.1, 12.4, 12.7, 13, 13.3, 13.7, 14, 14.3, 14.7, 15, 15, 15.4, 15.8, 16.2,
            16.5, 16.9, 17.4, 17.8, 18, 18.2, 18.7, 19.1, 19.6, 20, 20.5, 21, 21.5, 22, 22.1, 22.6, 23.2, 23.7, 24.3,
            24.9, 25.5, 26.1, 26.7, 27, 27.4, 28, 28.7, 29.4, 30.1, 30.9, 31.6, 32.4, 33, 33.2, 34, 34.8, 35.7, 36.5,
            37.4, 38.3, 39, 39.2, 40.2, 41.2, 42.2, 43.2, 44.2, 45.3, 46.4, 47, 47.5, 48.7, 49.9, 51.1, 52.3, 53.6,
            54.9, 56, 56.2, 57.6, 59, 60.4, 61.9, 63.4, 64.9, 66.5, 68, 68.1, 69.8, 71.5, 73.2, 75, 76.8, 78.7, 80.6,
            82, 82.5, 84.5, 86.6, 88.7, 90.9, 93.1, 95.3, 97.6, 100, 120, 150, 181, 220, 270, 330, 390, 470, 560, 680,
            820, 1000, 1200, 1800, 2200, 2700, 3300, 3900, 4700, 5600, 6800, 8200, 10000, 12000, 15000, 18000, 22000,
            27000, 33000, 39000, 47000, 56000, 68000, 82000, 1000000, 1500000, 1800000, 2200000, 2700000, 3300000,
            3900000, 4700000 };

    // Getters

    public static String getFirstColorLabel() {
        return firstColorLabel;
    }

    public static boolean isValidResult() {
        return validResult;
    }

    public static boolean isValidInput() {
        return validInput;
    }

    public static boolean isValuesValidated() {
        return valuesValidated;
    }

    public static boolean isFormulaValidated() {
        return formulaValidated;
    }

    public static String getLabelTip() {
        return labelTip;
    }

    public static String getSecondColorLabel() {
        return secondColorLabel;
    }

    public static String getThirdColorLabel() {
        return thirdColorLabel;
    }

    public static double[] getE12val() {
        return e12val;
    }

    public static double getChosenResistor() {
        return ChosenResistor;
    }

    public static double getPowerSupply() {
        return P_PowerSupply;
    }

    public static double getResistor() {
        return R_Resistor;
    }

    public static double getLedPowerDrop() {
        return V_LedPowerDrop;
    }

    public static double getLedCurrent() {
        return mA_LedCurrent;
    }

    public static int getLedNumbers() {
        return N_LedNumbers;
    }

    public static int getFormulaType() {
        return FormulaType;
    }

    // Setters

    public static void setValidResult(boolean validResult) {
        LedProps.validResult = validResult;
    }

    public static void setValidInput(boolean validInput) {
        LedProps.validInput = validInput;
    }

    public static void setValuesValidated(boolean valuesValidated) {
        LedProps.valuesValidated = valuesValidated;
    }

    public static void setFormulaValidated(boolean formulaValidated) {
        LedProps.formulaValidated = formulaValidated;
    }

    public static void setLabelTip(String labelTip) {
        LedProps.labelTip = labelTip;
    }

    public static void setFirstColorLabel(String firstColorLabel) {
        LedProps.firstColorLabel = firstColorLabel;
    }

    public static void setSecondColorLabel(String secondColorLabel) {
        LedProps.secondColorLabel = secondColorLabel;
    }

    public static void setThirdColorLabel(String thirdColorLabel) {
        LedProps.thirdColorLabel = thirdColorLabel;
    }

    public static void setE12val(double[] e12val) {
        e12val = e12val;
    }

    public static void setChosenResistor(double chosenResistor) {
        ChosenResistor = chosenResistor;
    }

    public static void setPowerSupply(double newPowerSupply) {
        P_PowerSupply = newPowerSupply;
    }

    public static void setResistor(double newResistor) {
        R_Resistor = newResistor;
    }

    public static void setLedPowerDrop(double newLedPowerDrop) {
        V_LedPowerDrop = newLedPowerDrop;
    }

    public static void setLedCurrent(double newLedCurrent) {
        mA_LedCurrent = newLedCurrent;
    }

    public static void setLedNumbers(int newLedNumbers) {
        N_LedNumbers = newLedNumbers;
    }

    public static void setFormulaType(int newFormulaType) {
        FormulaType = newFormulaType;
    }

}
