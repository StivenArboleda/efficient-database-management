package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Controller;
import model.Person;
import threads.ThreadProgress;

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
    
    //atributo para el progress
    private int generator; 

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
    	
    	searchByCode = false;
		searchByFullname = false;
		searchByName = false;
		searchBySurname = false;
    }

    @FXML
    void showGenerateForm(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenerateForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent generatePplPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(generatePplPane);
    	
    	searchByCode = false;
		searchByFullname = false;
		searchByName = false;
		searchBySurname = false;
    }

    @FXML
    void showUpdateForm(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchForm.fxml"));
		
		fxmlLoader.setController(this);
		Parent updatePersonPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setCenter(updatePersonPane);
    	
    	searchByCode = false;
		searchByFullname = false;
		searchByName = false;
		searchBySurname = false;
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
    
    @FXML
    void predictText(KeyEvent  event) {
    	String prefix = searchField.getText();
    	ArrayList<Person> coincidents = new ArrayList<Person>();
    	predictList.setVisible(false);
    	
    	if (searchByCode) {
//    		for (int i = 0; i < coincidents.size(); i++) {
//				if (coincidents.get(i) != null) {
//					coincidents.remove(coincidents.get(i));
//					predictList.getItems().remove(coincidents.get(i));
//					
//				}
//    		}
			coincidents.add(control.searchPerson(prefix, 3));
			for (int i = 0; i < coincidents.size(); i++) {
				if (coincidents.get(i) != null) {
					predictList.getItems().add(coincidents.get(i).getCod());
				}
			}
		}else if (searchByFullname) {
			coincidents.add(control.searchPerson(prefix, 2));
			for (int i = 0; i < coincidents.size(); i++) {
				if (coincidents.get(i) != null) {
//					predictList.getItems().remove(coincidents.get(i).getName() + " " + coincidents.get(i).getLastName());
					predictList.getItems().add(coincidents.get(i).getName() + " " + coincidents.get(i).getLastName());
				}
			}
		}else if (searchByName) {
			coincidents.addAll(control.search2(prefix));
			for (int i = 0; i < coincidents.size(); i++) {
				if (coincidents.get(i) != null) {
//					predictList.getItems().remove(coincidents.get(i).getName());
					predictList.getItems().add(coincidents.get(i).getName());
				}
			}
		}else if (searchBySurname) {
			coincidents.add(control.searchPerson(prefix, 1));
			for (int i = 0; i < coincidents.size(); i++) {
				if (coincidents.get(i) != null) {
//					predictList.getItems().remove(coincidents.get(i).getLastName());
					predictList.getItems().add(coincidents.get(i).getLastName());
				}
			}
		}
    	
    	predictList.setVisible(true);
    	predictList.setOnMouseClicked(e -> {
//    		predictList.getpredictList.getEditingIndex()
    		System.out.println("wdfwedfwed");
    	});
    	
    	loadTable(coincidents);
    }
    
    @FXML
    void generatePeople(ActionEvent event) {
    	try {
    		generator = Integer.parseInt(quantityToGenerate.getText());
    		if(generator < 1) {
    			Alert succesfullyAddedMsg = new Alert(AlertType.WARNING);
				succesfullyAddedMsg.setTitle("NUMERO INVALIDO");
				succesfullyAddedMsg.setHeaderText("EL NÚMERO INGRESADO NO ES VÁLIDO");
				succesfullyAddedMsg.setContentText("POR FAVOR INGRESE UN NÚMERO MAYOR A 1.");
				succesfullyAddedMsg.showAndWait();
    		}else {
    			ArrayList<Long> numbers = numbers(generator);
    			ThreadProgress tp = new ThreadProgress(this, numbers);
    			Button update = new Button("Update");
            	update.setOnAction(e -> {
        			try {
        				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindForm.fxml"));
        				fxmlLoader.setController(this);
        				Parent updatePersonPane = fxmlLoader.load();
        				
        				Scene scene = new Scene(updatePersonPane);
        				Stage stage = new Stage(); 
        				stage.setScene(scene);
        				stage.setTitle("Efficent Database Management");
        				stage.show();
        			} catch (IOException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
        		});
    			control.addPerson("sisaspai.jpg", update);
    			tp.setDaemon(true);
    			tp.start();
    		}
    	
    	}catch(NumberFormatException e) {
    		Alert succesfullyAddedMsg = new Alert(AlertType.WARNING);
			succesfullyAddedMsg.setTitle("NUMERO INVALIDO");
			succesfullyAddedMsg.setHeaderText("EL NÚMERO INGRESADO NO ES VÁLIDO");
			succesfullyAddedMsg.setContentText("POR FAVOR INGRESE UN NÚMERO VALIDO.");
			succesfullyAddedMsg.showAndWait();
    	}
  
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
            	
            	Button update = new Button("Update");
            	update.setOnAction(e -> {
        			try {
        				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindForm.fxml"));
        				fxmlLoader.setController(this);
        				Parent updatePersonPane = fxmlLoader.load();
        				
        				Scene scene = new Scene(updatePersonPane);
        				Stage stage = new Stage(); 
        				stage.setScene(scene);
        				stage.setTitle("Efficent Database Management");
        				stage.show();
        			} catch (IOException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
        		});
            	
            	control.addPerson(addName.getText(), addSurname.getText(), gender, year, month, day, height, addNationality.getText(), "https://thispersondoesnotexist.com", update);
            	clearFieldsnAlert();
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
    
    public void clearFieldsnAlert() {
    	addName.clear();
    	addSurname.clear();
    	addMale.setSelected(false);
    	addFemale.setSelected(false);
    	addBirthDate.getEditor().clear();
    	addHeight.clear();
    	addNationality.clear();
    	
    	Alert added = new Alert(AlertType.INFORMATION);
    	added.setTitle("User Added");
    	added.setHeaderText("User added successfully!");
    	added.showAndWait();
    }
    
    public void initializeDatePicker() {
    	LocalDate maxDate = LocalDate.now();
    	addBirthDate.setDayCellFactory(d -> new DateCell() {
    		@Override 
    		public void updateItem(LocalDate item, boolean empty) {
    			super.updateItem(item, empty);
    			setDisable(item.isAfter(maxDate));
    		}});
    }
    
    public void loadTable(ArrayList<Person> coincidents) {
		ObservableList<Person> observableList;
    	observableList = FXCollections.observableArrayList(coincidents);
    	
		tableEdit.setItems(observableList);
		colName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		colSurname.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		colCode.setCellValueFactory(new PropertyValueFactory<Person, String>("cod"));
		colGender.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
		colBirth.setCellValueFactory(new PropertyValueFactory<Person, String>("bornDate"));
		colHeight.setCellValueFactory(new PropertyValueFactory<Person, String>("height"));
		colNationality.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
		colEdit.setCellValueFactory(new PropertyValueFactory<Person, Button>("update"));
	}
    
    public void progressBar(int i) {
    	Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				
				progressOfGeneration.setProgress(i);
			}
		});
    }
	
	public ArrayList<Long> numbers(long data) {
		ArrayList<Long> numbe = new ArrayList<>();
		for (int i = 0; i < data; i++) {
			long num = (long) ((Math.random() * Long.MAX_VALUE) + Long.MIN_VALUE);
			numbe.add(num);
		}
		return numbe;
	}

    	
}
