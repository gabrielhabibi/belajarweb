/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

/**
 *
 * @author dell
 */
public class Miniproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new koneksi().Connect();
        new start().setVisible(true);
    }
    
}
