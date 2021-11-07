package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginPopupFormController {
    public AnchorPane loginPopup;
    public JFXTextField userName;
    public JFXPasswordField passWord;

    public void backDashBoard(ActionEvent actionEvent) {
        Stage stage = (Stage) loginPopup.getScene().getWindow();
        stage.close();
    }

    public void openAdminAccess(ActionEvent actionEvent) throws IOException {
        if (userName.getText().equals("admin") && passWord.getText().equals("admin123")) {
            Stage stage0 = (Stage) loginPopup.getScene().getWindow();
            stage0.close();

            URL resource = getClass().getResource("../view/AdminAccessForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage stage = new Stage();
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }
}
