package java_jpa_libreria.servicios;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java_jpa_libreria.entidades.Autor;
import java_jpa_libreria.entidades.Editorial;
import java_jpa_libreria.entidades.Libro;
import java_jpa_libreria.persistencia.LibroDAO;

public class LibroService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final LibroDAO DAO;
    AutorService as = new AutorService();
    EditorialService es = new EditorialService();   
    
    public LibroService() {
        this.DAO = new LibroDAO();
    }  
    
    
    public List<Libro> ListarLibros(){
        try {
            System.out.println("LISTADO DE LIBROS: ");
            List<Libro> libros = DAO.listarTodos();
            
            if (libros.isEmpty()) {
                throw new Exception("No hay libros Ingresados");               
            }                         
            
            for (Libro aux : libros) {
                System.out.println(aux.toString());
            }
            System.out.println("===========================");
            return libros;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
    
    public void CrearLibro(){

        try {
            List<Autor> autores = as.ListarAutores();
            System.out.println("INGRESE UN ID DE AUTOR");
            int numautor = leer.nextInt();
            
            if (numautor < 1 || numautor > (autores.size()+1)) {
                throw new Exception("Debe ingresar un número del listado");  
            }
            
            if (!autores.get(numautor-1).isAlta()) {
                throw new Exception("Ese autor no está activo");
            }           
            
            Autor autor = autores.get(numautor-1);         
            
            List<Editorial> editoriales = es.ListarEditoriales();
            System.out.println("INGRESE UN ID DE EDITORIAL");
            int numedit = leer.nextInt();    
            
            if (numedit < 1 || numedit > (editoriales.size()+1)) {
                throw new Exception("Debe ingresar un número del listado");  
            }              
            
            if (!autores.get(numautor-1).isAlta()) {
                throw new Exception("Esa editorial no está activa");
            }               
   
            Editorial editorial = editoriales.get(numedit-1);
            
            System.out.println("INGRESE NÚMERO ISBN que NO figure en el listado: ");
            List<Libro> libros =  ListarLibros(); 
            long isbn = leer.nextLong();
            
           
            
            for (Libro aux : libros) {
                if (aux.getIsbn() == isbn) {
                    throw new Exception("Ya existe un libro con ese ISBN");
                }
            }                
            
            System.out.println("INGRESE TÍTULO DEL LIBRO");
            String titulo = leer.next();

            if (titulo.length() < 2) { 
                throw new Exception("Debe ingresar un nombre válido");
            }
            

            for (Libro aux : libros) {
                if (aux.getTitulo().equalsIgnoreCase(titulo)) {
                    throw new Exception("Ya existe un libro con ese título");
                }
            }                      
            
            System.out.println("INGRESE AÑO DE PUBLICACIÓN AAAA");
            int anio = leer.nextInt();
            
            if (anio < 1850 && anio > 2022) {
                System.out.println("Debe ingresar un año válido con formato AAAA");
            }          
            
            System.out.println("INGRESE NÚMERO DE EJEMPLARES");
            int ejemplares = leer.nextInt();
                       
            Libro libro = new Libro(isbn, titulo, anio, ejemplares, autor, editorial);
            DAO.guardar(libro);
            System.out.println("LIBRO CARGADO EN LA BASE DE DATOS");
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
        
    public Libro BuscarPorIsbn(){
        try {
            System.out.println("INGRESE EL ISBN DEL LIBRO: ");
            long isbn = leer.nextLong();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Libro libro = DAO.buscarPorId(isbn);
            System.out.println(libro.toString());
            return libro;
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();   
            return null;            
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON LIBROS CON ESE ISBN");            
            System.out.println("==========================="); 
            return null;
        }
    }     
    
    public void BuscarPorTitulo(){
        try {
            System.out.println("INGRESE UN TÍTULO o parte del mismo: ");
            String titulo = leer.next();
            
            if (titulo.length() < 3) { 
                throw new Exception("Debe ingresar al menos dos caracteres");
            }
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            List<Libro> libros = DAO.buscarPorTitulo(titulo);
            for (Libro aux : libros) {
                System.out.println(aux.toString());
            }
            if (libros.isEmpty()) {
                System.out.println("NO SE ENCONTRARON LIBROS CON ESE TÍTULO");
            }
            System.out.println("===========================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }   

    public void BuscarPorAutor(){
        try {
            System.out.println("INGRESE UN NOMBRE DE AUTOR o parte del mismo: ");
            String autor = leer.next();
            
            if (autor.length() < 3) { 
                throw new Exception("Debe ingresar al menos dos caracteres");
            }            
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            List<Libro> libros = DAO.buscarPorAutor(autor);
            for (Libro aux : libros) {
                System.out.println(aux.toString());
            }
            if (libros.isEmpty()) {
                System.out.println("NO SE ENCONTRARON LIBROS DE ESE AUTOR");
            }
            System.out.println("===========================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }  
    
    
    public void BuscarPorEditorial(){
        try {
            System.out.println("INGRESE UN NOMBRE DE EDITORIAL o parte del mismo: ");
            String editorial = leer.next();
            
            if (editorial.length() < 3) { 
                throw new Exception("Debe ingresar al menos dos caracteres");
            }                 
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            List<Libro> libros = DAO.buscarPorEditorial(editorial);
            for (Libro aux : libros) {
                System.out.println(aux.toString());
            }
            if (libros.isEmpty()) {
                System.out.println("NO SE ENCONTRARON LIBROS DE ESA EDITORIAL");
            }
            System.out.println("===========================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }  
    
    public void CambiarEstado(){
        try {
            System.out.println("INGRESE EL ISBN DEL LIBRO: ");
            long isbn = leer.nextLong();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Libro libro = DAO.buscarPorId(isbn);
            System.out.println(libro.toString());
            
            if (libro.isAlta()) {
                System.out.println("La editorial fue dada de baja");
                libro.setAlta(false);
            }else{
                System.out.println("La editorial fue dada de alta");                
                libro.setAlta(true);
            }
            DAO.editar(libro);    
            System.out.println(libro.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();               
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON LIBROS CON ESE ISBN");            
            System.out.println("===========================");            
        }
    }   
    
    public void Modificar(){
        try {
            System.out.println("INGRESE EL ISBN DEL LIBRO: ");
            long isbn = leer.nextLong();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Libro libro = DAO.buscarPorId(isbn);
            System.out.println(libro.toString());
            
            System.out.println("INGRESE TÍTULO CORRECTO DEL LIBRO");
            String titulo = leer.next();
            
            System.out.println("INGRESE AÑO DE PUBLICACIÓN");
            int anio = leer.nextInt();
            
            libro.setAnio(anio);
            libro.setTitulo(titulo);   
            
            System.out.println("DATOS DEL LIBRO ACTUALIZADOS");            
            
            DAO.editar(libro);    
            System.out.println(libro.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();              
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON LIBROS CON ESE ISBN");            
            System.out.println("===========================");            
        }
    }       
    
    
    
    
    
    
}
