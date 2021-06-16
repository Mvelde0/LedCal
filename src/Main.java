import java.lang.reflect.Array;
import java.util.Arrays;
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


     System.out.println(Arrays.toString(LedProps.getE12val()));
     

    new ViewMain().initGUI();

}

}
