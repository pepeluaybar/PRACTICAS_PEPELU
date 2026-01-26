/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaej2;

/**
 *
 * @author EAG
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta cu1 = new Cuenta();
        cu1.setSaldo(100);
        cu1.setnIdent(0);
        Cliente cli = new Cliente();
        cli.setAccount(cu1);
        
        cli.ingresarSaldo(100, cu1.getSaldo());
        
        cli.consultarSaldo(cu1.getSaldo());
        
    }
}
