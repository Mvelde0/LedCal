package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import methods.Methods;
import vvars.LedProps;

public class ViewMain {

    // References

    // Defining Frames & Panels
    JFrame mFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel parameterMainPanel = new JPanel();
    JPanel parameterLabelPanel = new JPanel();
    JPanel parameterTextLabel = new JPanel();
    JPanel calculateRadioPanel = new JPanel();
    JPanel calculateButtonPanel = new JPanel();
    JPanel calculateMainPanel = new JPanel();
    JPanel resultMainPanel = new JPanel();
    JPanel resultTextPanel = new JPanel();
    JPanel resultNumbersPanel = new JPanel();
    JPanel resultRingColorsPanel = new JPanel();

    // Defining Labels
    JLabel labelPSupply = new JLabel("Power Supply (P)");
    JLabel labelPowerDrop = new JLabel("Power Drop (V)");
    JLabel labelLedCurrent = new JLabel("LED Current (mA)");
    JLabel labelLedNumber = new JLabel("Number of LEDs");
    JLabel labelTextCalculated = new JLabel("Calculated Value");
    JLabel labelTextCalculatedResistor = new JLabel("Resistor");
    JLabel labelResultCalculated = new JLabel("Ω"); // Calculated results will be here
    JLabel labelResultResistor = new JLabel("Ω"); // Chosen Resistor will be here

    // Defining Textfields
    JTextField textPSupply = new JTextField("3");
    JTextField textPowerDrop = new JTextField("3");
    JTextField textLedCurrent = new JTextField("3");
    JTextField textLedNumber = new JTextField("3");

    // Defining Buttons
    JButton buttonCalcButton = new JButton("Calculate");

    ButtonGroup rbGroup = new ButtonGroup();
    JRadioButton radioSeriesButton = new JRadioButton("Series");
    JRadioButton radioParallelButton = new JRadioButton("Parallel");

    // Defining Actions
    ActionListener radioButtonListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == radioSeriesButton) {
                System.out.println("Selected Series");
                LedProps.setFormulaType(1);
                System.out.println("Formula Type = " + LedProps.getFormulaType());
            } else if (e.getSource() == radioParallelButton) {
                System.out.println("Selected Parallel");
                LedProps.setFormulaType(2);
                System.out.println("Formula Type = " + LedProps.getFormulaType());
            }
        }
    };

    ActionListener calculateButtonListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            collectInput();

            Methods.calculate(LedProps.getFormulaType());
            System.out.println("Resistor is: " + LedProps.getResistor());
            labelResultCalculated.setText("Ω " + Double.toString(Math.round(LedProps.getResistor())));
        }
    };

    // Defining Images
    ImageIcon image = new ImageIcon("logo.png");

    // Frame Setup
    public void initGUI() {

        // Main Panel

        mainPanel.setLayout(new GridLayout(4, 2));
        mainPanel.add(parameterMainPanel);
        mainPanel.add(calculateMainPanel);
        mainPanel.add(resultMainPanel);
        mainPanel.add(resultRingColorsPanel);

        // Parameters Panel
        parameterMainPanel.setBorder(new TitledBorder("Parameters"));
        parameterMainPanel.setLayout(new GridLayout(1, 2));
        parameterMainPanel.add(parameterLabelPanel);
        parameterMainPanel.add(parameterTextLabel);

        parameterLabelPanel.setLayout(new GridLayout(4, 1));
        parameterLabelPanel.add(labelPSupply);
        parameterLabelPanel.add(labelPowerDrop);
        parameterLabelPanel.add(labelLedCurrent);
        parameterLabelPanel.add(labelLedNumber);

        parameterTextLabel.setLayout(new GridLayout(4, 1));
        parameterTextLabel.add(textPSupply);
        parameterTextLabel.add(textPowerDrop);
        parameterTextLabel.add(textLedCurrent);
        parameterTextLabel.add(textLedNumber);

        // Series & Calculate Panel
        // calculateMainPanel.setBorder(new TitledBorder("Series or Parallel?"));
        calculateMainPanel.setLayout(new GridLayout(2, 1));
        calculateMainPanel.add(calculateRadioPanel);
        calculateMainPanel.add(calculateButtonPanel);

        // Radio Button
        calculateRadioPanel.setLayout(new GridLayout(1, 2));
        calculateRadioPanel.add(radioSeriesButton);
        calculateRadioPanel.add(radioParallelButton);
        // radioSeriesButton.setSelected(true);

        rbGroup.add(radioSeriesButton);
        rbGroup.add(radioParallelButton);

        radioParallelButton.addActionListener(radioButtonListener);
        radioSeriesButton.addActionListener(radioButtonListener);
        rbGroup.add(radioSeriesButton);
        rbGroup.add(radioParallelButton);

        // Calculate Button

        calculateButtonPanel.setLayout(new GridLayout(1, 1));
        calculateButtonPanel.add(buttonCalcButton);

        buttonCalcButton.addActionListener(calculateButtonListener);

        // Result Panel
        resultMainPanel.setLayout(new GridLayout(1, 2));
        resultMainPanel.add(resultNumbersPanel);
        resultMainPanel.add(resultTextPanel);

        resultNumbersPanel.setLayout(new GridLayout(2, 1));
        resultNumbersPanel.add(labelTextCalculated);
        resultNumbersPanel.add(labelTextCalculatedResistor);

        resultTextPanel.setLayout(new GridLayout(2, 1));
        resultTextPanel.add(labelResultCalculated);
        resultTextPanel.add(labelResultResistor);

        resultRingColorsPanel.setBorder(new TitledBorder("Ring Color"));

        // Frame
        mFrame.setTitle("LED Resistance Calculator");
        mFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mFrame.setSize(400, 500);
        mFrame.setResizable(false);
        mFrame.add(mainPanel);
        mFrame.setVisible(true);

    }

    public void collectInput() {
        System.out.println("Collecting Input");
        String resP = textPSupply.getText();
        String resV = textPowerDrop.getText();
        String resMA = textLedCurrent.getText();
        String resN = textLedNumber.getText();

        LedProps.setPowerSupply(Double.parseDouble(resP));
        LedProps.setLedPowerDrop(Double.parseDouble(resV));
        LedProps.setLedCurrent(Double.parseDouble(resMA));
        LedProps.setLedNumbers(Integer.parseInt(resN));

        System.out.println("\n Power Supply: " + LedProps.getPowerSupply() + "\n Power Drop: "
                + LedProps.getLedPowerDrop() + "\n LED Current: " + LedProps.getLedCurrent() + "\n LED Numbers: "
                + LedProps.getLedNumbers() + "\n Formula Type: " + LedProps.getFormulaType());
    }

}
