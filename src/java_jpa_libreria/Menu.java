/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria;

import java.util.Scanner;
import java_jpa_libreria.servicios.AutorService;
import java_jpa_libreria.servicios.ClienteService;
import java_jpa_libreria.servicios.EditorialService;
import java_jpa_libreria.servicios.LibroService;
import java_jpa_libreria.servicios.PrestamoService;

/**
 *
 * @author NICO
 */
public class Menu {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorService as = new AutorService();
    EditorialService es = new EditorialService();
    LibroService ls = new LibroService();
    ClienteService cs = new ClienteService();
    PrestamoService ps = new PrestamoService();
    
        
    public void menu(){
        System.out.println("");
        System.out.println("----- MENU -----");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Listar Autores / 2. Listar Editoriales / 3. Listar Libros"); 
        System.out.println("4. Nuevo Autor / 5. Nueva Editorial / 6. Nuevo Libro");

        System.out.println("7. Buscar autor por nombre");   
        System.out.println("8. Buscar Libro por ISBN / 9. Por Título / 10. Por Autor / 11. Por Editorial");    
        System.out.println("Cambiar estado (alta/baja) de 12. Autor / 13. Editorial / 14. Libro");        
        System.out.println("15. Modificar Autor / 16. Modificar Editorial / 17. Modificar Libro");
        
        
//        System.out.println("1. Listar todos los Autores");
//        System.out.println("2. Listar todas las Editoriales");
//        System.out.println("3. Listar todos los Libros");
//        System.out.println("4. Nuevo Autor");
//        System.out.println("5. Nueva Editorial");
//        System.out.println("6. Nuevo Libro");
////        System.out.println("7. Buscar autor por nombre");
////        System.out.println("8. Buscar libro por ISBN");
////        System.out.println("9. Buscar libro por Título");        
////        System.out.println("10. Buscar libro por Autor");         
////        System.out.println("11. Buscar libro por Editorial"); 

////        System.out.println("12. Cambiar estado de Autor (alta/baja)");        
////        System.out.println("13. Cambiar estado de Editorial (alta/baja)");         
////        System.out.println("14. Cambiar estado de Libro (alta/baja)");         
////        System.out.println("15. Modificar Autor");
////        System.out.println("16. Modificar Editorial");
////        System.out.println("17. Modificar Libro");
        System.out.println("18. Nuevo Cliente");
        System.out.println("19. Listar todos los Clientes");
        System.out.println("20. Cambiar estado de Cliente (alta/baja)");        
        System.out.println("21. Buscar Préstamos por Cliente");        
        System.out.println("22. Nuevo Préstamo");        
        System.out.println("23. Devolver Libro");       
        System.out.println("30. Salir del programa");
        System.out.println("");
        String opc = leer.next();
        switch (opc) {
            case "1":
                try {
                    as.ListarAutores();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "2":
                try {
                    es.ListarEditoriales();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "3":
                try {
                    ls.ListarLibros();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "4":
                try {
                    as.CrearAutor();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "5":
                try {
                    es.CrearEditorial();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "6":
                try {
                    ls.CrearLibro();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "7":
                try {
                    as.BuscarPorNombre();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;
            case "8":
                try {
                    ls.BuscarPorIsbn();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "9":
                try {
                    ls.BuscarPorTitulo();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "10":
                try {
                    ls.BuscarPorAutor();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "11":
                try {
                    ls.BuscarPorEditorial();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "12":
                try {
                    as.CambiarEstado();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "13":
                try {
                    es.CambiarEstado();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "14":
                try {
                    ls.CambiarEstado();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "15":
                try {
                    as.Modificar();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                  
            case "16":
                try {
                    es.Modificar();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                  
            case "17":
                try {
                    ls.Modificar();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
            case "18":
                try {
                    cs.CrearCliente();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                 
            case "19":
                try {
                    cs.ListarClientes();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                 
            case "20":
                try {
                    cs.CambiarEstado();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                
            case "21":
                try {
                    ps.BuscarPorCliente();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                  
            case "22":
                try {
                    ps.CrearPrestamo();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;                  
            case "23":
                try {
                    ps.DevolverLibro();
                 } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                  }
                menu();
                break;  
                
                
                
            case "30":
                System.out.println("Ejecución finalizada");
                break;                  
            default:
                System.out.println("Opción no válida");
                ;
                menu();
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
