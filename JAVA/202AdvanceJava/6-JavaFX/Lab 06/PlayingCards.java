import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayingCards extends Application {

	@Override
	public void start(Stage stageOne) throws Exception {
		Pane pane = new HBox(5);
		for(int i = 0; i<6;i++){
			int j = (int)(Math.random()*54);
			String ranCard = "Image/" + j + ".png";
			Image daCard = new Image(ranCard);
			ImageView showCard = new ImageView(daCard);
			pane.getChildren().add(showCard);
		}
		
		Scene scene = new Scene(pane);
		stageOne.setTitle("Here are the Cards");
		stageOne.setScene(scene);
		stageOne.show();
	}
	public static void main(String[] args){
		launch(args);
	}
}
