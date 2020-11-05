package ui;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    private RadioButton addMale;
    @FXML
    private RadioButton addFemale;
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
    	initializeDatePicker();
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
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchByCode = true;
    }

    @FXML
    void showSearchByFullname(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchByFullname = true;
    }

    @FXML
    void showSearchByName(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	searchByName = true;
    }

    @FXML
    void showSearchBySurname(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindForm.fxml"));
		
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
    	try {
    		int gender = -1;
        	
        	if (addMale.isSelected()) {
    			gender = 1;
    		}else if (addFemale.isSelected()) {
    			gender = 0;
    		}else {
    			Alert genderEmpty = new Alert(AlertType.ERROR);
    			genderEmpty.setTitle("Gender Selector is Empty");
    			genderEmpty.setHeaderText("Make sure that gender field dont stay empty");
    			genderEmpty.showAndWait();
    		}
        	
        	if (!addName.getText().isEmpty() && !addSurname.getText().isEmpty() && !addBirthDate.getEditor().getText().isEmpty() && !addHeight.getText().isEmpty() && !addNationality.getText().isEmpty()){
        		int day = addBirthDate.getValue().getDayOfMonth();
            	int month = addBirthDate.getValue().getMonthValue();
            	int year = addBirthDate.getValue().getYear();
            	
            	double height = Double.parseDouble(addHeight.getText());
            	
            	control.addPerson(addName.getText(), addSurname.getText(), gender, year, month, day, height, addNationality.getText(), "https://thispersondoesnotexist.com");
			}else {
				Alert emptyField = new Alert(AlertType.ERROR);
				emptyField.setTitle("Some Field Empty");
				emptyField.setHeaderText("Make sure that no field stay empty");
				emptyField.showAndWait();
			}
		} catch (NumberFormatException e) {
			Alert wrongHeight = new Alert(AlertType.ERROR);
			wrongHeight.setTitle("Wrong Format on Height Field");
			wrongHeight.setHeaderText("Make sure that in field are no characters but numbers or it stay empty");
			wrongHeight.showAndWait();
		}
    }
    
    public void initializeDatePicker() {
    	LocalDate minDate = LocalDate.of(1989, 4, 16);
    	LocalDate maxDate = LocalDate.now();
    	addBirthDate.setDayCellFactory(d -> new DateCell() {
    		@Override public void updateItem(LocalDate item, boolean empty) {
    			super.updateItem(item, empty);
    			setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
    			}});
    }
}
