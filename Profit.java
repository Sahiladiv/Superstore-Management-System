package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Profit extends Frame implements ActionListener {
    JLabel dateLabel,profitLabel;
    JTextField dateText,profitText;
    JButton addButton;
    String Date,ProfitOfDate;
    Profit(){

        JFrame f = new JFrame();
        setLayout(null);
        dateLabel = new JLabel("DATE:");
        profitLabel = new JLabel("PROFIT:");
        
        dateText = new JTextField(10);
        profitText = new JTextField(10);
        
        addButton = new JButton("ADD+");
        
        dateLabel.setBounds(100,150,50,10);
        dateText.setBounds(150,150,100,25);
        
        profitLabel.setBounds(100,200,50,10);
        profitText.setBounds(150,200,100,25);
        
        addButton.setBounds(100,250,220,80);

     
        
        add(dateLabel);
        add(dateText);
        
        add(profitLabel);
        add(profitText);
        
        add(addButton);
        
        addButton.addActionListener(this);
  setSize(700,850);
  setTitle("Profit:");
  setVisible(true);
        
        
        
        
    }
    
     @Override
 public void actionPerformed(ActionEvent click){
  Date = dateText.getText();
  ProfitOfDate = profitText.getText();
  add();
}
    
    
    
    
    public void add(){
              try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/superstore","","");
          Statement s = c.createStatement();
          s.execute("insert into profitWithDate values('"+Date+"','"+ProfitOfDate+"')");
          System.out.println("New employee recorded");
          c.close();
      }

      catch(Exception e){
          System.out.println(e);
      }
    }

}
