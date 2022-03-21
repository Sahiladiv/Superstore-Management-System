package passage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Inventory extends JFrame implements ActionListener {
 
    String itemName,barcode;
    int quantity,cost;
    

    JLabel barcodeLabel,itemNameLabel,costLabel,quantityLabel;
    JLabel barcodeDetail,itemNameDetail,costDetail,quantityDetail;
    JTextField searchInventory;
    JButton search;
    String name,id,address,contact,post;
    
    public Inventory(){
      
        JFrame f = new JFrame();
        setLayout(null);
        searchInventory= new JTextField("Search inventory");
        search = new JButton("SEARCH");
        barcodeLabel = new JLabel("Barcode: ");
        itemNameLabel = new JLabel("Item Name: ");
        costLabel = new JLabel("Cost: ");
        quantityLabel = new JLabel("Quantity Available: ");
        barcodeDetail = new JLabel("                                  ");
        itemNameDetail = new JLabel("                                  ");
        costDetail = new JLabel("                                  ");
        quantityDetail = new JLabel("                                  ");

searchInventory.setBounds(100,100,200,25);
    search.setBounds(300,100,100,25);     
    
        barcodeLabel.setBounds(100,200,100,25);
        barcodeDetail.setBounds(200,200,100,25);

        itemNameLabel.setBounds(100,250,100,25);
        itemNameDetail.setBounds(200,250,100,25);
                                   
        costLabel.setBounds(100,300,100,25);
        costDetail.setBounds(200,300,100,25);
                                                      
        quantityLabel.setBounds(100,350,100,25);
        quantityDetail.setBounds(200,350,100,25);
        
   
        add(searchInventory);
        add(search);
                  
         
        add(barcodeLabel);
        add(barcodeDetail);
        
        add(itemNameLabel);
        add(itemNameDetail);
        
        add(costLabel);
        add(costDetail);
        
        add(quantityLabel);
        add(quantityDetail);
        
 
        
        
        
        
        
        search.addActionListener(this);
        
        setVisible(true);
        setSize(700,700);
    }
    
        @Override
 public void actionPerformed(ActionEvent click){

if(search ==click.getSource()){
    check();
}
}
    
    
    
    
    
    
    
    
    
    public void check(){
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/superstore","","");
          Statement s = c.createStatement();
          ResultSet inventoryItems = s.executeQuery("Select * from inventory");
          
          while(inventoryItems.next()){
              
              if(itemName.equals(inventoryItems.getString(2))){
                  barcode = inventoryItems.getString(1);
                  quantity = inventoryItems.getInt(3);
                  cost = inventoryItems.getInt(4);
                  show();
              }
              
          }
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void show(){
        barcodeDetail.setText(barcode);
         itemNameDetail.setText(itemName);
         costDetail.setText(String.valueOf(cost));
         quantityDetail.setText(String.valueOf(quantity));
        
    }
}
