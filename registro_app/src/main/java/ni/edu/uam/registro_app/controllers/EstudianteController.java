package ni.edu.uam.registro_app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ni.edu.uam.registro_app.dao.EstudianteDao;
import ni.edu.uam.registro_app.modelos.Estudiante;

import java.time.LocalDate;

public class EstudianteController {
    EstudianteDao listado = new EstudianteDao();

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtCarrera;
    @FXML
    private DatePicker dpFechaNac;
    @FXML
    private CheckBox chkTieneBeca;
    @FXML
    private Label lblRegistros;

    //metodo
    @FXML
    protected void guardarOnClick(){
        leerDatos();
        contarRegistros();

        //Agregamos el metodo de limpiar
        limpiarFormulario();
    }

    private void leerDatos(){
        String nombre = txtNombres.getText();
        String apellido = txtApellidos.getText();
        String carrera = txtCarrera.getText();
        LocalDate fechaac = dpFechaNac.getValue();
        Boolean tieneBeca = chkTieneBeca.isSelected();
        agregarDatos(new Estudiante(nombre,apellido,carrera,fechaac,tieneBeca));
    }

    private void agregarDatos(Estudiante estudiante){
        listado.agregar(estudiante);

    }

    private void contarRegistros(){
        lblRegistros.setText("Registros almacenados : " + listado.obtenerRegistros().size());
    }

    //Se agrega con clear par que limpie cada que le de click al boton se agrega y se limpia pero lo cuenta
    private void limpiarFormulario() {
        // Vaciar cajas de texto (TextField)
        txtNombres.clear();       // O txtNombre.setText("");
        txtApellidos.clear();

        //Limpia la carrea
        txtCarrera.clear();

        // Resetear el DatePicker
        dpFechaNac.setValue(null);

        // Desmarcar el CheckBox
        chkTieneBeca.setSelected(false);
    }

}
