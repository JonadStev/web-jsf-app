package com.demo.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class RegistroBean implements Serializable {

    RegistroService registroService = new RegistroService();;
    private String id;
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String direccion;

    private List<Registro> registros = new ArrayList<>();
    private Registro registroSeleccionado;

    public RegistroBean() {
        cargarRegistros(); // Llama al método en el constructor
    }

    public void cargarRegistros() {
        try {
            this.registros = registroService.listarRegistros();
        }catch (Exception e){
            System.out.println("ERROR DE SERVIDOR "+e.getMessage());
        }

    }

    public void crearRegistro() {

        try {
            Registro nuevoRegistro =  registroService.crearRegistro(new Registro(this.id, this.nombre, this.apellidos, this.identificacion, this.correo, this.direccion));
            cargarRegistros();
            this.id = null;
            this.nombre = null;
            this.apellidos = null;
            this.identificacion = null;
            this.correo = null;
            this.direccion = null;
        }catch (Exception e){
            System.out.println("ERROR AL CREAR REGISTRO "+e.getMessage());
        }
    }

    public void eliminarRegistro(Registro registro){
        if (registro != null) {
            try {
                registroService.eliminarRegistro(Integer.parseInt(registro.getId()));
                cargarRegistros();
            }catch (Exception e){
                System.out.println("ERROR AL ELIMINAR REGISTRO "+e.getMessage());
            }

        }
    }
    public void seleccionarRegistro(Registro registro) {
        this.id = registro.getId();
        this.nombre = registro.getNombre();
        this.apellidos = registro.getApellidos();
        this.identificacion = registro.getIdentificacion();
        this.correo = registro.getCorreo();
        this.direccion = registro.getDireccion();
    }

    public Registro getRegistroSeleccionado(){
        return this.registroSeleccionado;
    }

    public void setRegistroSeleccionado(Registro registroSeleccionado){
        this.registroSeleccionado = registroSeleccionado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Registro> getRegistros() {
        return registros;
    }


}
