package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class NewEmployee extends Frame implements ActionListener{

 JButton submit;
 JTextField nameText,ageText,contactText,idText,postText,passwordText,confirmPasswordText,addressText;
 JLabel nameLabel,ageLabel,contactLabel,addressLabel,idLabel,postLabel,passwordLabel,confirmPasswordLabel;
 String Name,Id,Address,Contact,Post,Password,confirmPassword;
 int age;

public NewEmployee(){
//  FlowLayout f = new FlowLayout();
JFrame f  = new JFrame();
  setLayout(null);

  nameLabel = new JLabel("Name:");
  ageLabel = new JLabel("Age:");
  contactLabel = new JLabel("Contact:");
  addressLabel = new JLabel("Address:");
  idLabel = new JLabel("Id:");
  postLabel = new JLabel("Post:");
  passwordLabel = new JLabel("Password:");
  confirmPasswordLabel = new JLabel("Confirm Password:");

  nameText = new JTextField(50);
  ageText = new JTextField(2);
  contactText = new JTextField(10);
  idText = new JTextField(10);
  postText = new JTextField(10);
  passwordText = new JTextField(10);
//  passwordText.setEchoChar('*');
  confirmPasswordText = new JTextField(10);
//  confirmPasswordText.setEchoChar('*');
  addressText = new JTextField(20);

  submit = new JButton("Submit");
  
  nameLabel.setBounds(100,100,100,25);
  nameText.setBounds(300,100,100,25);
  
  ageLabel.setBounds(100,150,100,25);
  ageText.setBounds(300,150,100,25);
  
  contactLabel.setBounds(100,200,100,25);
  contactText.setBounds(300,200,100,25);
  
  addressLabel.setBounds(100,250,100,25);
  addressText.setBounds(300,250,400,25);
  
  passwordLabel.setBounds(100,300,100,25);
  passwordText.setBounds(300,300,150,25);
  
  confirmPasswordLabel.setBounds(100,350,150,25);
    confirmPasswordText.setBounds(300,350,150,25);
 
   idLabel.setBounds(100,400,100,25);
   idText.setBounds(300,400,100,25);
   
   postLabel.setBounds(100,450,100,25);
   postText.setBounds(300,450,100,25);
   
   submit.setBounds(200,550,100,25);

  add(nameLabel);
  add(nameText);

  add(ageLabel);
  add(ageText);

  add(contactLabel);
  add(contactText);

  add(addressLabel);
  add(addressText);
  
  add(passwordLabel);
  add(passwordText);
  
  add(confirmPasswordLabel);
  add(confirmPasswordText);
  
  add(idLabel);
  add(idText);

  add(postLabel);
  add(postText);
  
  

  add(submit);
  submit.addActionListener(this);
  setSize(800,1000);
  setTitle("New Employee:");
  setVisible(true);

}

 @Override
 public void actionPerformed(ActionEvent click){
  Name = nameText.getText();
  age = Integer.parseInt(ageText.getText());
  Id = idText.getText();
  Address = addressText.getText();
  Post = postText.getText();
  Contact = contactText.getText();
  Password = passwordText.getText();
  confirmPassword = confirmPasswordText.getText();
  if(Password.equals(confirmPassword)){
        add();
  }
  else{
        System.out.println("Mismatch in password");

  }

}

public void add(){
          
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/superstore","","");
          Statement s = c.createStatement();
          s.execute("insert into employee values('"+Id+"','"+Name+"','"+age+"','"+Contact+"','"+Address+"','"+Post+"')");
          s.execute("insert into employeeAccess values('"+Name+"','"+Password+"')");
          System.out.println("New employee recorded");
          c.close();
      }

      catch(Exception e){
          System.out.println(e);
      }

}
}
     
    

