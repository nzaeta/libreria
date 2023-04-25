/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria.servicios;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java_jpa_libreria.entidades.Cliente;
import java_jpa_libreria.entidades.Libro;
import java_jpa_libreria.entidades.Prestamo;
import java_jpa_libreria.persistencia.LibroDAO;

import java_jpa_libreria.persistencia.PrestamoDAO;

/**
 *
 * @author NICO
 */
public class PrestamoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");   
    private PrestamoDAO DAO;
    private LibroDAO DAOl;    
    ClienteService cs = new ClienteService();
    LibroService ls = new LibroService(); 

    public PrestamoService() {
        this.DAO = new PrestamoDAO();  
        this.DAOl = new LibroDAO();        
    }    
    
    
    
    public void BuscarPorCliente(){
        try {
            System.out.println("INGRESE UN NOMBRE DE CLIENTE o parte del mismo: ");
            String cliente = leer.next();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            List<Prestamo> prestamos = DAO.listarPorCliente(cliente);
            for (Prestamo aux : prestamos) {
                System.out.println(aux.toString());
            }
            if (prestamos.isEmpty()) {
                System.out.println("NO SE ENCONTRARON PRÉSTAMOS A ESE CLIENTE");
            }
            System.out.println("===========================");           
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    
    public void CrearPrestamo(){

        try {
            ls.ListarLibros();
            //System.out.println("INGRESE UN ISBN DE LIBRO");
            //long isbn = leer.nextLong();
            Libro libro = ls.BuscarPorIsbn();
            
            if (libro.getEjemplaresRestantes() ==0){
                System.out.println("NO HAY EJEMPLARES DISPONIBLES DE ESE LIBRO");
            } else{
            
            
            List<Cliente> clientes = cs.ListarClientes();
            System.out.println("INGRESE UN ID DE CLIENTE");
            int numcli = leer.nextInt();         
            
            if (numcli < 1 || numcli > (clientes.size()+1)) {
                throw new Exception("Debe ingresar un número del listado");  
            }
            
            if (!clientes.get(numcli-1).isAlta()) {
                throw new Exception("Ese cliente no está activo");
            }               
            
            Cliente cliente = clientes.get(numcli-1);
            Date fechap;
            Date fechad;           
            Date fechahoy = new Date();
            System.out.println("INGRESE FECHA DEL PRÉSTAMO (MM/DD/AAAA): ");
            try {
                fechap = new Date(leer.next());                  
            } catch (Exception e) {
                throw new Exception("Formato de fecha inválido");
            }
            
            if (fechap.after(fechahoy)) {
                throw new Exception("La fecha del préstamo no puede ser posterior a la fecha de hoy");                    
            }
                
            
            System.out.println("INGRESE FECHA DE DEVOLUCIÓN (MM/DD/AAAA): ");
            
            try {
                fechad = new Date(leer.next());              
            } catch (Exception e) {
                throw new Exception("Formato de fecha inválido");
            }
            
            if (fechad.before(fechahoy)) {
                throw new Exception("La fecha de devolución no puede ser anterior a la fecha de hoy");                    
            }
            if (fechad.before(fechap)) {
                throw new Exception("La fecha de devolución no puede ser anterior a la fecha de préstamo");                    
            }  
                             
            libro.prestarlibro();            
            DAOl.editar(libro);
            
            Prestamo prestamo = new Prestamo(fechap, fechad, libro, cliente);
            DAO.guardar(prestamo);
            
            System.out.println("PRÉSTAMO REGISTRADO");
            
            }
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }

    public void DevolverLibro(){
        try {
            System.out.println("INGRESE UN NOMBRE DE CLIENTE o parte del mismo: ");
            String cliente = leer.next();
            
            System.out.println("RESULTADO DE LA BÚSQUEDA: ");
            List<Prestamo> prestamos = DAO.listarPorCliente(cliente);
            int i=1;
            for (Prestamo aux : prestamos) {
                System.out.println(i + " - " + aux.getLibro().getTitulo());
                i ++;
            }
            
            if (prestamos.isEmpty()) {
                System.out.println("NO SE ENCONTRARON PRÉSTAMOS A ESE CLIENTE");
            }else{
            
            System.out.println("Ingrese un número de libro del listado");
            int prest = leer.nextInt();
            
            if (prest < 1 || prest > (prestamos.size()+1)) {
                throw new Exception("Debe ingresar un número del listado");  
            }

            Prestamo prestamo = prestamos.get(prest-1); 
            
                if (prestamo.isDevuelto()) {
                    System.out.println("ESE LIBRO YA FUE DEVUELTO");
                }else{
                    System.out.println("LIBRO DEVUELTO");
                    prestamo.setDevuelto(true);
                    prestamo.getLibro().devolverlibro();
                    
                    DAOl.editar(prestamo.getLibro());
                    DAO.editar(prestamo);
                    
                }
            
            
            
            System.out.println("===========================");
            }
        }catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un número entero"); 
            leer.next();              
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    
    
    
    
}
