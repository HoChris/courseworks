import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DaMatrix extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ghetto Matrix");
        GridPane gMatrix = new GridPane();
        gMatrix.setGridLinesVisible(true);
        //setup pane
        for(int i = 0;i<10;i++){
            for (int j = 0; j < 10 ; j++) {
                HBox field = new HBox(new TextField(Integer.
                        toString((int)(Math.rint(Math.random())))));
                field.setPrefWidth(30);
                GridPane.setRowIndex(field, j);
                GridPane.setColumnIndex(field, i);
                gMatrix.getChildren().add(field);
            }
        }
        //setup scene
        Scene scene = new Scene(gMatrix);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
