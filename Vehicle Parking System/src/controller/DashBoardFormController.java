package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class DashBoardFormController {
    public static AnchorPane anchorPane;
    public JFXComboBox comboBoxSelectVehicle;
    public Label label;
    public JFXComboBox selectDriver;
    public Label parkingSlotNumber;
    public JFXButton parkVehicleButton;
    public Label parkedOrNot;
    public JFXButton onShiftButton;
    public Label date;
    public Label timeLabel;
    int i = 0;
    int j = 0;


    public void openManagementLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementLoginPopupForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
/*
    public static void addVehicle(String text, String type, int integer, int valueOf, String dNicText) {
        Vehicle.vehicleArrayList.add(new Van("text", "type", 22, 3, "dNicText"));
    }*/

    public void initialize() {

        selectDriver.setItems(FXCollections.observableArrayList(Driver.drivers));

        ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList(Vehicle.vehicleArrayList);
        comboBoxSelectVehicle.setItems(vehicleList);

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dateShow = new Date();
        //System.out.println(formatter1.format(dateShow));

        // System.out.println(formatter2.format(dateShow));

        // timeLabel.setAlignment(Pos.CENTER_LEFT);
        // final double MAX_FONT_SIZE = 30.0;
        // timeLabel.setFont(new Font(MAX_FONT_SIZE));

        date.setText(formatter1.format(dateShow));
        //onShiftButton.setDisable(selectDriver.getValue() == null);
        Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    timeLabel.setText(time);
                });
            }
        });
        timerThread.start();


/*
        selectDriver.setItems(FXCollections.observableArrayList(Driver.drivers));
*/
    }

    public void setText(ActionEvent mouseEvent) {
        onShiftButton.setDisable(true);
        if (comboBoxSelectVehicle.getValue() != null) {
            Vehicle check0 = (Vehicle) comboBoxSelectVehicle.getValue();
            for (int i = 0; i < Vehicle.parkedVehicles.size(); i++) {
                Vehicle vehicle = Vehicle.parkedVehicles.get(i);
                if (check0.getVehicleNUmber().equals(vehicle.getVehicleNUmber())) {
                    parkVehicleButton.setDisable(true);
                    onShiftButton.setDisable(false);
                    break;
                } else parkVehicleButton.setDisable(false);
            }

            // Vehicle check = (Vehicle) comboBoxSelectVehicle.getValue();


            //parkedOrNot.setText("Your Parking Slot Number");

            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();

            label.setText(vehicle.getVehicleType());

            if (vehicle.getVehicleType().equals("Van")) {
                parkingSlotNumber.setText(String.valueOf(ParkingSlot.vanParking.get(j)));
                //j++;
            } else if (vehicle.getVehicleType().equals("Bus")) {
                parkingSlotNumber.setText("14");
            } else if (vehicle.getVehicleType().equals("CargoLorry")) {
                parkingSlotNumber.setText(String.valueOf(ParkingSlot.cargoParking.get(i)));
                //i++;
            }
        }
    }

    public void parkVehicle(ActionEvent actionEvent) {
        Vehicle check = (Vehicle) comboBoxSelectVehicle.getValue();
        parkVehicleButton.setDisable(false);

        /*if (selectDriver.getValue().equals("null")) {
            onShiftButton.setDisable(true);
        }*/

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        //System.out.println(formatter.format(date));
        if (label.getText().equals("Van")) {
            // Vehicle checkDuplicate = (Vehicle) comboBoxSelectVehicle.getValue();
            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();

            Vehicle.parkedVehicles.add(new Van(vehicle.getVehicleNUmber(), vehicle.getVehicleType(), vehicle.getMaximumWeight(), vehicle.getNumOfPassengers(), vehicle.getDriverNic(), parkingSlotNumber.getText(), formatter.format(date)));
            ParkingSlot.vanParking.remove(Integer.valueOf(parkingSlotNumber.getText()));
            for (int i = 0; i < Vehicle.onShiftVehicles.size(); i++) {
                Vehicle vehicle2 = Vehicle.onShiftVehicles.get(i);
                if (vehicle.getVehicleNUmber().equals(vehicle2.getVehicleNUmber())) {
                    Vehicle.onShiftVehicles.remove(Vehicle.onShiftVehicles.get(i));
                }
            }
            //System.out.println(vehicle.vehicleNUmber);
        } else if (label.getText().equals("CargoLorry")) {

            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();
            Vehicle.parkedVehicles.add(new CargoLorry(vehicle.getVehicleNUmber(), vehicle.getVehicleType(), vehicle.getMaximumWeight(), vehicle.getNumOfPassengers(), vehicle.getDriverNic(), parkingSlotNumber.getText(), formatter.format(date)));
            ParkingSlot.cargoParking.remove(Integer.valueOf(parkingSlotNumber.getText()));
            for (int i = 0; i < Vehicle.onShiftVehicles.size(); i++) {
                Vehicle vehicle2 = Vehicle.onShiftVehicles.get(i);
                if (vehicle.getVehicleNUmber().equals(vehicle2.getVehicleNUmber())) {
                    Vehicle.onShiftVehicles.remove(Vehicle.onShiftVehicles.get(i));
                }
            }
            //System.out.println(vehicle.vehicleNUmber);
        } else {
            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();
            Vehicle.parkedVehicles.add(new Bus(vehicle.getVehicleNUmber(), vehicle.getVehicleType(), vehicle.getMaximumWeight(), vehicle.getNumOfPassengers(), vehicle.getDriverNic(), parkingSlotNumber.getText(), formatter.format(date)));
            for (int i = 0; i < Vehicle.onShiftVehicles.size(); i++) {
                Vehicle vehicle2 = Vehicle.onShiftVehicles.get(i);
                if (vehicle.getVehicleNUmber().equals(vehicle2.getVehicleNUmber())) {
                    Vehicle.onShiftVehicles.remove(Vehicle.onShiftVehicles.get(i));
                }
            }
        }

        for (int i = 0; i < Vehicle.parkedVehicles.size(); i++) {
            Vehicle vehicle = Vehicle.parkedVehicles.get(i);
            if (check.getVehicleNUmber().equals(vehicle.getVehicleNUmber())) {
                parkVehicleButton.setDisable(true);
            }
        }
        Vehicle check0 = (Vehicle) comboBoxSelectVehicle.getValue();
        for (int i = 0; i < Vehicle.parkedVehicles.size(); i++) {
            Vehicle vehicle = Vehicle.parkedVehicles.get(i);
            if (check0.getVehicleNUmber().equals(vehicle.getVehicleNUmber()) /*&& selectDriver.getValue() != null*/) {
                onShiftButton.setDisable(false);
            }
        }

    }

    public void onShiftDelivery(ActionEvent actionEvent) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();

       /* Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();
        Driver driver = (Driver) selectDriver.getValue();
       */
        if (label.getText().equals("Van")) {
            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();
            Driver driver = (Driver) selectDriver.getValue();
            Vehicle.onShiftVehicles.add(new Van(vehicle.getVehicleNUmber(), vehicle.getVehicleType(), formatter.format(date), driver.getName()));

            // Vehicle check0 = (Vehicle) comboBoxSelectVehicle.getValue();
            for (int i = 0; i < Vehicle.parkedVehicles.size(); i++) {
                Vehicle vehicle2 = Vehicle.parkedVehicles.get(i);
                if (vehicle.getVehicleNUmber().equals(vehicle2.getVehicleNUmber())) {
                    Vehicle.parkedVehicles.remove(Vehicle.parkedVehicles.get(i));
                    ParkingSlot.vanParking.add(Integer.valueOf(vehicle2.getParkedSlot()));
                    Collections.sort(ParkingSlot.vanParking);
                } /*else onShiftButton.setDisable(true);*/
            }

        } else if (label.getText().equals("CargoLorry")) {
            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();
            Driver driver = (Driver) selectDriver.getValue();
            Vehicle.onShiftVehicles.add(new CargoLorry(vehicle.getVehicleNUmber(), vehicle.getVehicleType(), formatter.format(date), driver.getName()));
            for (int i = 0; i < Vehicle.parkedVehicles.size(); i++) {
                Vehicle vehicle2 = Vehicle.parkedVehicles.get(i);
                if (vehicle.getVehicleNUmber().equals(vehicle2.getVehicleNUmber())) {
                    Vehicle.parkedVehicles.remove(Vehicle.parkedVehicles.get(i));
                    ParkingSlot.cargoParking.add(Integer.valueOf(vehicle2.getParkedSlot()));
                    Collections.sort(ParkingSlot.cargoParking);
                } /*else onShiftButton.setDisable(true);*/
            }

        } else {
            Vehicle vehicle = (Vehicle) comboBoxSelectVehicle.getValue();
            Driver driver = (Driver) selectDriver.getValue();
            Vehicle.onShiftVehicles.add(new Bus(vehicle.getVehicleNUmber(), vehicle.getVehicleType(), formatter.format(date), driver.getName()));
            for (int i = 0; i < Vehicle.parkedVehicles.size(); i++) {
                Vehicle vehicle2 = Vehicle.parkedVehicles.get(i);
                if (vehicle.getVehicleNUmber().equals(vehicle2.getVehicleNUmber())) {
                    Vehicle.parkedVehicles.remove(Vehicle.parkedVehicles.get(i));
                } /*else onShiftButton.setDisable(true);*/
            }
        }

        Vehicle check1 = (Vehicle) comboBoxSelectVehicle.getValue();
        for (int i = 0; i < Vehicle.onShiftVehicles.size(); i++) {
            Vehicle vehicle = Vehicle.onShiftVehicles.get(i);
            if (check1.getVehicleNUmber().equals(vehicle.getVehicleNUmber())) {
                Vehicle.parkedVehicles.remove(Vehicle.onShiftVehicles.get(i));
                parkVehicleButton.setDisable(false);
                onShiftButton.setDisable(true);
            } /*else onShiftButton.setDisable(true);*/
        }
    }

    public void loadDrivers(MouseEvent mouseEvent) {
        selectDriver.setItems(FXCollections.observableArrayList(Driver.drivers));

    }

    public void loadVehicles(MouseEvent mouseEvent) {
        ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList(Vehicle.vehicleArrayList);
        comboBoxSelectVehicle.setItems(vehicleList);
    }

}