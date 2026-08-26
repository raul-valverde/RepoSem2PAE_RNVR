package ni.edu.uam.sesion4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private Button btnEnter;

    @FXML
    protected void loginAction (ActionEvent event) {
        String user = txtUser.getText();
        String pw = txtPassword.getText();

        if (user.equals("admin") && pw.equals("1")) {
            try {
                // Obtenemos la ventana actual
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Cargamos la nueva vista
                FXMLLoader fxmlLoader = new FXMLLoader(GradeApplication.class.getResource("grade-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 600);

                stage.setTitle("Panel Principal - Registro");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.err.println("Error al cargar el archivo FXML:");
                e.printStackTrace(); // Esto te mostrará el error real en la consola
            }
        } else {
            lblError.setVisible(true);
        }
    }
}
