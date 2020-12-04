package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
	public Button convert;
    @FXML
	public Label hero;
    @FXML
	public ChoiceBox<String> select;
    @FXML
	public TextField input;

    private static final String C_TO_F_TEXT="Celsius to fahrenheit";
    private static final String F_TO_C_TEXT="fahrenheit to Celsius";

    private boolean isC_TO_F=true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		select.getItems().add(C_TO_F_TEXT);
		select.getItems().add(F_TO_C_TEXT);

		select.setValue(C_TO_F_TEXT);
		select.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_TO_F_TEXT)){
				isC_TO_F=true;
			} else{
				isC_TO_F=false;
			}
		});

		convert.setOnAction(event ->
		{
			convertButton();
		});
	}

	private void convertButton() {


		String put=input.getText();

		float enteredTemperature=0.0f;
		try {
			enteredTemperature=Float.parseFloat(put);
		}catch(Exception exception){
			warnuser();
			return;
		}

		float newTemperature=0.0f;

		if(isC_TO_F){
			newTemperature=(enteredTemperature* 9/5) + 32;
		}else {
			newTemperature=(enteredTemperature -32) * 5/9;
		}
		display(newTemperature);
	}

	private void warnuser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERROR Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter a valid temperature" );
		alert.show();

	}

	private void display(float newTemperature) {
		String unit =isC_TO_F?"F" :"C";
		System.out.println("the New temperature is " + newTemperature +unit);

		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("the new temperature is:" + newTemperature + unit);
		alert.show();
	}
}
