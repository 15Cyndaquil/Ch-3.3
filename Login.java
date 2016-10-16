import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.CheckBox;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		for(int col=0; col<5; col++){
			ColumnConstraints column = new ColumnConstraints(150);
			grid.getColumnConstraints().add(column);
		}
		for(int ro=0; ro<6; ro++){
			RowConstraints row = new RowConstraints(50);
			grid.getRowConstraints().add(row);
		}

		Label enter = new Label("Enter Username and Password.");
		Label incorrect = new Label("The Username or Password you inputed is incorrrect.");
		Label usernamel = new Label("Username");
		Label passwordl = new Label("Password");

		TextField inusername = new TextField();
		inusername.setPromptText("Input Username");
		PasswordField inpassword = new PasswordField();
		inpassword.setPromptText("Input Password");

		TextField inpasswordshow = new TextField();
		inpasswordshow.setPromptText("Input Password");

		Button loginb = new Button("Login");
		loginb.setDefaultButton(true);
		Button cancelb = new Button("Cancel");

		CheckBox show = new CheckBox("Show Password?");

		grid.add(enter, 0, 0);
		GridPane.setColumnSpan(enter, 5);
		GridPane.setRowSpan(enter, 2);
		GridPane.setHalignment(enter, HPos.CENTER);
		GridPane.setValignment(enter, VPos.CENTER);
		grid.add(usernamel, 0, 2);
		GridPane.setHalignment(usernamel, HPos.CENTER);
		GridPane.setValignment(usernamel, VPos.CENTER);
		grid.add(inusername, 1, 2);
		GridPane.setColumnSpan(inusername, 3);
		GridPane.setHalignment(inusername, HPos.CENTER);
		GridPane.setValignment(inusername, VPos.CENTER);
		grid.add(passwordl, 0, 3);
		GridPane.setHalignment(passwordl, HPos.CENTER);
		GridPane.setValignment(passwordl, VPos.CENTER);
		grid.add(inpassword, 1, 3);
		GridPane.setColumnSpan(inpassword, 3);
		GridPane.setHalignment(inpassword, HPos.CENTER);
		GridPane.setValignment(inpassword, VPos.CENTER);
		grid.add(show, 1, 4);
		grid.add(loginb, 0, 5);
		GridPane.setColumnSpan(loginb, 2);
		GridPane.setHalignment(loginb, HPos.CENTER);
		GridPane.setValignment(loginb, VPos.CENTER);
		grid.add(cancelb, 3, 5);
		GridPane.setColumnSpan(cancelb ,2);
		GridPane.setHalignment(cancelb, HPos.CENTER);
		GridPane.setValignment(cancelb, VPos.CENTER);

		ChangeListener<? super Boolean> check = (observable, oldValue, newValue) -> {
			String passwordshow;
			if(show.isSelected()){
				passwordshow = inpassword.getText();
				grid.getChildren().remove(inpassword);
				inpasswordshow.setText(passwordshow);
				grid.add(inpasswordshow, 1, 3);
				GridPane.setColumnSpan(inpasswordshow, 3);
				GridPane.setHalignment(inpasswordshow, HPos.CENTER);
				GridPane.setValignment(inpasswordshow, VPos.CENTER);
			}
			else{
				passwordshow = inpasswordshow.getText();
				grid.getChildren().remove(inpasswordshow);
				inpassword.setText(passwordshow);
				grid.add(inpassword, 1, 3);
				GridPane.setHalignment(inpassword, HPos.CENTER);
				GridPane.setValignment(inpassword, VPos.CENTER);	
			}
		};	
		show.selectedProperty().addListener(check);

		loginb.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent logina){
				String usernamef = "John";
				String passwordf = "Hello";
				String password, username;
				username = inusername.getText();
				password = inpassword.getText();
				if(usernamef.equals(username)){
					if(passwordf.equals(password)){
						grid.getChildren().remove(enter);
						grid.getChildren().remove(usernamel);
						grid.getChildren().remove(inusername);
						grid.getChildren().remove(passwordl);
						grid.getChildren().remove(inpassword);
						grid.getChildren().remove(loginb);
						grid.getChildren().remove(cancelb);
						grid.getChildren().remove(incorrect);
						grid.getChildren().remove(show);

						Label output = new Label("Welcome " + usernamef);
						grid.add(output, 0, 0);
						GridPane.setColumnSpan(output, 5);
						GridPane.setRowSpan(output, 4);
						GridPane.setHalignment(output, HPos.CENTER);
						grid.add(cancelb, 0, 5);
						GridPane.setColumnSpan(cancelb, 5);
						cancelb.setDefaultButton(true);
					}
					else{
						GridPane.setRowSpan(enter, 1);
						grid.add(incorrect, 0, 1);
						GridPane.setColumnSpan(incorrect, 5);
					}
				}
				else{
					grid.getChildren().remove(enter);
					grid.add(enter, 0, 0);
					grid.add(incorrect, 0, 1);
					GridPane.setColumnSpan(enter, 5);
					GridPane.setColumnSpan(incorrect, 5);
				}	
			}
		});

		cancelb.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent cancela){
				System.exit(0);
			}
		});		

		Scene scene = new Scene(grid, 750, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
