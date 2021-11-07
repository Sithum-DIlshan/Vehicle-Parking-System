package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class AddDriverFormController {
    public JFXButton addDriver;
    public JFXTextField dName;
    public JFXTextField nic;
    public JFXTextField license;
    public JFXTextArea address;
    public JFXTextField contactNo;

    public void addDriver(ActionEvent actionEvent) {
        String name = String.valueOf(dName.getText());
        String niC = String.valueOf(nic.getText());
        String licenseN = String.valueOf(license.getText());
        String addresss = String.valueOf(address.getText());
        String no = String.valueOf(contactNo.getText());

        Driver.drivers.add(new Driver(name, niC, licenseN, addresss, no));
        //System.out.println();
        Stage stage = (Stage) addDriver.getScene().getWindow();
        stage.close();
    }
}
