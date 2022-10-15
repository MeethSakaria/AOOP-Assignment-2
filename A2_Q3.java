package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.event.*;
import javafx.geometry.Pos;

public class A2_Q3 extends Application {
	Label tf;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("Context Menu");
		
		FlowPane rootNode = new FlowPane();
		
		Scene myScene = new Scene(rootNode,300,300);
		myStage.setScene(myScene);
		
		tf = new Label("Menu");
		
		Menu new_1 = new Menu("New");
		MenuItem file = new MenuItem("File");
		MenuItem folder = new MenuItem("Folder");
		MenuItem image = new MenuItem("Image");
		new_1.getItems().addAll(file,folder,image);
		
		Menu view = new Menu("View");
		MenuItem large = new MenuItem("Large");
		MenuItem medium = new MenuItem("Medium");
		MenuItem small = new MenuItem("Small");
		view.getItems().addAll(large,medium,small);
		
		ContextMenu editMenu = new ContextMenu(new_1,view);
		
		tf.setContextMenu(editMenu);
		
		
		EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				tf.setText(name + " selected");
			}
		};
		
		file.setOnAction(MEHandler);
		folder.setOnAction(MEHandler);
		image.setOnAction(MEHandler);
		large.setOnAction(MEHandler);
		medium.setOnAction(MEHandler);
		small.setOnAction(MEHandler);
		rootNode.setAlignment(Pos.CENTER);
		rootNode.getChildren().addAll(tf);

		myStage.show();
	}
}