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
    public void initialize(){
        cmbFacultad.getItems().addAll("FIA", "FCAE", "FCM", "FO", "FMDCC", "College");
        lvClubes.getItems().addAll("Club Ambiental", "Club de lectura", "Club Empresarial");
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

    private void leerDatos() {
        String nombre = txtNombres.getText();
        String apellido = txtApellidos.getText();
        String carrera = txtCarrera.getText();
        LocalDate fechaNac = dpFechaNac.getValue();
        Boolean tieneBeca = chkTieneBeca.isSelected();
        String facultad = cmbFacultad.getValue();
        // Captura de los nuevos controles
        String modalidad = rbManagua.isSelected() ? "Managua" : "Virtual";
        List<String> actividades = lvClubes.getSelectionModel().getSelectedItems();

        // AQUÍ ESTÁ EL CAMBIO: pasa los 7 parámetros al constructor
        agregarDatos(new Estudiante(nombre, apellido, carrera, fechaNac, tieneBeca, facultad, modalidad, actividades));
    }

    private void agregarDatos(Estudiante estudiante){
        listado.agregar(estudiante);

    }

    private void contarRegistros(){
        lblRegistros.setText("Registros almacenados : " + listado.obtenerRegistros().size());
    }

    //Se agrega con clear par que limpie cada que le de click al boton se agrega y se limpia pero lo cuenta
    private void limpiarFormulario() {
        txtNombres.clear();
        txtApellidos.clear();
        txtCarrera.clear();
        dpFechaNac.setValue(null);
        chkTieneBeca.setSelected(false);
        cmbFacultad.setValue(null);
        lvClubes.getSelectionModel().clearSelection();

        // Desmarcar RadioButtons
        rbManagua.setSelected(false);
        rbVirtual.setSelected(false);
    }

}
