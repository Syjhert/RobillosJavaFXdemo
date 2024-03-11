package com.example.robillosjavafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    AnchorPane pnMain;
    @FXML
    TextField tfUsername;
    @FXML
    PasswordField pfPassword;
    @FXML
    VBox pnLogin;
    @FXML
    AnchorPane pnWelcomeAnchor;
    @FXML
    VBox pnHome;
    @FXML
    ColorPicker cpPicker;

    List<User> users = new ArrayList<>();

    @FXML
    protected void onLoginButtonClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
        if(tfUsername.getText().length() == 0 || pfPassword.getText().length() == 0) return;
        User newUser = new User(tfUsername.getText(), pfPassword.getText());
        users.add(newUser);
        System.out.println("Added user: " + newUser.getUsername());
        pnMain.getScene().getStylesheets().clear();
        pnMain.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("hello.css")).toExternalForm());
        pnMain.getChildren().remove(pnLogin);
        pnMain.getChildren().add(root);
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("hello.css").getPath()));
            bw.write(".root { -fx-background-image: url(\"bg.jpg\"); }");
            bw.newLine();
            bw.write(".button { -fx-background-color: #" + cpPicker.getValue().toString().substring(2, 8) + "; }");
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        AnchorPane parent = (AnchorPane) pnHome.getParent();
        parent.getChildren().remove(pnHome);
        parent.getChildren().add(root);
    }

}