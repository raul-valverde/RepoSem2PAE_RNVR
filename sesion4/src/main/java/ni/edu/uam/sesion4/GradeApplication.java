package ni.edu.uam.sesion4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GradeApplication extends Application {
    public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(GradeApplication.class.getResource("grades-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Universidad Americana");
        stage.setScene(scene);
        stage.show();
}
}

