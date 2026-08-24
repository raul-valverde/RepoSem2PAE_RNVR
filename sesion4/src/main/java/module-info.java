module ni.edu.uam.sesion4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.edu.uam.sesion4 to javafx.fxml;
    exports ni.edu.uam.sesion4;
}