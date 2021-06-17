package vvars;

import java.sql.Array;

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

    // E12 Resistance values

    private static double[] e12val = { 0.1, 0.12, 0.15, 0.18, 0.22, 0.27, 0.33, 0.39, 0.47, 0.56, 0.68, 0.82, 1, 1.2, 1.5, 1.8, 2.2,
            2.7, 3.3, 3.9, 4.7, 5.6, 6.8, 8.2, 10, 12, 15, 18, 22, 27, 33, 39, 47, 56, 68, 82, 100, 120, 150, 180, 220,
            270, 330, 390, 470, 560, 680, 820, 1000, 1200, 1500, 1800, 2200, 2700, 3300, 3900, 4700, 5600, 6800, 8200,
            10000, 12000, 15000, 18000, 22000, 27000, 33000, 39000, 47000, 56000, 68000, 82000, 100000, 120000, 150000,
            180000, 220000, 270000, 330000, 390000, 470000, 560000, 680000, 820000, 1000000, 1200000, 1500000, 1800000,
            2200000, 2700000, 3300000, 3900000, 4700000 };

    // public static void initE12Array(Array array){
    // for (int i = 0; i < array.; i++) {
    // array[i] = i + 10*(1+(i/12.));
    // System.out.println(i);
    // }
    // }

    // Getters

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
