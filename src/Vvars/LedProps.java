package vvars;

import java.sql.Array;

public class LedProps {

    // LED Properties
    private static double P_PowerSupply;
    private static double R_Resistor;
    private static double V_LedPowerDrop;
    private static double mA_LedCurrent;
    private static int N_LedNumbers;
    private static Array E12Values;

    // Function Properties
    private static int FormulaType;

    // public static Array initE12Array(array){

    // for (int i = 0; i < array.length; i++) {
    // array[i] = i + 10*(1+(i/12.));
    // System.out.println(i);
    // }
    // return array;
    // }

    // Getters

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

    public static Array getE12Values() {
        return E12Values;
    }

    // Setters
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

    public static void setE12Values(Array newE12Values) {
        E12Values = newE12Values;
    }
}