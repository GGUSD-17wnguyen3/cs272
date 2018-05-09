package edu.orangecoastcollege.cs272.ic13.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class SignInScene {

    private static Controller controller = Controller.getInstance();

	@FXML
	private Label signInErrorLabel;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private TextField emailTF;
	@FXML
	private TextField passwordTF;

	// Event Listener on Label.onMouseClicked
	@FXML
	public void loadSignUp(MouseEvent event) {
		ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public boolean signIn() {
	    // Let's read information from the user
	    String email = emailTF.getText();
	    String password =  passwordTF.getText();

	    // Lets check to see if the error labels should be made visible:
	    emailErrorLabel.setVisible(email.isEmpty());
	    passwordErrorLabel.setVisible(password.isEmpty());

	    // If either one is visible, return false;
	    if(emailErrorLabel.isVisible() || passwordErrorLabel.isVisible()) return false;

	    // Lets try to log the user in (store the result)
	    String result = controller.signInUser(email, password);
        if(result.equalsIgnoreCase("SUCCESS"))
        {
            signInErrorLabel.setVisible(false);
            ViewNavigator.loadScene("Video Game List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
            return true;
        }
        signInErrorLabel.setText(result);
        signInErrorLabel.setVisible(true);
        return false;
	}
}
