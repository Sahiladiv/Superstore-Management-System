package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;

public class EmployeeDetails  extends JFrame implements ActionListener{
    
    JLabel nameLabel,idLabel,ageLabel,contactLabel,postLabel,addressLabel;
    JLabel nameDetail,idDetail,ageDetail,contactDetail,postDetail,addressDetail;
    JTextField searchEmployee;
    JButton search;
    String name,id,address,contact,post;
    int age;
    
    public EmployeeDetails(){
      
        JFrame f = new JFrame();
        setLayout(null);

          searchEmployee = new JTextField("Search employee");
          search = new JButton("SEARCH");
          
          nameLabel = new JLabel("Name: ");
          idLabel = new JLabel("ID: ");
          ageLabel = new JLabel("Age: ");
          contactLabel = new JLabel("Contact Number: ");
          addressLabel = new JLabel("Address: ");
          postLabel = new JLabel("Post: ");
         
         nameDetail = new JLabel("                                  ");
         idDetail = new JLabel("                                  ");
         ageDetail = new JLabel("                                  ");
         contactDetail = new JLabel("                                  ");
         postDetail = new JLabel("                                  ");
         addressDetail = new JLabel("                                  ");
         
         
searchEmployee.setBounds(100,100,200,25);
    search.setBounds(300,100,100,25);     
    
        nameLabel.setBounds(100,200,100,25);
        nameDetail.setBounds(200,200,100,25);

        idLabel.setBounds(100,250,100,25);
        idDetail.setBounds(200,250,100,25);
                                   
        ageLabel.setBounds(100,300,100,25);
        ageDetail.setBounds(200,300,100,25);
                                                      
        contactLabel.setBounds(100,350,100,25);
        contactDetail.setBounds(200,350,100,25);
        
        addressLabel.setBounds(100,400,100,25);
        addressDetail.setBounds(200,400,500,25);
                                                      
        postLabel.setBounds(100,450,100,25);
        postDetail.setBounds(200,450,100,25);
                                                               
                                                      
               add(searchEmployee);
               add(search);
                  
         
      add(nameLabel);
       add(nameDetail);
        
         add(idLabel);
add(idDetail);
        
              add(ageLabel);
     add(ageDetail);
        
            add(contactLabel);
      add(contactDetail);
        
     add(addressLabel);
      add(addressDetail);
        
           add(postLabel);
     add(postDetail);
        
        
        
        
        
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
          ResultSet EmployeeDetails = s.executeQuery("select * from employee");
          
          while(EmployeeDetails.next()){
              name = EmployeeDetails.getString(2);
              if(name.equals(searchEmployee.getText())){
              id = EmployeeDetails.getString(1);
              age = EmployeeDetails.getInt(3);
              contact = EmployeeDetails.getString(4);
              address = EmployeeDetails.getString(5);
              post = EmployeeDetails.getString(6);
              
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
         idDetail.setText(id);
         ageDetail.setText(String.valueOf(age));
         contactDetail.setText(contact);
         postDetail.setText(post);
         addressDetail.setText(address);
 }
    
    

}
