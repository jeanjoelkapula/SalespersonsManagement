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

        if (telephoneField.getText().trim().length() == 12) {
            if (!telephoneField.getText().trim().substring(0, 3).equals("+27")) {
                accumulateInputResultMessage("\n* The telephone number must start with the country code (+27) followed by 9 digits (+27815645344).");
            }
        } else {
            accumulateInputResultMessage("\n* The telephone number must start with the country code (+27) followed by 9 digits (+27815645344).");
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
