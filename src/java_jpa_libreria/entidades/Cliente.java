package java_jpa_libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private boolean alta;

    public Cliente() {
        alta = true;
    }
    
    public Cliente(long documento, String nombre, String apellido, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        alta = true;
    }

    public long getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        String activo;
        if (alta) {
            activo = "Activo";
        }else{
            activo = "Inactivo";
        }        
        return  id + " | DNI: " + documento + " | " + apellido + ", " + nombre + " | Tel: " + telefono + " | " + activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    
    
}
