package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.Controller;
import model.Person;

public class DatabaseManagementGUI {
	private Controller control;
	private boolean searchByName;
	private boolean searchBySurname;
	private boolean searchByFullname;
	private boolean searchByCode;
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
    @FXML
    private TextField searchField;
    @FXML
    private Label results;
    @FXML
    private ListView<String> predictList;
    @FXML
    private TableView<Person> tableEdit;
    @FXML
    private TableColumn<Person, String> colName;
    @FXML
    private TableColumn<Person, String> colSurname;
    @FXML
    private TableColumn<Person, String> colCode;
    @FXML
    private TableColumn<Person, String> colGender;
    @FXML
    private TableColumn<Person, String> colBirth;
    @FXML
    private TableColumn<Person, String> colHeight;
    @FXML
    private TableColumn<Person, String> colNationality;
    @FXML
    private TableColumn<Person, Button> colEdit;


	public DatabaseManagementGUI() {
		this.control = new Controller();
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
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    }
    
    @FXML
    void showSearchByCode(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchByCode = true;
    }

    @FXML
    void showSearchByFullname(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchByFullname = true;
    }

    @FXML
    void showSearchByName(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchByName = true;
    }

    @FXML
    void showSearchBySurname(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchBySurname = true;
    }
    
    public void findPeopleMatch() {
    	if (searchByCode) {
			
		}else if (searchByFullname) {
			
		}else if (searchByName) {
			
		}else if (searchBySurname) {
			
		}
    	
    	searchByCode = false;
    	searchByFullname = false;
    	searchByName = false;
    	searchBySurname = false;
    }
    
    @FXML
    void predictText(KeyEvent  event) {
    	System.out.println("sdqwdqdwq");
    }
    
    @FXML
    void generatePeople(ActionEvent event) {

    }
    
    @FXML
    void addPerson(ActionEvent event) {

    }
    
    
}
