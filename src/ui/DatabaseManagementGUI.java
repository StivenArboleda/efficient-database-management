package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import model.Controller;

public class DatabaseManagementGUI {
	private Controller control;
	@FXML
    private BorderPane mainPane;
	@FXML
    private TextField quantityToGenerate;
	@FXML
    private ProgressBar progressOfGeneration;
    @FXML
    private Label timeOFGeneration;
    @FXML
    private TextField addName;
    @FXML
    private TextField addSurname;
    @FXML
    private ToggleGroup addGender;
    @FXML
    private DatePicker addBirthDate;
    @FXML
    private TextField addHeight;
    @FXML
    private TextField addNationality;

	public DatabaseManagementGUI() {
		this.control = new Controller(null, null, null, null);
	}

	@FXML
    void showAddForm(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent addPersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(addPersonPane);
    }

    @FXML
    void showGenerateForm(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenerateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent generatePplPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(generatePplPane);
    }

    @FXML
    void showUpdateForm(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    }
    
    @FXML
    void generatePeople(ActionEvent event) {

    }
    
    @FXML
    void addPerson(ActionEvent event) {

    }
}
