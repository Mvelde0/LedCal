import java.util.Scanner;

import methods.*;
import vvars.LedProps;
import view.*;

public class Main {

    public static void main(String[] args) {

        Scanner inputPower = new Scanner(System.in);
        double PP = new LedProps().getPowerSupply();
        double PP2 = new LedProps().getLedPowerDrop();
        double PP3 = new LedProps().getLedCurrent();
        int PP4 = new LedProps().getLedNumbers();

        new ViewMain().initGUI();
        // // LedProps.initE12Array(/Vvars.LedProps.getE12Values());

        // System.out.println("Enter Power Supply:");
        // PP = inputPower.nextdouble();

        // LedProps.setPowerSupply(PP);
        // System.out.println("Power Supply set to: " + PP);

        // System.out.println("Enter LED Power Drop:");
        // PP2 = inputPower.nextdouble();

        // LedProps.setLedPowerDrop(PP2);
        // System.out.println("LED Power Drop set to: " + PP2);

        // System.out.println("Enter LED Current");
        // PP3 = inputPower.nextdouble();

        // LedProps.setLedCurrent(PP3);
        // System.out.println("LED Current set to: " + PP3);

        // System.out.println("Enter Numbers of LEDs");
        // PP4 = inputPower.nextInt();

        // LedProps.setLedNumbers(PP4);
        // System.out.println("LED Number set to: " + PP4);

        // Methods.confirmCheck();
        // Methods.calculate(0);
        // System.out.println("Resistor MAIN NOW: " +
        // Math.round(vvars.LedProps.getResistor()));
    }

}
