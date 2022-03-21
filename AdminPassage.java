package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AdminPassage extends JFrame implements ActionListener {
  JButton submit;
  JTextField nameText;
  JLabel nameLabel,passwordLabel;
  String name,password;

 public  AdminPassage(){

JFrame f = new JFrame();
   setLayout(null);
   nameLabel = new JLabel("Name:");
   passwordLabel = new JLabel("Password:");
   nameText = new JTextField(20);
   passwordText = new JTextField(20);
//   passwordText.setEchoChar('*');
   submit = new JButton("Submit");
   nameLabel.setBounds(100,200,200,25);
   nameText.setBounds(180,200,200,25);
   passwordLabel.setBounds(100,250,200,25);
   passwordText.setBounds(180,250,200,25);
   submit.setBounds(150,300,200,25);
   add(nameLabel);
   add(nameText);
   add(passwordLabel);
   add(passwordText);
   add(submit);
   submit.addActionListener(this);
   setTitle("Admin Access:");
   setSize(500,400);
   setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        password = passwordText.getText();
        name = nameText.getText();
        check();
    }
    
      public void check(){
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/superstore","","");
          Statement s = c.createStatement();
          ResultSet adminAccess = s.executeQuery("Select * from admintable");
          while(adminAccess.next()){
              String checkName = adminAccess.getString(1);
              String checkPassword = adminAccess.getString(2);
              if(name.equals(checkName)){
                  if(password.equals(checkPassword) ){
                      System.out.println("Valid Password");
                      AdminPage AP = new AdminPage();
                  }
                  else{
                      System.out.println("Invalid Password");
                  }
              }
          }
          
          c.close();
      }
      catch(Exception e){
          System.out.println("Exception");
      }
  }
}
