import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CalcGui extends Application {
	BorderPane bp = new BorderPane();
	EvaluateExpression calcAlgorithm = new EvaluateExpression();
	GridPane gp = new GridPane();
	Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
	Button sym1,sym2,sym3,sym4,sym5,sym6,sym7,sym8,sym9,sym10;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		num0 = new Button("0");
		num0.setOnAction(e -> calcAlgorithm.tf.appendText("0"));
		
		num1 = new Button("1");
		num1.setOnAction(e -> calcAlgorithm.tf.appendText("1"));
		
		num2 = new Button("2");
		num2.setOnAction(e -> calcAlgorithm.tf.appendText("2"));
		
		num3 = new Button("3");
		num3.setOnAction(e -> calcAlgorithm.tf.appendText("3"));
		
		num4 = new Button("4");
		num4.setOnAction(e -> calcAlgorithm.tf.appendText("4"));
		
		num5 = new Button("5");
		num5.setOnAction(e -> calcAlgorithm.tf.appendText("5"));
		
		num6 = new Button("6");
		num6.setOnAction(e -> calcAlgorithm.tf.appendText("6"));
		
		num7 = new Button("7");
		num7.setOnAction(e -> calcAlgorithm.tf.appendText("7"));
		
		num8 = new Button("8");
		num8.setOnAction(e -> calcAlgorithm.tf.appendText("8"));
		
		num9 = new Button("9");
		num9.setOnAction(e -> calcAlgorithm.tf.appendText("9"));
		
		sym1 = new Button("(");
		sym1.setOnAction(e -> calcAlgorithm.tf.appendText("("));
		
		sym2 = new Button(")");
		sym2.setOnAction(e -> calcAlgorithm.tf.appendText(")"));
		
		sym3 = new Button("^");
		sym3.setOnAction(e -> calcAlgorithm.tf.appendText("^"));
		
		sym4 = new Button("%");
		sym4.setOnAction(e -> calcAlgorithm.tf.appendText("%"));
		
		sym5 = new Button("*");
		sym5.setOnAction(e -> calcAlgorithm.tf.appendText("*"));
		
		sym6 = new Button("/");
		sym6.setOnAction(e -> calcAlgorithm.tf.appendText("/"));
		
		sym7 = new Button("+");
		sym7.setOnAction(e -> calcAlgorithm.tf.appendText("+"));
		
		sym8 = new Button("-");
		sym8.setOnAction(e -> calcAlgorithm.tf.appendText("-"));
		
		sym9 = new Button("=");
		sym9.setOnAction(e -> calcAlgorithm.computeExpression(sym9));
		
		sym10 = new Button("C");
		sym10.setOnAction(e -> {
			calcAlgorithm.tf.clear();
			calcAlgorithm.text.clear();
		});
		
		gp.setPadding(new Insets(20,20,20,20));
		gp.setVgap(8);
		gp.setHgap(18);
		
		GridPane.setConstraints(sym1, 0, 0);
		GridPane.setConstraints(sym2, 1, 0);
		GridPane.setConstraints(sym3, 2, 0);
		GridPane.setConstraints(sym4, 3, 0);
		
		GridPane.setConstraints(num7, 0, 1);
		GridPane.setConstraints(num8, 1, 1);
		GridPane.setConstraints(num9, 2, 1);
		GridPane.setConstraints(sym6, 3, 1);
		
		GridPane.setConstraints(num4, 0, 2);
		GridPane.setConstraints(num5, 1, 2);
		GridPane.setConstraints(num6, 2, 2);
		GridPane.setConstraints(sym5, 3, 2);
		
		GridPane.setConstraints(num1, 0, 3);
		GridPane.setConstraints(num2, 1, 3);
		GridPane.setConstraints(num3, 2, 3);
		GridPane.setConstraints(sym8, 3, 3);
		
		GridPane.setConstraints(sym10, 0, 4);
		GridPane.setConstraints(num0, 1, 4);
		GridPane.setConstraints(sym9, 2, 4);
		GridPane.setConstraints(sym7, 3, 4);
		
		gp.getChildren().addAll(sym1,sym2,sym3,sym4,
				num7,num8,num9,sym6,num4,
				num5,num6,sym5,num1,num2,
				num3,sym8,num0,sym9,sym7,sym10);
		bp.setTop(calcAlgorithm.tf);
		bp.setCenter(gp);
		bp.setBottom(calcAlgorithm.text);
		
		
		Scene scene = new Scene(bp, 400,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);

	}

}//end

