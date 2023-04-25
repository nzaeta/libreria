
package java_jpa_libreria.entidades;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Libro {
   
    @Id
    private long isbn;
    private String titulo;
    private int anio;
    private int ejemplares;
    private int ejemplaresPrestados;   
    private int ejemplaresRestantes;          
    private boolean alta;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne    
    private Editorial editorial;

    public Libro() {
        alta = true;
    }

    public long getIsbn() {
        return isbn;
    }

    public Libro(long isbn, String titulo, int anio, int ejemplares, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.autor = autor;
        this.editorial = editorial;
        this.ejemplaresPrestados = 0;
        this.ejemplaresRestantes = ejemplares;
        alta = true;        
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public void prestarlibro() {
        ejemplaresPrestados ++;
        ejemplaresRestantes --;
    }    

    public void devolverlibro() {
        ejemplaresPrestados --;
        ejemplaresRestantes ++;
    }       
    
    public String getTitulo() {
        return titulo;
    }
    
    
    public int getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(int ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    
    
    
    @Override
    public String toString() {
        String activo;
        if (alta) {
            activo = "Activo";
        }else{
            activo = "Inactivo";
        }    
        
        return isbn + " - " + titulo + " | " + anio + " | Ejemplares: " + ejemplares + " | Prestados: " + ejemplaresPrestados + " | Disponibles: " + ejemplaresRestantes + " | " + activo + " | Autor: " + autor.getNombre() + " | Editorial: " + editorial.getNombre();
    }
    
    
    
    
    
    
    
}
