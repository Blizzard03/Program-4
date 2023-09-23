/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculator.Controller;

import calculator.Main_Class.Calculator;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Muhamad Ariq Rasyid
 */
public class CalculatorController implements Initializable {

    private static Calculator app;
    @FXML
    private CheckMenuItem LightThemeCheckItem;
    @FXML
    private CheckMenuItem DarkThemeCheckItem;
    @FXML
    private TextField Result;
    @FXML
    private Text savedNumbers;

    private static boolean isFeMode = false;
    private String firstNumber = "";
    private String currentNumber = "";
    private String CalculationType;

    private DecimalFormat sf = new DecimalFormat("0.######E0");

    @FXML
    private CheckMenuItem feModeCheckItem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void ChangeTheme(ActionEvent event) {
        String theme = ((CheckMenuItem) event.getSource()).getUserData().toString();
        if (theme.equals("light")) {
            LightThemeCheckItem.setSelected(true);
            DarkThemeCheckItem.setSelected(false);
            //app.switchTheme(Calculator.Theme.LIGHT);
        } else if (theme.equals("dark")) {
            DarkThemeCheckItem.setSelected(true);
            LightThemeCheckItem.setSelected(false);
            //app.switchTheme(Calculator.Theme.DARK);
        }
    }

    public void calculationSetup(String calculationType) {
        this.CalculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    public static boolean isFeMode() {
        return isFeMode;
    }

    public void updateTextField() {
        if (isFeMode()) {
            Result.setText(currentNumber.equals("") ? "0E0" : sf.format(Double.valueOf(currentNumber)));
        } else {
            Result.setText(currentNumber.equals("") ? "0" : String.valueOf(currentNumber));
        }
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }

    @FXML
    private void About_Click(ActionEvent event) {
    }

    @FXML
    private void multliply_button(ActionEvent event) {
        calculationSetup("*");
    }

    @FXML
    private void btn_7_click(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    private void button_8_click(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    private void button_9_click(ActionEvent event) {
        addNumber("9");
    }

    @FXML
    private void minus_click(ActionEvent event) {
        calculationSetup("-");
    }

    @FXML
    private void btn_6_click(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    private void btn_5_click(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    private void button4_click(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    private void plusbutton_click(ActionEvent event) {
        calculationSetup("+");

    }

    @FXML
    private void button3_click(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    private void button2_click(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    private void btn1clik(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    private void negateClick(ActionEvent event) {
        currentNumber = String.valueOf(Integer.parseInt(currentNumber) * -1);
        updateTextField();

    }

    @FXML
    private void button0_click(ActionEvent event) {
        if (!currentNumber.equals("")) {
            addNumber("0");
        }
    }

    @FXML
    private void decimal_point_click(ActionEvent event) {
        if (currentNumber.contains(".")) {
            return;
        }
        currentNumber += ".";
        updateTextField();

    }

    @FXML
    private void equals_button_click(ActionEvent event) {
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);
        if (CalculationType == "+") {
            int calculatedNumber = firstNumberInt + secondNumberInt;
            savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
            Result.setText(String.valueOf(calculatedNumber));
        } else if (CalculationType == "-") {

            int calculatedNumber = firstNumberInt - secondNumberInt;
            savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
            Result.setText(String.valueOf(calculatedNumber));
        } else if (CalculationType == "/") {
            double calculatedNumber = firstNumberInt / (double) secondNumberInt;
            savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
            Result.setText(String.valueOf(calculatedNumber));
        } else if (CalculationType == "*") {
            int calculatedNumber = firstNumberInt * secondNumberInt;
            savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
            Result.setText(String.valueOf(calculatedNumber));
        }

    }

    @FXML
    private void Percent_Click(ActionEvent event) {
        currentNumber = String.valueOf(Integer.parseInt(currentNumber) * 0.01);
        updateTextField();

    }

    @FXML
    private void Clear_btn_click(ActionEvent event) {
        currentNumber = "";
        Result.setText("");
        savedNumbers.setText("");
    }

    @FXML
    private void devide_button_click(ActionEvent event) {
        calculationSetup("/");
    }

    @FXML
    private void oneDividedByClick(ActionEvent event) {
        currentNumber = convertToIntIfPossible(1 / Double.valueOf(currentNumber));
        equals(false);
        updateTextField();
    }

    @FXML
    private void rootbutton_click(ActionEvent event) {
        currentNumber = convertToIntIfPossible(Math.sqrt(Double.valueOf(currentNumber)));
        updateTextField();
    }

    @FXML
    private void powerClick(ActionEvent event) {
        currentNumber = String.valueOf(Integer.parseInt(currentNumber) * Integer.parseInt(currentNumber));
        updateTextField();
    }

    private String convertToIntIfPossible(double value) {
        return (int) value == value ? String.valueOf((int) value) : String.valueOf(value);
    }

    @FXML
    private void Backspace_click(ActionEvent event) {
        if (Result.getText().length() > 0) {
            StringBuilder str = new StringBuilder(Result.getText());
            str.deleteCharAt(Result.getText().length() - 1);
            currentNumber = str.toString();
            updateTextField();
        }
    }

    @FXML
    private void changeFeMode() {
        isFeMode = !isFeMode;
    }
}
