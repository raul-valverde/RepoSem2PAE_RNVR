package ni.edu.uam.registro_app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ni.edu.uam.registro_app.dao.EstudianteDao;
import ni.edu.uam.registro_app.modelos.Estudiante;

import java.time.LocalDate;
import java.util.List;

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

    //Agrego los nuevos controlers solicitados (combobox, list view y radio button)
    @FXML
    private ComboBox<String> cmbFacultad;
    @FXML
    private RadioButton rbManagua;
    @FXML
    private RadioButton rbVirtual;
    @FXML
    private ListView<String> lvClubes;

    //para que inicie al abrir el formulario
    @FXML
    public void iniciarform(){
        cmbFacultad.getItems().addAll("FIA","FCAE","FCM","FO","FMDCC","College");
        lvClubes.getItems().addAll("Club Ambiental","Club de lectura","Club Empresarial");
        lvClubes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


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

        //Agregamos los nuevos
        String modalidad = rbManagua.isSelected() ? "Managua" : "Virtual";
        List<String> actividades = lvClubes.getSelectionModel().getSelectedItems();

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

        //Limpiar el combo box
        cmbFacultad.setValue(null);
        //limpiar List view
        lvClubes.getSelectionModel().clearSelection();
        //Limpiar radio buttons

    }

}
