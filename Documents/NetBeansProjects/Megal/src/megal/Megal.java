
package megal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




/**
 *
 * @author Kalosh
 */
public class Megal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating a Frame
       JFrame chris = new JFrame("Login");
       //Creating a panel that will have all the components in it
       JPanel mypanel= new JPanel();
       //creating components in the panel
       JLabel newlabel = new JLabel("Username:");
       JTextField name =new JTextField(30);
       newlabel.setLabelFor(name);
       JLabel oldlabel=new JLabel("Password:");
       JPasswordField pass =new JPasswordField(30);
       oldlabel.setLabelFor(pass);
     
       //adding buttons
       JButton login=new JButton("Login");
       JButton clear= new JButton("Clear");
    
       //adding components in the panel
       mypanel.add(newlabel);
       mypanel.add(name);
       mypanel.add(oldlabel);
       mypanel.add(pass);
       mypanel.add(login);
       mypanel.add(clear);
       //Setting some attributes for my frame and making it visible
       chris.add(mypanel);
       chris.setSize(400,300);
       chris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       chris.setVisible(true);
       login.addActionListener(new GUIlistener());
       clear.addActionListener(new GUIlistener());
       }
    static class GUIlistener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
             
            JFrame frame2 = new JFrame("Home");
               frame2.setVisible(true);
               frame2.setSize(400,300);
               JPanel panel = new JPanel();
               frame2.add (panel);
     }
      
            
             //To change body of generated methods, choose Tools | Templates.
        }
        //this class monitors the buttons
    
}

   