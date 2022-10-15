package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.event.*;

public class A2_Q2 extends Application {
	
	Label response;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("Menu");
		
		BorderPane rootNode = new BorderPane();
		Scene myScene = new Scene(rootNode,400,400);
		myStage.setScene(myScene);
		
		response = new Label("");
		MenuBar mb = new MenuBar();
		
		Menu fileMenu = new Menu("_File");
		
		MenuItem new_1 = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		
		new_1.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));

		fileMenu.setMnemonicParsing(true);
		fileMenu.getItems().addAll(new_1,open,save);
		
		Menu editMenu = new Menu("_Edit");
		
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		
		cut.setAccelerator(KeyCombination.keyCombination("shortcut+X"));
		copy.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		paste.setAccelerator(KeyCombination.keyCombination("shortcut+V"));
		
		editMenu.setMnemonicParsing(true);
		editMenu.getItems().addAll(cut,copy,paste);
		
		Menu helpMenu = new Menu("_Help");
		
		MenuItem helpCenter = new MenuItem("Help Centre");
		MenuItem aboutUs = new MenuItem("About Us");
		
		helpCenter.setAccelerator(KeyCombination.keyCombination("shortcut+L"));
		aboutUs.setAccelerator(KeyCombination.keyCombination("shortcut+U"));
		
		helpMenu.setMnemonicParsing(true);
		helpMenu.getItems().addAll(helpCenter,aboutUs);
		
		mb.getMenus().addAll(fileMenu,editMenu,helpMenu);
		
		EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				response.setText(name + " selected");
			}
		};
		
		new_1.setOnAction(MEHandler);
		open.setOnAction(MEHandler);
		save.setOnAction(MEHandler);
		cut.setOnAction(MEHandler);
		copy.setOnAction(MEHandler);
		paste.setOnAction(MEHandler);
		helpCenter.setOnAction(MEHandler);
		aboutUs.setOnAction(MEHandler);

		rootNode.setTop(mb);
		rootNode.setCenter(response);
		
		myStage.show();
	}
}