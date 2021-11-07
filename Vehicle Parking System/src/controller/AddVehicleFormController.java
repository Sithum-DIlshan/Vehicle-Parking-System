package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddVehicleFormController {
    public JFXButton addVehicle;
    public JFXTextField vehicleNo;
    public JFXTextField maximumWeight;
    public JFXTextField noOfPassengers;
    public JFXComboBox selectVehicleType;
    public JFXTextField dNic;
    public AnchorPane addVehicleAnchor;
   // String type;

    public void initialize() {
        selectVehicleType.setItems(FXCollections.observableArrayList("Van", "CargoLorry"));
    }

    public void backAdminAccess(ActionEvent actionEvent) {
        if (String.valueOf(selectVehicleType.getValue()).equals("Van")) {
            Vehicle.vehicleArrayList.add(new Van(vehicleNo.getText(), String.valueOf(selectVehicleType.getValue()), Integer.valueOf(maximumWeight.getText()), Integer.valueOf(noOfPassengers.getText()), dNic.getText()));
        } else if (String.valueOf(selectVehicleType.getValue()).equals("CargoLorry")){
            Vehicle.vehicleArrayList.add(new CargoLorry(vehicleNo.getText(), String.valueOf(selectVehicleType.getValue()), Integer.valueOf(maximumWeight.getText()), Integer.valueOf(noOfPassengers.getText()), dNic.getText()));
        }
        Stage stage = (Stage) addVehicleAnchor.getScene().getWindow();
        stage.close();
    }

}
