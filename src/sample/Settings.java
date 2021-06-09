package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Settings {

    public static BarChart bc = new BarChart("Default Bar Chart ","X Values");
    public static LineChart lc = new LineChart("Default Bar Chart ","X Values");

    @FXML
    private Button saveButton;
    @FXML
    private TextField textCaption;
    @FXML
    private TextField textXAxis;
    @FXML
    private TextField textYAxis;
    @FXML
    private TextField textWidth;
    @FXML
    private TextField textHeight;


    public void saveButtonAction(ActionEvent event) throws IOException {
        //save the properties
        if(textCaption.getText().isEmpty() || textXAxis.getText().isEmpty()|| textYAxis.getText().isEmpty()|| textWidth.getText().isEmpty()|| textHeight.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "You need to fill all!").showAndWait();
        }
        else{
        bc.setTitle(textCaption.getText());
        bc.setxAxisLabel(textXAxis.getText());
        bc.setyAxisLabel(textYAxis.getText());
        bc.setWidth(Integer.parseInt(textWidth.getText()));
        bc.setHeight(Integer.parseInt(textHeight.getText()));
        lc.setTitle(textCaption.getText());
        lc.setxAxisLabel(textXAxis.getText());
        lc.setyAxisLabel(textYAxis.getText());
        lc.setWidth(Integer.parseInt(textWidth.getText()));
        lc.setHeight(Integer.parseInt(textHeight.getText()));
        //close the window
        System.out.println(bc.getxAxisLabel() + bc.getyAxisLabel() + bc.getTitle() + bc.getHeight() + bc.getWidth()+" saved");
        Stage window2 = (Stage) saveButton.getScene().getWindow();
        window2.close();
        }
    }

    public static BarChart getBc() {
        return bc;
    }

    public void setBc(BarChart bc) {
        this.bc = bc;
    }

    public static LineChart getLc() {
        return lc;
    }

    public static void setLc(LineChart lc) {
        Settings.lc = lc;
    }
}
