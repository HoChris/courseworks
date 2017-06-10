
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;

public class DaFace extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Im ashamed on how long this took..");
        //setup pane
        Pane sPane = new Pane();
        Ellipse face = new Ellipse();
        face.centerXProperty().bind(sPane.widthProperty().divide(2));
        face.centerYProperty().bind(sPane.heightProperty().divide(2));
        face.setRadiusX(120);
        face.setRadiusY(150);
        face.setFill(Color.BLACK);


        Arc ears = new Arc();
        ears.centerXProperty().bind(face.centerXProperty().add(75));
        ears.centerYProperty().bind(face.centerYProperty().subtract(180));
        ears.setRadiusX(150);
        ears.setRadiusY(105);
        ears.setStartAngle(-100);
        ears.setLength(20);
        ears.setType(ArcType.ROUND);
        ears.setFill(Color.BLACK);

        Arc ears2 = new Arc();
        ears2.centerXProperty().bind(face.centerXProperty().subtract(75));
        ears2.centerYProperty().bind(face.centerYProperty().subtract(180));
        ears2.setRadiusX(150);
        ears2.setRadiusY(105);
        ears2.setStartAngle(-100);
        ears2.setLength(20);
        ears2.setType(ArcType.ROUND);
        ears2.setFill(Color.BLACK);

        Arc eyes = new Arc();
        eyes.centerXProperty().bind(face.centerXProperty().add(25));
        eyes.centerYProperty().bind(face.centerYProperty().subtract(145));
        eyes.setRadiusX(175);
        eyes.setRadiusY(145);
        eyes.setStartAngle(-130);
        eyes.setLength(25);
        eyes.setType(ArcType.CHORD);
        eyes.setFill(Color.WHITESMOKE);

        Arc eyes2 = new Arc();
        eyes2.centerXProperty().bind(face.centerXProperty().subtract(25));
        eyes2.centerYProperty().bind(face.centerYProperty().subtract(145));
        eyes2.setRadiusX(175);
        eyes2.setRadiusY(145);
        eyes2.setStartAngle(-75);
        eyes2.setLength(25);
        eyes2.setType(ArcType.CHORD);
        eyes2.setFill(Color.WHITESMOKE);



        Rectangle jaw = new Rectangle();
        jaw.xProperty().bind(face.centerXProperty().subtract(75));
        jaw.yProperty().bind(face.centerYProperty().add(25));
        jaw.setHeight(80);
        jaw.setWidth(145);
        jaw.setFill(Color.BURLYWOOD);

        Rectangle jaw2 = new Rectangle();
        jaw2.xProperty().bind(face.centerXProperty().subtract(48));
        jaw2.yProperty().bind(face.centerYProperty().add(30));
        jaw2.setHeight(105);
        jaw2.setWidth(100);
        jaw2.setFill(Color.BURLYWOOD);

        Rectangle nose = new Rectangle();
        nose.xProperty().bind(face.centerXProperty().subtract(15));
        nose.yProperty().bind(face.centerYProperty().add(15));
        nose.setRotate(45);
        nose.setHeight(25);
        nose.setWidth(25);
        nose.setFill(Color.BLACK);

        Line mouth = new Line();
        mouth.startXProperty().bind(face.centerXProperty().subtract(25));
        mouth.startYProperty().bind(face.centerYProperty().add(85));
        mouth.endXProperty().bind(face.centerXProperty().add(25));
        mouth.endYProperty().bind(face.centerYProperty().add(85));
        mouth.setStroke(Color.BLACK);

        Line chin = new Line();
        chin.startXProperty().bind(face.centerXProperty().subtract(5));
        chin.startYProperty().bind(face.centerYProperty().add(125));
        chin.endXProperty().bind(face.centerXProperty().add(5));
        chin.endYProperty().bind(face.centerYProperty().add(125));
        chin.setStroke(Color.BLACK);
        
        Reflection reflex= new Reflection(1,1,.5,.5); 
        face.setEffect(reflex);
        
        sPane.getChildren().addAll(face, ears, ears2, eyes, eyes2, jaw, jaw2,nose ,mouth, chin);


        //setup scene
        Scene scene = new Scene(sPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
    	launch(args);
    }
}
