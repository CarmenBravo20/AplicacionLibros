/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.main;

import ec.edu.ups.controlador.ControladorClientes;
import ec.edu.ups.controlador.ControladorLibroDigital;
import ec.edu.ups.controlador.ControladorLibroImpreso;
import ec.edu.ups.controlador.ControladorCredito;
import ec.edu.ups.modelo.Clientes;
import ec.edu.ups.modelo.Credito;
import ec.edu.ups.modelo.Libros;
import ec.edu.ups.modelo.LibrosDigitales;
import ec.edu.ups.modelo.LibrosImpreso;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class PracticaIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner l=new Scanner(System.in);
        String z="";
        boolean repetir =true;
        ControladorLibroImpreso controladorLibroImpreso = new ControladorLibroImpreso();
        ControladorLibroDigital controladorLibroDigital = new ControladorLibroDigital();
        ControladorClientes controladorClientes = new ControladorClientes();
        ControladorCredito controladorCredito= new ControladorCredito();
        
        
         do {
        System.out.println("Digite la opcion que desea realizar?");
        System.out.println("1. CRUD LIBRO");
        System.out.println("2. CRUD CLIENTES");
         System.out.println("3. Credito Saldo");
        System.out.println("4. Salir");
            int x= l.nextInt();

            switch (x) {

                case 1:
                    boolean repLibro = true;
                    do {
                       
                        System.out.println("MENU LIBRO");
                        System.out.println("1. Libro Digital");
                        System.out.println("2. Libro Impreso");
                        System.out.println("3. Regresar al menu principal");
                        System.out.println("Selecciona una opción");
                        int libro= l.nextInt();
                        switch (libro) {

                case 1:
                    boolean repLib = true;
                    do {
                        System.out.println("MENU Libro Digital");
                        System.out.println("1. Crear nuevo libro Digital ");
                        System.out.println("2. Buscar libro digital");
                        System.out.println("3. Actualizar libro digital");
                        System.out.println("4. Eliminar libro digital");
                        System.out.println("5. Listar libros digitales");
                        System.out.println("6.Precio total del Libro");
                        System.out.println("7.Regresar al menu principal");
                        System.out.println("Selecciona una opción");
                       int lib= l.nextInt();
                        switch (lib) {
                            case 1:
                                
                                System.out.println("Precio Establecido");
                                Double precio = l.nextDouble();
                                System.out.println("Código del libro:");
                                int codigo=l.nextInt();
                                System.out.println("Titulo del libro:");
                                String titulo=l.next();
                                System.out.println("Autor del libro:");
                                String autor=l.next();
                                System.out.println("Edición del Libro");
                                String edicion=l.next();
                                
                                LibrosDigitales objeto = new LibrosDigitales(precio, codigo, titulo, autor, edicion);
                                controladorLibroDigital.create(objeto);
                                break;
                           case 2:
                                System.out.println("Ingrese el código del Libro");
                                int cod1 = l.nextInt();
                                System.out.println(controladorLibroDigital.read(cod1));
                                break;
                            case 3:
                                //Double precio, Double comision, int codigo, String titulo, String autor, String edicion
                                System.out.println("Ingrese el código del  libro");
                                cod1 = l.nextInt();
                                if (controladorLibroDigital.read(cod1) != null) {
                                System.out.println("Precio Establecido");
                                 precio = l.nextDouble();  
                                System.out.println("Código del libro:");
                                 codigo=l.nextInt();
                                System.out.println("Titulo del libro:");
                                titulo=l.next();
                                System.out.println("Autor del libro:");
                                autor=l.next();
                                System.out.println("Edición del Libro");
                                edicion=l.next();
                                objeto = new LibrosDigitales(precio, codigo, titulo, autor, edicion);
                                objeto.setCodigo(cod1);
                                controladorLibroDigital.update(objeto);
                                } else {
                                    System.out.println("El Libro no existe");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese el código del libro  que va a eliminar");
                                cod1 = l.nextInt();
                                controladorLibroDigital.delete(cod1);
                                break;
                            case 5:
                                controladorLibroDigital.imprimir();
                                break;
                            case 6:
                                System.out.println("Ingrese el código del libro");
                                int codigolibro = l.nextInt();
                                LibrosDigitales librodig=controladorLibroDigital.read(codigolibro);
                                //System.err.print("Precio total del libro impreso:");
                                System.err.println("Precio total del libro impreso:"+librodig.getPrecioTotal());
                                break;
                            case 7:
                                repLib = false;
                                break;
                        }
                    } while (repLib);
                    break;
                case 2:
                    boolean repCliente = true;
                    do {
                        
                        System.out.println("MENU Libro Impreso");
                        System.out.println("1. Crear nuevo libro Impreso ");
                        System.out.println("2. Buscar libro Impreso");
                        System.out.println("3. Actualizar libro Impreso");
                        System.out.println("4. Eliminar libro Impreso");
                        System.out.println("5. Listar libros Impreso");
                        System.out.println("6.Precio Total del Libro");
                        System.out.println("7.Regresar al menu principal");
                        System.out.println("Selecciona una opción");
                       int lib= l.nextInt();
                        switch (lib) {
                            case 1: //Double precio, Double comision, Double costoEnvio, int codigo, String titulo, String autor, String edicion
                                System.out.println("Precio Establecido");
                                Double precio = l.nextDouble();
                                System.out.println("código del libro:");
                                int codigo=l.nextInt();
                                System.out.println("Titulo del libro:");
                                String titulo=l.next();
                                System.out.println("Autor del libro:");
                                String autor=l.next();
                                System.out.println("Edicción del Libro");
                                String edicion=l.next();
                                LibrosImpreso objeto = new LibrosImpreso(precio, codigo, titulo, autor, edicion);
                                controladorLibroImpreso.create(objeto);
                                break;
                           case 2:
                                System.out.println("Ingrese el código del Libro impreso");
                                int cod1 = l.nextInt();
                               System.out.println(controladorLibroImpreso.read(cod1));
                                break;
                            case 3:
                                System.out.println("Ingrese el código del  libro");
                                cod1 = l.nextInt();
                                if (controladorLibroImpreso.read(cod1) != null) {
                                System.out.println("Precio Establecido");
                                 precio = l.nextDouble();  
                                System.out.println("código del libro:");
                                 codigo=l.nextInt();
                                System.out.println("Titulo del libro:");
                                titulo=l.next();
                                System.out.println("Autor del libro:");
                                autor=l.next();
                                System.out.println("Ediccion del Libro");
                                edicion=l.next();
                                objeto = new LibrosImpreso(precio, codigo, titulo, autor, edicion);
                                objeto.setCodigo(cod1);
                                controladorLibroImpreso.update(objeto);
                                } else {
                                    System.out.println("El Libro no existe");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese el código del libro  que va a eliminar");
                                cod1 = l.nextInt();
                                controladorLibroImpreso.delete(cod1);
                                break;
                            case 5:
                                controladorLibroImpreso.imprimir();
                                break;
                            case 6:
                                System.out.println("Ingrese el código del libro");
                                int codigolibro = l.nextInt();
                                LibrosImpreso libroim=controladorLibroImpreso.read(codigolibro);
                                //System.err.print("Precio total del libro impreso:");
                                System.err.println("Precio total del libro impreso:"+libroim.getPrecioTotal());
                                //controladorLibroImpreso.imprimir();
                                break;
                            case 7:
                                repCliente = false;
                                break;
                        }
                    } while (repCliente);

                    break;
                
                case 3:
                    repetir = false;
            }
                    } while (repLibro);
                    break;
                case 2:
                    boolean repCliente = true;
                    do {
                        System.out.println("MENU CLIENTE");
                        System.out.println("1. Crear un nuveo Cliente ");
                        System.out.println("2. Buscar Cliente");
                        System.out.println("3. Actualizar");
                        System.out.println("4. Eliminar");
                        System.out.println("5. Listar");
                        System.out.println("6.Regresar al menu principal");
                        System.out.println("Selecciona una opción");
                       int cliente= l.nextInt();
                        switch (cliente) {
                            case 1:
                                System.out.println("Ingrese el código:");
                                int codigo = l.nextInt();
                                System.out.println("Ingrese el nombre:");
                                String nombre = l.next();
                                System.out.println("Ingrese el apellido:");
                                String apellido=l.next();
                                System.out.println("Ingrese la cédula:");
                                String cedula=l.next();
                                System.out.println("Ingrese  la Dirección:");
                                String direccion=l.next();
                                System.out.println("Ingrese el email:");
                                String email=l.next();
                                Clientes objeto = new Clientes(codigo, nombre, apellido, cedula, direccion, email);
                                controladorClientes.create(objeto);
                                break;
                           case 2:
                                System.out.println("Ingrese el código del Cliente");
                                int cod1 = l.nextInt();
                                System.out.println(controladorClientes.read(cod1));
                                break;
                            case 3:
                                System.out.println("Ingrese el código del Cliente");
                                cod1 = l.nextInt();
                                if (controladorClientes.read(cod1) != null) {
                                System.out.println("Ingrese el código:");
                                codigo = l.nextInt();  
                                System.out.println("Ingrese el nombre:");
                                nombre = l.next();
                                System.out.println("Ingrese el Apellido:");
                                apellido=l.next();
                                System.out.println("Ingrese la Cédula:");
                                cedula=l.next();
                                System.out.println("Ingrese  la Direccón:");
                                direccion=l.next();
                                System.out.println("Ingrese el email:");
                                email=l.next();
                                objeto = new Clientes(codigo, nombre, apellido, cedula, direccion, email);
                                objeto.setCodigo(cod1);
                                controladorClientes.update(objeto);
                                } else {
                                    System.out.println("El dato no existe");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese el código del dato  que va a eliminar");
                                cod1 = l.nextInt();
                                controladorClientes.delete(cod1);
                                break;
                            case 5:
                                controladorClientes.imprimir();
                                break;
                            case 6:
                                repCliente = false;
                                break;
                        }
                    } while (repCliente);

                    break;
                    //-------------------------------------------------------------------------------------------------------------------
                    case 3:
                    boolean reptar = true;
                    do {
                        System.out.println("MENU CREDITO");
                        System.out.println("1. Crear crédito");
                        System.out.println("2. Buscar crédito");
                        System.out.println("3. Actualizar");
                        System.out.println("4. Eliminar");
                        System.out.println("5. Listar");
                        System.out.println("6.Regresar al menu principal");
                        System.out.println("Selecciona una opción");
                       int credito= l.nextInt();
                        switch (credito) {
                            case 1:
                                // codigo, int saldo, int recarga
                                System.out.println("Ingrese el código:");
                                int codigo = l.nextInt();
                                System.out.println("Ingrese el saldo:");
                                int saldo = l.nextInt();
                                System.out.println("Ingrese  recarga:");
                                int  recarga=l.nextInt();
                                Credito objeto = new Credito(codigo, saldo,recarga);
                                controladorCredito.create(objeto);
                                break;
                           case 2:
                                System.out.println("Ingrese código de creditos");
                                int cod1 = l.nextInt();
                                System.out.println(controladorCredito.read(cod1));
                                break;
                            case 3:
                                System.out.println("Ingrese el código de el crédito");
                                cod1 = l.nextInt();
                                if (controladorCredito.read(cod1) != null) {
                                System.out.println("Ingrese el código:");
                                codigo = l.nextInt();  
                                System.out.println("Ingrese el saldo:");
                                saldo = l.nextInt();
                                System.out.println("Ingrese el recarga:");
                                recarga=l.nextInt();
                                double res=saldo+recarga;
                                System.err.println("saldo total"+res);
                                
                                objeto = new Credito(codigo, saldo, recarga);
                                objeto.setCodigo(cod1);
                                controladorCredito.update(objeto);
                                } else {
                                    System.out.println("El dato no existe");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese el código del dato  que va a eliminar");
                                cod1 = l.nextInt();
                                controladorCredito.delete(cod1);
                                break;
                            case 5:
                                controladorCredito.imprimir();
                                break;
                            case 6:
                                repCliente = false;
                                break;
                        }
                    } while (reptar);

                    break;
                    //-------------------------------------------------------------------------------------------------------------------                    //-------------------------------------------------------------------------------------------------------------------
                
                case 5:
                    repetir = false;
            }

        } while (repetir);
    }
    
}
