package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class A2_Q1 extends Application {

	String userId = "meeth";
	String pass = "12345678";
	TextField name,password;
	Label response1,response2;
	Button validate,back;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) throws UserException {
		myStage.setTitle("Validating UserId and Password");
		
		FlowPane rootNode1 = new FlowPane(Orientation.VERTICAL,10,20);
		rootNode1.setAlignment(Pos.CENTER);
		FlowPane rootNode2 = new FlowPane(Orientation.VERTICAL,10,20);
		rootNode2.setAlignment(Pos.CENTER);
		
		Scene myScene1 = new Scene(rootNode1,450,200);
		
		Scene myScene2 = new Scene(rootNode2,450,200);
		
		myStage.setScene(myScene1);
		
		name = new TextField();
		name.setPromptText("Enter your name");
		
		password = new TextField();
		password.setPromptText("Enter your password");
		
		validate = new Button("Validate");
		validate.setAlignment(Pos.BOTTOM_CENTER);
		back = new Button("Go back");
		
		response1 = new Label();
		response2 = new Label();
		
		Separator separator1 = new Separator();
		separator1.setPrefWidth(100);
		
		Separator separator2 = new Separator();
		separator2.setPrefWidth(100);
		
		validate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					if((name.getText().equals(userId)) && (password.getText().equals(pass))) {
						myStage.setScene(myScene2);		

						response2.setText("Welcome here");
					}
					else
						throw new UserException();
				}
				catch(UserException e) {
					response1.setText(e.toString());
				}
			}
		});
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(myScene1);
			}
		});
		
		rootNode1.getChildren().addAll(name,password,separator1,validate,response1);
		
		rootNode2.getChildren().addAll(response2,separator2,back);
		
		myStage.show();
	}
}

class UserException extends Exception {
	public String toString() {
		return "Exception : Invalid userId or password";
	}
}