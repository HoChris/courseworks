import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;

public class CheckersColors extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The Game Checkers.");
        primaryStage.setMaxHeight(450);
        primaryStage.setMaxWidth(420);
        //set up pane
        TilePane board = new TilePane();
        board.setPrefRows(8);
        board.setPrefColumns(8);
        for(int c=0;c<4;c++){
            for (int j=0;j<4;j++){
                Rectangle k = new Rectangle(50,50,Color.WHITE);
                board.getChildren().add(k);
                Rectangle r = new Rectangle(50,50,Color.color(Math.random(),
                        Math.random(),Math.random()));
                board.getChildren().add(r);
            }
            for (int j=0;j<4;j++){
                Rectangle k = new Rectangle(50,50,Color.color(Math.random(),
                        Math.random(),Math.random()));
                board.getChildren().add(k);
                Rectangle r = new Rectangle(50,50,Color.WHITE);
                board.getChildren().add(r);
            }
        }
        //set up scene
        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
