/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author hugo
 */
public class CaronasDAOException  extends Exception {
    public CaronasDAOException(){ }

        public CaronasDAOException(String arg){
                super(arg);
        }

        public CaronasDAOException(Throwable arg){
                super(arg);
        }

        public CaronasDAOException(String arg,Throwable arg1){
                super(arg,arg1);
        }
}
