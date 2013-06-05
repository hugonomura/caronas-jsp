/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author hugo
 */
public class TesteBD {
    //Objeto que guarda informacoes da conexao com o SGBD.
    private Connection conn;
    //Objeto usado para enviar comandos SQL no SGBD
    private Statement stmt;

    public TesteBD() {

        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://shelton.sor.ufscar.br:1433;database=disciplinabd";
            String usuario = "professorbd", senha = "professorbd";
            conn = DriverManager.getConnection(conexao, usuario, senha);
            stmt = conn.createStatement();

            System.out.println("Conexão OK!!!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro");
        }

    }

    public static void main(String args[]) {
        TesteBD t = new TesteBD();
    }
}
