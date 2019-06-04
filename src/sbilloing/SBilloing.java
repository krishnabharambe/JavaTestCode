/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbilloing;

import Database.db;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class SBilloing {

    public SBilloing() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        db.setdata("Create table IF NOT EXISTS userManager(id integer primary key autoincrement, loginId text, Authcode text, dated_on text,updated_on text,timestamp text)");
        db.setdata("Create table IF NOT EXISTS custManager(id integer primary key autoincrement,name text,GSTIN text,mobilecontact text,Email text,Address text)");
   
    
    new Login.Login().setVisible(true);

//        db.setdata("Create table employee(id integer primary key autoincrement,EmpId integer,Name text,Salary integer)");
//        int empid = 106, sal = 56000;
//        String name = "a45";
//       if(db.setdata("insert into employee values (null,"+empid+",'"+name+"',"+sal+")")){
//           JOptionPane.showMessageDialog(null, "Added");
//       }
    }

}
