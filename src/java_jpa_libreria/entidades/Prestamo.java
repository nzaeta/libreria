
package java_jpa_libreria.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prestamo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @OneToOne
    private Libro libro;
    @OneToOne
    private Cliente cliente;
    @Column
    private boolean devuelto;

    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
        devuelto = false;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public String toString() {
        String fechap = fechaPrestamo.getDate() + "-" + fechaPrestamo.getMonth() + "-" + (fechaPrestamo.getYear()+1900);
        String fechad = fechaDevolucion.getDate() + "-" + fechaDevolucion.getMonth() + "-" + (fechaDevolucion.getYear()+1900);          
        String dev;
        
        if (devuelto) {
             dev = "Sí";
            
        }else{
             dev = "No"; 
        }
        
        
        return id + " - " + cliente.getApellido() + ", " + cliente.getNombre() + " desde: " + fechap + " a: " + fechad + " | " + libro.getTitulo() + " | Devuelto: " + dev;
    }
    
    
    
    
    
    
    
}
