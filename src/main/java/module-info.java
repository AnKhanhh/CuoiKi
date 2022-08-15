module com.example.cuoiki
{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    opens com.example.cuoiki to javafx.fxml;
    exports com.example.cuoiki;
}