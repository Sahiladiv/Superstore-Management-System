package passage;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

public class NewCustomer extends Frame implements ActionListener {
    
 JButton submit;
 JTextField nameText,ageText,contactText,emailText,addressText;
 JLabel nameLabel,ageLabel,contactLabel,emailLabel,addressLabel;
 String Name,Contact,Address,Email;
 int age;
NewCustomer(){
    JFrame f = new JFrame();
  setLayout(null);

  nameLabel = new JLabel("Name:");
  ageLabel = new JLabel("Age:");
  contactLabel = new JLabel("Contact:");
  emailLabel = new JLabel("Email:");
  addressLabel = new JLabel("Address:");

  nameText = new JTextField(20);
  ageText = new JTextField(2);
  contactText = new JTextField(20);
  emailText = new JTextField(20);
  addressText = new JTextField(100);

  submit = new JButton("Submit");
  
  nameLabel.setBounds(100,100,100,25);
  nameText.setBounds(200,100,100,25);
  
  ageLabel.setBounds(100,150,100,25);
  ageText.setBounds(200,150,100,25);
  
  contactLabel.setBounds(100,200,100,25);
  contactText.setBounds(200,200,100,25);
  
  addressLabel.setBounds(100,250,100,25);
  addressText.setBounds(200,250,400,25);
  
  emailLabel.setBounds(100,300,100,25);
  emailText.setBounds(200,300,200,25);
   
   submit.setBounds(150,400,100,25);

  add(nameLabel);
  add(nameText);

  add(ageLabel);
  add(ageText);

  add(contactLabel);
  add(contactText);

  add(emailLabel);
  add(emailText);

  add(addressLabel);
  add(addressText);

  add(submit);
  submit.addActionListener(this);
  setSize(900,750);
  setTitle("New Customer:");
  setVisible(true);

}

public void actionPerformed(ActionEvent click){
  Name = nameText.getText();
  age = Integer.parseInt(ageText.getText());
  Address = addressText.getText();
  Contact = contactText.getText();
  Email = emailText.getText();
  if(submit == click.getSource()){
      add();
  }
}

public void add(){
    
          try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/superstore","","");
          Statement s = c.createStatement();
          s.execute("insert into customerDetails values('"+Name+"','"+age+"','"+Contact+"','"+Email+"','"+Address+"')");
          System.out.println("New Customer recorded");
          c.close();
      }

      catch(Exception e){
          System.out.println(e);
      }
}
}
