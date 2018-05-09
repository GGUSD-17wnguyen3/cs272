package edu.orangecoastcollege.cs272.ic13.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class SignUpScene {
    private static Controller controller = Controller.getInstance();

	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label signUpErrorLabel;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label nameErrorLabel;
	@FXML
	private TextField nameTF;
	@FXML
	private TextField emailTF;
	@FXML
	private TextField passwordTF;

	// Event Listener on Label.onMouseClicked
	@FXML
	public void loadSignIn() {
	    ViewNavigator.loadScene("Welcome to The Gamer's Inventory", ViewNavigator.SIGN_IN_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public boolean signUp() {
	 // Let's read information from the user
	    String name = nameTF.getText();
        String email = emailTF.getText();
        String password =  passwordTF.getText();

        // Lets check to see if the error labels should be made visible:
        emailErrorLabel.setVisible(email.isEmpty());
        passwordErrorLabel.setVisible(password.isEmpty());
        nameErrorLabel.setVisible(name.isEmpty());

        // If either one is visible, return false;
        if(emailErrorLabel.isVisible() || passwordErrorLabel.isVisible()||nameErrorLabel.isVisible()) return false;

        // Lets try to log the user in (store the result)
        String result = controller.signUpUser(name, email, password);
        if(result.equalsIgnoreCase("SUCCESS"))
        {
            signUpErrorLabel.setVisible(false);
            loadSignIn();
            return true;
        }
        signUpErrorLabel.setText(result);
        signUpErrorLabel.setVisible(true);
        return false;
	}
}
