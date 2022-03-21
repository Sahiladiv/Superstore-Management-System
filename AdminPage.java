package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPage extends JFrame implements ActionListener{
    JButton newCustomer,customer,inventory,newEmployee,employee,profit;

 public  AdminPage(){

    JFrame f = new JFrame();
    setLayout(null);
    newEmployee = new JButton("NEW EMPLOYEE +");
    employee = new JButton("EMPLOYEE DETAILS");
    newCustomer = new JButton("NEW CUSTOMER +");
    customer = new JButton("CUSTOMER DETAILS");
    inventory = new JButton("INVENTORY");
    profit = new JButton("PROFIT");
    
    newEmployee.setBounds(100,200,220,80);
    employee.setBounds(350,200,220,80);
    newCustomer.setBounds(100,350,220,80);
    customer.setBounds(350,350,220,80);
    inventory.setBounds(100,500,220,80);
    profit.setBounds(350,500,220,80);
    
    add(newEmployee);
    add(employee);
    add(newCustomer);
    add(customer);
    add(inventory);
    add(profit);

    newEmployee.addActionListener(this);
    employee.addActionListener(this);
    newCustomer.addActionListener(this);
    customer.addActionListener(this);
    inventory.addActionListener(this);
    profit.addActionListener(this);
    setSize(700,800);
    setVisible(true);
  
 }

   public void actionPerformed(ActionEvent click){

    if(newCustomer ==  click.getSource()){
        NewCustomer NE = new NewCustomer();
    }

    else if(newEmployee ==  click.getSource()){
        NewEmployee NE = new NewEmployee();
    }
    
    else if(customer ==  click.getSource()){
        CustomerDetails ED = new CustomerDetails();
    }
    
    else if(employee ==  click.getSource()){
        EmployeeDetails ED = new EmployeeDetails();
    }

    else if(profit == click.getSource()){
        Profit P = new Profit();
    }
    
    else{
        Inventory I = new Inventory();
    }
  }
    
}
