package java_jpa_libreria.servicios;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java_jpa_libreria.entidades.Autor;
import java_jpa_libreria.persistencia.AutorDAO;

public class AutorService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");   
    private final AutorDAO DAO;

    public AutorService() {
        this.DAO = new AutorDAO();  
    }
    
    public void CrearAutor(){

        try {
            System.out.println("INGRESE NOMBRE DEL AUTOR que NO figure en la lista: ");
            List<Autor> autores =  ListarAutores();            
            String nombre = leer.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }      
            
            if (nombre.length() < 2) { 
                throw new Exception("Debe ingresar un nombre válido");
            }
            

            for (Autor aux : autores) {
                if (aux.getNombre().equalsIgnoreCase(nombre)) {
                    throw new Exception("Ya existe un autor con ese nombre");
                }
            }
            
            Autor autor = new Autor(nombre);
            DAO.guardar(autor);
            System.out.println("AUTOR CARGADO EN LA BASE DE DATOS");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }

    
    public List<Autor> ListarAutores(){
        try {
            System.out.println("LISTADO DE AUTORES: ");
            List<Autor> autores = DAO.listarTodos();
            
            if (autores.isEmpty()) {
                throw new Exception("No hay autores Ingresados");               
            }
            
            
            for (Autor aux : autores) {
                System.out.println(aux.toString());
            }
            System.out.println("===========================");
            return autores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
        
    public void BuscarPorNombre(){
        try {
            System.out.println("INGRESE UN NOMBRE: ");
            String nombre = leer.next();
            
            if (nombre.length() < 2) { 
                throw new Exception("Debe ingresar al menos 2 caracteres");
            }
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            List<Autor> autores = DAO.buscarPorNombre(nombre);
            for (Autor aux : autores) {
                System.out.println(aux.toString());
            }
            if (autores.isEmpty()) {
                System.out.println("NO SE ENCONTRARON AUTORES CON ESE NOMBRE");
            }
            System.out.println("===========================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    
    public void CambiarEstado(){
        try {
            System.out.println("INGRESE EL ID DEL AUTOR: ");
            int id = leer.nextInt();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Autor autor = DAO.buscarPorId(id);
            System.out.println(autor.toString());
            
            if (autor.isAlta()) {
                System.out.println("El autor fue dado de baja");
                autor.setAlta(false);
            }else{
                System.out.println("El autor fue dado de alta");                
                autor.setAlta(true);
            }
            DAO.editar(autor);    
            System.out.println(autor.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();          
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON AUTORES CON ESE ID");            
            System.out.println("===========================");            
        }
    }   
    
    public void Modificar(){
        try {
            System.out.println("INGRESE EL ID DEL AUTOR: ");
            int id = leer.nextInt();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Autor autor = DAO.buscarPorId(id);
            System.out.println(autor.toString());
            
            System.out.println("INGRESE NOMBRE CORRECTO");
            String nombre = leer.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }      
            
            if (nombre.length() < 2) { 
                throw new Exception("Debe ingresar un nombre válido");
            }            
            
            
            
            autor.setNombre(nombre);
            System.out.println("DATOS DEL AUTOR ACTUALIZADOS");
            
            DAO.editar(autor);    
            System.out.println(autor.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();              
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON AUTORES CON ESE ID");            
            System.out.println("===========================");            
        }
    }       
    
}
    
