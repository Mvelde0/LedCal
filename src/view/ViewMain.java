package view;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import java.text.DecimalFormat;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import methods.*;
import vvars.*;
import components.TextPrompt;
import handlers.MessageHandler;

public class ViewMain {

    // Fonts
    Font fontTitleBorder = new Font("", Font.BOLD, 24);
    Font fontResult = new Font("", Font.BOLD, 16);
    Font fontBandColor = new Font("", Font.BOLD, 16);

    // Borders
    EmptyBorder borderResultBorder = new EmptyBorder(0, 60, 0, 0);
    EmptyBorder borderTip = new EmptyBorder(0, 25, 0, 25);
    EmptyBorder borderColorBandLabel = new EmptyBorder(16, 35, 25, 0);
    EmptyBorder borderRadioButtonBorder = new EmptyBorder(45, 45, 45, 0);

    // Text Areas
    JTextArea textArHelp = new JTextArea("Enter your values, select the desired formula and press Calculate");

    // Defining Frames & Panels
    JFrame mFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel helpPanel = new JPanel();
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
    JLabel labelTip = new JLabel();

    JLabel labelPSupply = new JLabel("Power Supply (P)");
    JLabel labelPowerDrop = new JLabel("Power Drop (V)");
    JLabel labelLedCurrent = new JLabel("LED Current (mA)");
    JLabel labelLedNumber = new JLabel("Number of LEDs");

    JLabel labelTextCalculated = new JLabel("Calculated Value:");
    JLabel labelTextCalculatedResistor = new JLabel("Resistor Needed:");
    JLabel labelResultCalculated = new JLabel("Ω"); // Calculated results will be here
    JLabel labelResultResistor = new JLabel("Ω"); // Chosen Resistor will be here

    JLabel labelBandFirstColor = new JLabel("");
    JLabel labelBandSecondColor = new JLabel("");
    JLabel labelBandThirdColor = new JLabel("");

    // Defining Textfields
    JTextField textPSupply = new JTextField();
    JTextField textPowerDrop = new JTextField();
    JTextField textLedCurrent = new JTextField();
    JTextField textLedNumber = new JTextField();

    // Defining Buttons
    JButton buttonCalcButton = new JButton("Calculate");
    JButton buttonHelpButton = new JButton("Help");

    ButtonGroup rbGroup = new ButtonGroup();

    JRadioButton radioSeriesButton = new JRadioButton("Series");
    JRadioButton radioParallelButton = new JRadioButton("Parallel");

    // Defining Images
    ImageIcon image = new ImageIcon("logo.png");

    // Text Prompt
    TextPrompt promptPSupply = new TextPrompt("Value must be between 3 and 24", textPSupply);
    TextPrompt promptPowerDrop = new TextPrompt("Value must be between 1.6 and 4", textPowerDrop);
    TextPrompt promptLedCurrent = new TextPrompt("Value must be between 2 and 70", textLedCurrent);
    TextPrompt promptLedNumbers = new TextPrompt("Value must be between 1 and 99", textLedNumber);

    // Data Formats
    DecimalFormat decF = new DecimalFormat("#0.00");
    PrintStream outStream = new PrintStream(new TextAreaOutputStream(textArHelp));

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

            if (LedProps.getFormulaType() != 0) {

                ResistorCalculation.calculate(LedProps.getFormulaType());

                if (LedProps.getResistor() > 0) {
                    ResistorCalculation.findClosest(LedProps.getE12val(), LedProps.getResistor());
                    textArHelp.setText("");
                    System.out.println("Chosen Resistor: " + LedProps.getChosenResistor());
                    labelResultResistor.setText("Ω " + Double.toString(LedProps.getChosenResistor()));
                    ResistorColorCode.convertDoubleValues(LedProps.getChosenResistor());

                    labelBandFirstColor.setText(LedProps.getFirstColorLabel());
                    labelBandSecondColor.setText(LedProps.getSecondColorLabel());
                    labelBandThirdColor.setText(LedProps.getThirdColorLabel());

                    System.out.println("Resistor is: " + LedProps.getResistor());
                    labelResultCalculated.setText("Ω " + decF.format(LedProps.getResistor()));
                } else {
                    labelResultCalculated.setText("Ω " + 0.0);
                    labelResultResistor.setText("Ω " + 0.0);
                }
            } else {
                // MessageHandler.displayTextMessage("No formula selected", textArHelp);
                System.err.println("No formula selected\n");
            }

        }
    };

    // Frame Setup
    public void initGUI() {

        // Main Panel

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        mainPanel.add(helpPanel);
        mainPanel.add(parameterMainPanel);
        mainPanel.add(calculateMainPanel);
        mainPanel.add(resultMainPanel);
        mainPanel.add(resultRingColorsPanel);

        // Tip/Help Panel

        helpPanel.setBorder(new TitledBorder("Help"));
        helpPanel.setLayout(new GridLayout(1, 1));
        textArHelp.setBorder(borderTip);
        textArHelp.setEditable(false);
        textArHelp.setLineWrap(true);
        textArHelp.setWrapStyleWord(true);
        textArHelp.setOpaque(false);
        textArHelp.setBackground(new Color(0, 0, 0, 255));
        helpPanel.add(textArHelp);

        // Parameters Panel

        promptPSupply.changeAlpha(0.5f);
        promptPSupply.changeStyle(Font.ITALIC);
        promptPowerDrop.changeAlpha(0.5f);
        promptPowerDrop.changeStyle(Font.ITALIC);
        promptLedCurrent.changeAlpha(0.5f);
        promptLedCurrent.changeStyle(Font.ITALIC);
        promptLedNumbers.changeAlpha(0.5f);
        promptLedNumbers.changeStyle(Font.ITALIC);

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

        radioParallelButton.addActionListener(radioButtonListener);
        radioSeriesButton.addActionListener(radioButtonListener);
        rbGroup.add(radioSeriesButton);
        rbGroup.add(radioParallelButton);

        // Calculate Button

        calculateButtonPanel.setLayout(new GridLayout(1, 1));
        calculateButtonPanel.add(buttonCalcButton);

        buttonCalcButton.addActionListener(calculateButtonListener);

        // Result Panel
        resultMainPanel.setBorder(new TitledBorder("Results"));
        resultMainPanel.setLayout(new GridLayout(1, 2));
        resultMainPanel.add(resultNumbersPanel);
        resultMainPanel.add(resultTextPanel);

        resultNumbersPanel.setLayout(new GridLayout(2, 1));
        labelTextCalculated.setBorder(borderResultBorder);
        labelTextCalculatedResistor.setBorder(borderResultBorder);
        resultNumbersPanel.add(labelTextCalculated);
        resultNumbersPanel.add(labelTextCalculatedResistor);

        resultTextPanel.setLayout(new GridLayout(2, 1));
        resultTextPanel.add(labelResultCalculated);
        resultTextPanel.add(labelResultResistor);

        // Result Band Color
        resultRingColorsPanel.setBorder(new TitledBorder("Ring Color"));

        resultRingColorsPanel.setLayout(new GridLayout(1, 2));

        labelBandFirstColor.setBorder(borderColorBandLabel);
        labelBandFirstColor.setFont(fontBandColor);

        labelBandSecondColor.setBorder(borderColorBandLabel);
        labelBandSecondColor.setFont(fontBandColor);

        labelBandThirdColor.setBorder(borderColorBandLabel);
        labelBandThirdColor.setFont(fontBandColor);

        resultRingColorsPanel.add(labelBandFirstColor);
        resultRingColorsPanel.add(labelBandSecondColor);
        resultRingColorsPanel.add(labelBandThirdColor);

        // Frame
        mFrame.setTitle("LED Resistance Calculator");
        mFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mFrame.setSize(454, 500);
        mFrame.setResizable(false);
        mFrame.add(mainPanel);
        mFrame.setVisible(true);

    }

    private static boolean rangeCheck(Double inputNum, double min, double max) {
        return inputNum > min && max < inputNum;
    }

    /*
     * Collects the given input from the textfields
     */
    private void collectInput() {

        // System.setOut(outStream);
        System.setErr(outStream);
        textArHelp.setText("");

        String resP = textPSupply.getText();
        String resV = textPowerDrop.getText();
        String resMA = textLedCurrent.getText();
        String resN = textLedNumber.getText();

        if (resP.equals("") || resV.equals("") || resMA.equals("") || resN.equals("")) {
            // textArHelp.setText("Field cannot be empty");
            System.err.println("Field cannot be empty");
        } else {
            Double resPDouble = Double.parseDouble(resP);
            Double resVDouble = Double.parseDouble(resV);
            Double resMaDouble = Double.parseDouble(resMA);
            Double resNDouble = Double.parseDouble(resN);

            boolean check = false;

            if (ResistorCalculation.confirmCheckRange(resPDouble, 3, 24)) {
                if (ResistorCalculation.confirmCheckRange(resVDouble, 1.6, 4)) {
                    if (ResistorCalculation.confirmCheckRange(resMaDouble, 2, 70)) {
                        if (ResistorCalculation.confirmCheckRange(resNDouble, 1, 99)) {
                            check = true;
                        }
                    }
                }
            }

            if (check == true) {
                // textArHelp.setText("");
                System.out.println("Collecting Input");

                // System.out.println(
                // "\n Power Supply: " + LedProps.getPowerSupply() + "\n Power Drop: " +
                // LedProps.getLedPowerDrop()
                // + "\n LED Current: " + LedProps.getLedCurrent() + "\n LED Numbers: "
                // + LedProps.getLedNumbers() + "\n Formula Type: " +
                // LedProps.getFormulaType());

                LedProps.setPowerSupply(Double.parseDouble(resP));
                LedProps.setLedPowerDrop(Double.parseDouble(resV));
                LedProps.setLedCurrent(Double.parseDouble(resMA));
                LedProps.setLedNumbers(Integer.parseInt(resN));
            } else {

                // MessageHandler.displayTextMessage("One or more values are invalid",
                // textArHelp);
                System.err.println("One or more values are invalid");
            }
        }
    }

    public class TextAreaOutputStream extends OutputStream {
        private javax.swing.JTextArea jTextArea1;

        /**
         * Creates a new instance of TextAreaOutputStream which writes to the specified
         * instance of javax.swing.JTextArea control.
         *
         * @param textArea A reference to the javax.swing.JTextArea control to which the
         *                 output must be redirected to.
         */
        public TextAreaOutputStream(JTextArea textArea) {
            this.jTextArea1 = textArea;
        }

        public void write(int b) throws IOException {
            jTextArea1.append(String.valueOf((char) b));
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }

        public void write(char[] cbuf, int off, int len) throws IOException {
            jTextArea1.append(new String(cbuf, off, len));
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }
    }
}
