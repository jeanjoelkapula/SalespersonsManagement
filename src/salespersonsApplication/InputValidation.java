package salespersonsApplication;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jean Joel
 */
public class InputValidation {

    //declarations
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField telephoneField;
    private JTextField salesAmountField;
    private String inputResultMessage = "";

    public InputValidation(JTextField firstNameField, JTextField lastNameField, JTextField telephoneField, JTextField salesAmountField) {
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.telephoneField = telephoneField;
        this.salesAmountField = salesAmountField;

    }

    public boolean isInputValid() {

        boolean valid = false;

        if (isFieldEmpty()) {
            inputResultMessage = "All fields must be completed.";
        } else {
            validateTelephoneFieldContent();
            validateSalesAmountFieldContent();
        }
        if (inputResultMessage.equals("")) {
            valid = true;
        }
        return valid;
    }

    private boolean isFieldEmpty() {

        boolean isNull = false;

        if (firstNameField.getText().equals("") || lastNameField.getText().equals("")
                || telephoneField.getText().equals("") || salesAmountField.getText().equals("")) {
            isNull = true;
        }

        return isNull;
    }

    private void validateTelephoneFieldContent() {

        //declaration
        boolean isCharDigit = true;

        if (telephoneField.getText().trim().length() != 10) {
            accumulateInputResultMessage("\n* The telephone number is a 10-digit number(0815645344).");
        }

        for (int index = 0; index < telephoneField.getText().trim().length() && isCharDigit == true; ++index) {

            if (!Character.isDigit(telephoneField.getText().trim().charAt(index))) {
                isCharDigit = false;
                accumulateInputResultMessage("\n* The telephone number field can only contain digits");
            }
        }

    }

    private void validateSalesAmountFieldContent() {
        boolean valid = true;

        for (int index = 0; index < salesAmountField.getText().length() && valid == true; index++) {
            char c = salesAmountField.getText().charAt(index);
            if (!Character.isDigit(c)) {
                if (c != '.') {
                    valid = false;
                    accumulateInputResultMessage("\n* The sales amount field can only contain digits \n or the decimal separator (.)");
                }
            }
        }
    }

    private void accumulateInputResultMessage(String message) {
        inputResultMessage += message;
    }

    public void displayErrorMessage() {
        JOptionPane.showMessageDialog(null, inputResultMessage, "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }
}
