/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria.servicios;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java_jpa_libreria.entidades.Cliente;
import java_jpa_libreria.persistencia.ClienteDAO;

/**
 *
 * @author NICO
 */
public class ClienteService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");   
    private final ClienteDAO DAO;

    public ClienteService() {
        this.DAO = new ClienteDAO();  
    }    
    
    public void CrearCliente(){

        try {
            System.out.println("INGRESE DNI DEL CLIENTE");
            long dni = leer.nextLong();            
            
            List<Cliente> clientes = BuscaClientes();
            if (clientes.get(0).getDocumento() == dni) {
                throw new Exception("Ya existe un cliente con ese DNI");                
            }
            
            System.out.println("INGRESE NOMBRE DEL CLIENTE");
            String nombre = leer.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }               
            

            System.out.println("INGRESE APELLIDO DEL CLIENTE");
            String apellido = leer.next();
            
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe indicar el apellido");
            }               
            
            System.out.println("INGRESE TELÉFONO DEL CLIENTE");
            String tel = leer.next();            
            
            Cliente cliente = new Cliente(dni, nombre, apellido, tel);
            
            DAO.guardar(cliente);
            System.out.println("CLIENTE CARGADO EN LA BASE DE DATOS");
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }    
    
    public List<Cliente> ListarClientes(){
        try {
            System.out.println("LISTADO DE CLIENTES: ");
            List<Cliente> clientes = DAO.listarTodos();
            
            if (clientes.isEmpty()) {
                throw new Exception("No hay clientes Ingresados");               
            }
            
            
            
            for (Cliente aux : clientes) {
                System.out.println(aux.toString());
            }
            System.out.println("===========================");
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }        
    
    public List<Cliente> BuscaClientes(){
        try {

            List<Cliente> clientes = DAO.listarTodos();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
        
    public void CambiarEstado(){
        try {
            System.out.println("INGRESE EL ID DEL CLIENTE: ");
            int id = leer.nextInt();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            Cliente cliente = DAO.buscarPorId(id);
            System.out.println(cliente.toString());
            
            if (cliente.isAlta()) {
                System.out.println("El cliente fue dado de baja");
                cliente.setAlta(false);
            }else{
                System.out.println("El cliente fue dado de alta");                
                cliente.setAlta(true);
            }
            DAO.editar(cliente);    
            System.out.println(cliente.toString());         
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();                
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("NO SE ENCONTRARON CLIENTES CON ESE ID");            
            System.out.println("===========================");            
        }
    }      
    
    
}
