import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class TheGUI extends Application {
	Button b_File = new Button("Import File");
	Button b_Finish = new Button("Finish");
	Button b_Show = new Button("Show Data");
	TextField t_fName = new TextField();
	TextField t_lName = new TextField();
	TextField t_Phone = new TextField();
	TextField t_Email= new TextField();
	TextArea t_Area = new TextArea();
	Label l_fName = new Label("First Name:");
	Label l_lName = new Label("Last Name:");
	Label l_Phone = new Label("Phone:");
	Label l_Email= new Label("Email: ");
	FileChooser chooser = new FileChooser();
	File f_file;
	BorderPane p_Main = new BorderPane();
	GridPane p_AddField = new GridPane();
	HBox p_buttons = new HBox();
	HBox p_TButtons = new HBox();
	ContactList dalist = new ContactList();

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//button stuff
		b_File.setOnAction(e -> {
			chooser.setTitle("Import File Type");
		chooser.setInitialDirectory(new File(System.getProperty("user.home")));
		chooser.getExtensionFilters().
			addAll(new FileChooser.ExtensionFilter("Txt", "*.txt"));
		this.f_file = chooser.showOpenDialog(primaryStage);
		try {
			dalist = new ContactList(this.f_file);
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
		});
		
		b_Finish.setOnAction(e->{
		Contact newContact = new Contact(
				t_fName.getText(),
				t_lName.getText(),
				Long.parseLong(t_Phone.getText()),
				t_Email.getText());
		dalist.add(newContact);
		t_fName.clear();
		t_lName.clear();
		t_Email.clear();
		t_Phone.clear();
		});
		b_Show.setOnAction(e->{
			String show = "";
			for(Contact x : dalist){
				show += x.toString() + "\n";
			}
			t_Area.setText(show);
			Scene scene2 = new Scene(t_Area);
			Stage secStage = new Stage();
			secStage.setScene(scene2);
			secStage.show();
		});
		//the add field
		p_AddField.setPadding(new Insets(10));
		p_AddField.setVgap(15);
		p_AddField.setHgap(10);
		GridPane.setConstraints(l_fName, 0, 0);
		GridPane.setConstraints(t_fName, 1, 0);
		GridPane.setConstraints(l_lName, 0, 1);
		GridPane.setConstraints(t_lName, 1, 1);
		GridPane.setConstraints(l_Phone, 2, 0);
		GridPane.setConstraints(t_Phone, 3, 0);
		GridPane.setConstraints(l_Email, 2, 1);
		GridPane.setConstraints(t_Email, 3, 1);
		
		//layouts
		p_TButtons.getChildren().addAll(b_File);
		p_buttons.getChildren().addAll(b_Finish,b_Show);
		
		p_AddField.getChildren().addAll(
				l_fName,t_fName,l_lName,t_lName,
				l_Phone,t_Phone,l_Email,t_Email);
		
		p_Main.setTop(p_TButtons);
		p_Main.setBottom(p_buttons);
		p_Main.setCenter(p_AddField);
		
		//set scene and stage
		Scene scene = new Scene(p_Main, 600,150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args){
		launch(args);
	}

}
