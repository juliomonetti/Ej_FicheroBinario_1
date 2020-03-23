/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ej_ficherobinario_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class AdminFichero {
    public void Grabar(){  
        
        
        Scanner sc = new Scanner(System.in);  //configura lectura de teclado
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;

        try {
            fos = new FileOutputStream("d:/datos.dat");
            salida = new DataOutputStream(fos);

            System.out.print("Ingrese número entero. -1 para terminar: ");
            n = sc.nextInt(); //lee dese teclado
            
            while (n != -1) {
                salida.writeInt(n); //se escribe el número entero en el fichero
                System.out.print("Ingrese número entero. -1 para terminar: ");
                n = sc.nextInt();  //lee desde teclado
            }
            
            
        } catch (Exception e) {        } 
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (Exception e) {            }
        }
    
    
    
    }
    
    
    public void Leer(){
    
     FileInputStream fis = null;
        DataInputStream entrada = null;
        int n;
        try {
            fis = new FileInputStream("d:/datos.dat");
            entrada = new DataInputStream(fis);
            while (true) {   
                n = entrada.readInt();  //se lee  un entero del fichero
                System.out.println(n);  //se muestra en pantalla
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
