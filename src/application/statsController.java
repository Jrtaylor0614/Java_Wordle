package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class statsController {
	
	@FXML private Label gamesPlayed;
	@FXML private Label winPercent;
	@FXML private Label currentStreak;
	@FXML private Label maxStreak;
	@FXML private Label answers;
	@FXML private BarChart bc;
	@FXML private AnchorPane ap;
	
	private int played;
	private int percent;
	private int current;
	private int max;
	
	statsCollection sc = statsCollection.getInstance();
	
	public void initialize() {
		gamesPlayed.setText(String.valueOf(sc.getPlayed()));
		winPercent.setText(String.valueOf(sc.getPercent()));
		currentStreak.setText(String.valueOf(sc.getCurrent()));
		maxStreak.setText(String.valueOf(sc.getMax()));
		answers.setText(sc.getAnswer());
		XYChart.Series s1 = new XYChart.Series();
		s1.getData().add(new XYChart.Data("1", sc.getAttempts1()));
		s1.getData().add(new XYChart.Data("2", sc.getAttempts2()));
		s1.getData().add(new XYChart.Data("3", sc.getAttempts3()));
		s1.getData().add(new XYChart.Data("4", sc.getAttempts4()));
		s1.getData().add(new XYChart.Data("5", sc.getAttempts5()));
		s1.getData().add(new XYChart.Data("6", sc.getAttempts6()));

		bc.getData().add(s1);
		bc.setRotate(90);
	}
	
	@FXML
	void sub(ActionEvent event) throws IOException {
		
		sc.getCurrent();
		sc.getPlayed();
		sc.getWin();
		sc.getPercent();
		sc.getAnswer();
//		sc.setMax(max);
//		sc.setPercent(percent);
//		sc.setPlayed(played);
		
		Stage stage = (Stage) ap.getScene().getWindow();

        // Load the new FXML file
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

        // Create a new scene
        Scene scene = new Scene(root);

        // Set the scene on the stage
        stage.setScene(scene);
	}
	
}
