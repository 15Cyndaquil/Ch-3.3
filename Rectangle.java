import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Rectangle extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		GridPane grid = new GridPane();
		for (int col=0; col<2; col++) {
			ColumnConstraints column = new ColumnConstraints(300);
			grid.getColumnConstraints().add(column);
		}
		for (int ro=0; ro<6; ro++) {
			RowConstraints row = new RowConstraints(50);
			grid.getRowConstraints().add(row);
		}
		Label text = new Label("Input the height and w");
		grid.add(text, 0, 0);
		GridPane.setHalignment(text, HPos.RIGHT);
		Label text1 = new Label("idth of your rectangle");
		grid.add(text1, 1, 0);
		GridPane.setHalignment(text1, HPos.LEFT);
		
		Label heightl = new Label("Height");
		grid.add(heightl, 0, 1);
		GridPane.setHalignment(heightl, HPos.CENTER);
		
		Label widthl = new Label("Width");
		grid.add(widthl, 1, 1);
		GridPane.setHalignment(widthl, HPos.CENTER);
		
		TextField height = new TextField();
		height.setPromptText("Enter the height");
		grid.add(height, 0, 2);
		
		TextField width = new TextField();
		width.setPromptText("Enter the width");
		grid.add(width, 1, 2);
		
		Button submit = new Button("Submit");
		submit.setDefaultButton(true);
		grid.add(submit, 0, 3);
		GridPane.setHalignment(submit, HPos.CENTER);
		GridPane.setValignment(submit, VPos.CENTER);
		
		Button cancel = new Button("Cancel");
		GridPane.setHalignment(cancel, HPos.CENTER);
		GridPane.setValignment(cancel, VPos.CENTER);
		grid.add(cancel, 1, 3);
		
		Label output1 = new Label();
		grid.add(output1, 0, 5);
		GridPane.setHalignment(output1, HPos.CENTER);
		
		Label output2 =new Label();
		grid.add(output2, 1, 5);
		GridPane.setHalignment(output2, HPos.CENTER);
		
		submit.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent submita){
				String width1;
				String height1;
				String areaf,perimiterf;
				double widthf;
				double heightf;
				double area;
				double perimiter;
				try
				{
					width1 = width.getText();
					height1 = height.getText();
					widthf = Double.parseDouble(width1);
					heightf = Double.parseDouble(height1);
					perimiter = 2*widthf + 2*heightf;
					area = widthf*heightf;
					areaf = String.valueOf(area);
					perimiterf = String.valueOf(perimiter);
					output1.setText("The Perimiter of your rectangle is " + perimiterf);
					output2.setText("The Area of your rectangle is " + areaf);
				}
				catch (NumberFormatException f)
				{
					output2.setText("");
					output1.setText("You did not input numbers");
				}
				
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){
		
			@Override
			public void handle(ActionEvent cancela){
				System.exit(0);
			}
		});
		
		Scene scene = new Scene(grid, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
