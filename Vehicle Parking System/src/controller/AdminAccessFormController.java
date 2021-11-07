package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class AdminAccessFormController {
    public AnchorPane adminAccess;
    public JFXComboBox<String> selectTableType;
    public TableColumn c1;
    public TableColumn c2;
    public TableColumn c3;
    public TableColumn c4;
    public TableView<Vehicle> tblData;

    public void initialize() {
        selectTableType.setItems(FXCollections.observableArrayList("in Parking", "on Delivery"));

    }

    public void openAddVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void openAddDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void goToDashBoard(ActionEvent actionEvent) {
        Stage stage = (Stage) adminAccess.getScene().getWindow();
        stage.close();
    }

    public void loadTable(ActionEvent actionEvent) {
        if (selectTableType.getValue().equals("in Parking")) {
            c1.setText("Vehicle Number");
            c2.setText("Vehicle Type");
            c3.setText("Parking Slot");
            c4.setText("Parked Time");

            tblData.setItems(FXCollections.observableArrayList(Vehicle.parkedVehicles));
            c1.setCellValueFactory(new PropertyValueFactory("vehicleNUmber"));
            c2.setCellValueFactory(new PropertyValueFactory("vehicleType"));
            c3.setCellValueFactory(new PropertyValueFactory("parkedSlot"));
            c4.setCellValueFactory(new PropertyValueFactory("date"));
        } else if (selectTableType.getValue().equals("on Delivery")) {
            c1.setText("Vehicle Number");
            c2.setText("Vehicle Type");
            c3.setText("Driver Name");
            c4.setText("Left Time");

            tblData.setItems(FXCollections.observableArrayList(Vehicle.onShiftVehicles));
            c1.setCellValueFactory(new PropertyValueFactory("vehicleNUmber"));
            c2.setCellValueFactory(new PropertyValueFactory("vehicleType"));
            c3.setCellValueFactory(new PropertyValueFactory("driverName"));
            c4.setCellValueFactory(new PropertyValueFactory("date"));
        }
    }
}
