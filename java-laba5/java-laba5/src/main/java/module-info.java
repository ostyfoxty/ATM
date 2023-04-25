module com.example.javalaba5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javalaba5 to javafx.fxml;
    exports com.example.javalaba5;
}