package ni.edu.uam.sesion4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ni.edu.uam.sesion4.DAO.GradeDao;
import ni.edu.uam.sesion4.models.Student;

import java.lang.invoke.StringConcatFactory;

public class GradeController {
    GradeDao grades = new GradeDao();
    //Llamamos a los elementos que tenemos en la interfaz grafica
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMajor;

    @FXML
    private TextField txtGrade;

    @FXML
    private Label lblCount;

    @FXML
    private Button btnSave;

    //Para la accion del boton
    @FXML
    protected void saveButtonAction(){
 addGrade();
 countGrade();
    }

    //Primero agregamos notas
    private void addGrade(){
    String name= txtName.getText();
    String major= txtMajor.getText();
    int grade = Integer.parseInt(txtGrade.getText());
    saveGrade(new Student(name,major,grade));
    }

    private void saveGrade(Student student){
        grades.addGrade(student);
    }

    private void countGrade(){
        lblCount.setText("Registros guardados : " + grades.getGrades().size());
    }
}
