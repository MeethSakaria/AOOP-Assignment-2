package application;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;

public class A2_Q4 extends Application {

	Label lhead;
	Label lname;
	Label lgender;
	Label ldob;
	Label lstate;
	Label lqualification;
	TextField tname;
	Button bregister;
	ComboBox<String> cbState;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("JavaFx Registration Form");
		
		GridPane rootNode = new GridPane();
		
		Scene myScene = new Scene(rootNode,550,325);
		myStage.setScene(myScene);
		myStage.show();
		
		lhead = new Label("Employee Registration Form");
		lhead.setFont(Font.font("Arial",FontWeight.BOLD,20));
		
		lname = new Label("\tEnter Your Name:");
		lgender = new Label("\tSelect Your Gender:");
		ldob = new Label("\tEnter Date of Birth:");
		lstate = new Label("\t  Select Your State:");
		lqualification =  new Label("Select Your Qualification:");
		
		tname = new TextField();
		tname.setMinWidth(240);
		tname.setPromptText("Enter Your Name");
		
		bregister = new Button("Register");
		
		ToggleGroup tg = new ToggleGroup();
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		male.setToggleGroup(tg);
		female.setToggleGroup(tg);
		
		DatePicker dp = new DatePicker();
		
		ObservableList<String> states = FXCollections.observableArrayList("Karnataka","Maharastra","Tamil Nadu","Andra Pradesh","Gujarat","Kerala","Goa");
		cbState = new ComboBox<String>(states);
		cbState.setValue("Karnataka");
		
		CheckBox c1 = new CheckBox("UG");
		CheckBox c2 = new CheckBox("PG");
		CheckBox c3 = new CheckBox("PhD");
		
		HBox hb0 = new HBox(15);
		HBox hb1 = new HBox(15);
		HBox hb2 = new HBox(15);
		HBox hb3 = new HBox(15);
		HBox hb4 = new HBox(15);
		HBox hb5 = new HBox(15);
		HBox hb6 = new HBox(15);
		
		rootNode.setHgap(15);
		rootNode.setVgap(15);
		
		hb0.getChildren().add(lhead);
		hb1.getChildren().addAll(lname,tname);
		hb2.getChildren().addAll(lgender,male,female);
		hb3.getChildren().addAll(ldob,dp);
		hb4.getChildren().addAll(lstate,cbState);
		hb5.getChildren().addAll(lqualification,c1,c2,c3);
		hb6.getChildren().add(bregister);
		
		rootNode.setAlignment(Pos.TOP_CENTER);
		
		hb0.setAlignment(Pos.TOP_CENTER);
		hb6.setAlignment(Pos.BOTTOM_CENTER);
		hb0.setPadding(new Insets(20,0,0,0));
		
		rootNode.add(hb0, 1, 0,1,1);
		rootNode.add(hb1, 1, 2,1,1);
		rootNode.add(hb2, 1, 3,1,1);
		rootNode.add(hb3, 1, 4,1,1);
		rootNode.add(hb4, 1, 5,1,1);
		rootNode.add(hb5, 1, 6,1,1);
		rootNode.add(hb6, 1, 8,1,1);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Registration Scuccessful");
		alert.setHeaderText("Registration Status");
		alert.setContentText("Employee Registration is Successful!!");
		
		bregister.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				alert.show();
			}
		});
	}
}