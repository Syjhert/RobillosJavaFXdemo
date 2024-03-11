module com.example.robillosjavafxdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.robillosjavafxdemo to javafx.fxml;
    exports com.example.robillosjavafxdemo;
}