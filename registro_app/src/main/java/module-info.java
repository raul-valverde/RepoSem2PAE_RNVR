module ni.edu.uam.registro_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.edu.uam.registro_app.controllers to javafx.fxml;
    exports ni.edu.uam.registro_app;
}