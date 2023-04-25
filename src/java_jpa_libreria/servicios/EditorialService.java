package java_jpa_libreria.servicios;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java_jpa_libreria.entidades.Editorial;
import java_jpa_libreria.persistencia.EditorialDAO;

public class EditorialService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final EditorialDAO DAO;

    public EditorialService() {
        this.DAO = new EditorialDAO();  
    } 
    
    public void CrearEditorial(){

        try {
            System.out.println("INGRESE NOMBRE DE LA EDITORIAL que NO figure en la lista: ");
            List<Editorial> editoriales =  ListarEditoriales();            
            String nombre = leer.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }            
            if (nombre.length() < 2) { 
                throw new Exception("Debe ingresar un nombre válido");
            }
            

            for (Editorial aux : editoriales) {
                if (aux.getNombre().equalsIgnoreCase(nombre)) {
                    throw new Exception("Ya existe una editorial con ese nombre");
                }
            }            
            
            
            Editorial editorial = new Editorial(nombre);
            DAO.guardar(editorial);
            System.out.println("EDITORIAL CARGADA EN LA BASE DE DATOS");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
    
    public List<Editorial> ListarEditoriales(){
        try {
            System.out.println("LISTADO DE EDITORIALES: ");
            List<Editorial> editoriales = DAO.listarTodos();
            
            if (editoriales.isEmpty()) {
                throw new Exception("No hay editoriales Ingresadas");               
            }               
            
            for (Editorial aux : editoriales) {
                System.out.println(aux.toString());
            }
            System.out.println("===========================");
            return editoriales;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  
    
    public void CambiarEstado(){
        try {
            System.out.println("INGRESE EL ID DE LA EDITORIAL: ");
            int id = leer.nextInt();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Editorial editorial = DAO.buscarPorId(id);
            System.out.println(editorial.toString());
            
            if (editorial.isAlta()) {
                System.out.println("La editorial fue dada de baja");
                editorial.setAlta(false);
            }else{
                System.out.println("La editorial fue dada de alta");                
                editorial.setAlta(true);
            }
            DAO.editar(editorial);    
            System.out.println(editorial.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();              
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON EDITORIALES CON ESE ID");            
            System.out.println("===========================");            
        }
    }   
    
    public void Modificar(){
        try {
            System.out.println("INGRESE EL ID DE LA EDITORIAL: ");
            int id = leer.nextInt();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Editorial editorial = DAO.buscarPorId(id);
            System.out.println(editorial.toString());
            
            System.out.println("INGRESE NOMBRE CORRECTO");
            String nombre = leer.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }            
            if (nombre.length() < 2) { 
                throw new Exception("Debe ingresar un nombre válido");
            }
            
            editorial.setNombre(nombre);
            System.out.println("DATOS DE LA EDITORIAL ACTUALIZADOS");
            
            DAO.editar(editorial);    
            System.out.println(editorial.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();                
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON EDITORIALES CON ESE ID");            
            System.out.println("===========================");            
        }
    }   
    
 
}
