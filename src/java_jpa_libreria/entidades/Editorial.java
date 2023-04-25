
package java_jpa_libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editorial {
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private boolean alta;  

    public Editorial() {
        alta = true; 
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
        alta = true; 
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    @Override
    public String toString() {
        String activo;
        if (alta) {
            activo = "Activo";
        }else{
            activo = "Inactivo";
        }
        return id + " - " + nombre + " | " + activo;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
