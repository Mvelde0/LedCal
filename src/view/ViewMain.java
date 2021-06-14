package view;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class ViewMain {

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
    JLabel labelResultCalculated = new JLabel("Ω" + ""); // Calculated results will be here
    JLabel labelResultResistor = new JLabel("Ω" + ""); // Chosen Resistor will be here

    // Defining Textfields
    JTextField textPSupply = new JTextField();
    JTextField textPowerDrop = new JTextField();
    JTextField textLedCurrent = new JTextField();
    JTextField textLedNumber = new JTextField();

    // Defining Buttons
    JButton buttonCalcButton = new JButton("Calculate");
    JRadioButton radioSeriesButton = new JRadioButton("Series");
    JRadioButton radioParallelButton = new JRadioButton("Parallel");

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

        calculateRadioPanel.setLayout(new GridLayout(1, 2));
        calculateRadioPanel.add(radioSeriesButton);
        calculateRadioPanel.add(radioParallelButton);
        radioSeriesButton.setEnabled(true);
        radioParallelButton.setEnabled(false);

        calculateButtonPanel.setLayout(new GridLayout(1, 1));
        calculateButtonPanel.add(buttonCalcButton);

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
        mFrame.setDefaultCloseOperation(mFrame.EXIT_ON_CLOSE);
        mFrame.setSize(400, 500);
        mFrame.setResizable(false);
        mFrame.add(mainPanel);
        mFrame.setVisible(true);
    }
}