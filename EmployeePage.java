package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EmployeePage extends Frame implements ActionListener {
  JButton newCustomer,customer,inventory;
  EmployeePage(){


JFrame f = new JFrame();
    setLayout(null);
    newCustomer = new JButton("NEW CUSTOMER +");
    customer = new JButton("CUSTOMER DETAILS");
    inventory = new JButton("INVENTORY"); 
    newCustomer.setBounds(100,350,220,80);
    customer.setBounds(350,350,220,80);
    inventory.setBounds(600,350,220,80);
    add(newCustomer);
    add(customer);
    add(inventory);

 
    
    newCustomer.addActionListener(this);
    customer.addActionListener(this);
    inventory.addActionListener(this);
    setSize(900,800);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent click){

    if(newCustomer ==  click.getSource()){
      NewCustomer NC = new NewCustomer();

    }

    else if(customer == click.getSource()){
        CustomerDetails CD = new CustomerDetails();
    }

    else{
      Inventory I = new Inventory();
    }
  }
    
}
