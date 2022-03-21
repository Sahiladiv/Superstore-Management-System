package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerDetails extends JFrame implements ActionListener {
    
    JLabel nameLabel,idLabel,ageLabel,contactLabel,addressLabel,emailLabel;
    JLabel nameDetail,idDetail,ageDetail,contactDetail,addressDetail,emailDetail;
    JTextField searchCustomer;
    JButton search;
    String name,address,contact,email;
    int age;
    
    public CustomerDetails(){
      
        JFrame f = new JFrame();
        setLayout(null);

          searchCustomer = new JTextField("Search customer");
          search = new JButton("SEARCH");
          
          nameLabel = new JLabel("Name: ");
          ageLabel = new JLabel("Age: ");
          contactLabel = new JLabel("Contact Number: ");
          addressLabel = new JLabel("Address: ");
          emailLabel = new JLabel("Email:");
         
         nameDetail = new JLabel("                                  ");
         idDetail = new JLabel("                                  ");
         ageDetail = new JLabel("                                  ");
         contactDetail = new JLabel("                                  ");
         emailDetail = new JLabel("                                  ");
         addressDetail = new JLabel("                                  ");
         
         
searchCustomer.setBounds(100,100,200,25);
    search.setBounds(300,100,100,25);     
    
        nameLabel.setBounds(100,200,100,25);
        nameDetail.setBounds(200,200,100,25);
                            
        ageLabel.setBounds(100,300,100,25);
        ageDetail.setBounds(200,300,100,25);
                                                      
        contactLabel.setBounds(100,350,100,25);
        contactDetail.setBounds(200,350,100,25);
        
        addressLabel.setBounds(100,400,100,25);
        addressDetail.setBounds(200,400,500,25);
                                                      
        emailLabel.setBounds(100,450,100,25);
        emailDetail.setBounds(200,450,150,25);
                                                               
                                      
               add(searchCustomer);
               add(search);
                  
         
      add(nameLabel);
       add(nameDetail);
        

        
              add(ageLabel);
     add(ageDetail);
        
            add(contactLabel);
      add(contactDetail);
        
     add(addressLabel);
      add(addressDetail);
        
           add(emailLabel);
     add(emailDetail);
        
        
        
        
        
        search.addActionListener(this);
        
        setVisible(true);
        setSize(700,700);
}
    
       @Override
 public void actionPerformed(ActionEvent click){

if(search ==click.getSource()){
    showDetails();
}
}
 
 public void showDetails(){
     
     
     
           try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/superstore","","");
          Statement s = c.createStatement();
          System.out.println(name);
          ResultSet CustomerDetails = s.executeQuery("select * from customerDetails");
          
          while(CustomerDetails.next()){
              name = CustomerDetails.getString(1);
              if(name.equals(searchCustomer.getText())){
              age = CustomerDetails.getInt(2);
              contact = CustomerDetails.getString(3);
              address = CustomerDetails.getString(5);
              email = CustomerDetails.getString(4);
              
              showCompleteDetails();
              }

          }
          
          c.close();
      }

      catch(Exception e){
          System.out.println(e);
      }
     
 }
 
 public void showCompleteDetails(){
         nameDetail.setText(name);
         ageDetail.setText(String.valueOf(age));
         contactDetail.setText(contact);
         emailDetail.setText(email);
         addressDetail.setText(address);
 }
    
}
