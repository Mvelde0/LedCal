import java.util.Scanner;
import Vvars.*;
import Methods.*;

public class Main {

    public static void main(String[] args) {

        Scanner inputPower = new Scanner(System.in);
        float PP = new LedProps().getPowerSupply();
        float PP2 = new LedProps().getLedPowerDrop();
        float PP3 = new LedProps().getLedCurrent();
        int PP4 = new LedProps().getLedNumbers();



        
        System.out.println("Enter Power Supply:");
        PP = inputPower.nextFloat();

        LedProps.setPowerSupply(PP);
        System.out.println("Power Supply set to: " + PP);

        System.out.println("Enter LED Power Drop:");
        PP2 = inputPower.nextFloat();

        LedProps.setLedPowerDrop(PP2);
        System.out.println("LED Power Drop set to: " + PP2);

        System.out.println("Enter LED Current");
        PP3 = inputPower.nextFloat();

        LedProps.setLedCurrent(PP3);
        System.out.println("LED Current set to: " + PP3);

        System.out.println("Enter Numbers of LEDs");
        PP4 = inputPower.nextInt();

        LedProps.setLedNumbers(PP4);
        System.out.println("LED Number set to: " + PP4);

        LedProps.confirmCheck();
        Methods.calculate(0);
        System.out.println("Resistor MAIN NOW: " + Math.round(Vvars.LedProps.getResistor()));
    }

}
