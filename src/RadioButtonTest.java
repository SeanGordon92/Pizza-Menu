import javax.swing.*;  
import java.awt.event.*; 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

public class RadioButtonTest extends JFrame
{
	private static final long serialVersionUID = 1L;
  JFrame frame;  
  JLabel lbl1, lbl2;
  JButton btn1, btn2;
  JRadioButton rBtn1, rBtn2, rBtn3;
  JCheckBox cBtn1, cBtn2;
  JPanel checkPanel, ButtonGroup, dropmenu, buttonPanel;
  String str1,str2,str3;
  Border blackline,blackline2,blackline3,border;
  RadioButtonTest()
  {
	JFrame frame = new JFrame();
    checkPanel = new JPanel();
    ButtonGroup = new JPanel();
    dropmenu = new JPanel();
    buttonPanel = new JPanel();
  //Use the borders to add names to each panel
    blackline = BorderFactory.createLineBorder(Color.black);
    blackline = BorderFactory.createTitledBorder("Choose pizza size:");
    blackline2 = BorderFactory.createLineBorder(Color.black);
    blackline2 = BorderFactory.createTitledBorder("Choose toppings:");
    blackline3 = BorderFactory.createLineBorder(Color.black);
    blackline3 = BorderFactory.createTitledBorder("Eat-in or delivery?"); 
    border = BorderFactory.createLineBorder(Color.BLACK, 5);
    //Lable that changes on the action
    lbl1 = new JLabel("Actions", JLabel.CENTER);
    lbl2 = new JLabel("Final", JLabel.CENTER);
    lbl1.setBounds(5,280,200,50);
    lbl1.setText("Please choose your options");
    lbl2.setBounds(5,320,340,50);
    lbl2.setBorder(border);
    lbl2.setLayout(new FlowLayout(FlowLayout.LEFT));
    // Create the radio buttons
    rBtn1 = new JRadioButton("Small");
    rBtn1.setSelected(true);
    rBtn2 = new JRadioButton("Medium");
    rBtn3 = new JRadioButton("Large");  
    ButtonGroup.add(rBtn1);
    ButtonGroup.add(rBtn2);  
    ButtonGroup.add(rBtn3);   
    ButtonGroup.setBorder(blackline);
    ButtonGroup.setBounds(30,20,220,50);
    //Add check buttons
    cBtn1 = new JCheckBox("Olives");  
    cBtn2 = new JCheckBox("Ananas");  
    checkPanel.add(cBtn1);
    checkPanel.add(cBtn2);
    checkPanel.setBorder(blackline2);
    checkPanel.setBounds(30,80,220,50);
    //Add dropdown menu
    String[] options = {"Dine-in", "Deliver"};
    JComboBox<String> jComboBoxS = new JComboBox<>(options);
    dropmenu.add(jComboBoxS);
    dropmenu.setBorder(blackline3);
    dropmenu.setBounds(30,140,220,50);
    //ActionListener for dropmenu
	jComboBoxS.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			JComboBox jComboBoxS = (JComboBox) event.getSource();
        	lbl1.setText("You chose " + jComboBoxS.getSelectedItem());
		}
	});
    //Add finish buttons
	btn1 = new JButton("Finish and order");
	btn2 = new JButton("Cancel order");
	btn1.setHorizontalAlignment(SwingConstants.CENTER);
	btn2.setHorizontalAlignment(SwingConstants.CENTER);
	buttonPanel.add(btn1);
	buttonPanel.add(btn2);
	buttonPanel.setBounds(190,200,130,80);
	buttonPanel.setMinimumSize(getMinimumSize());
	//Set up the frame
	frame.setLayout(new FlowLayout());
    frame.pack();
    frame.add(ButtonGroup, BorderLayout.CENTER);
    frame.add(checkPanel, BorderLayout.CENTER);
    frame.add(dropmenu, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.CENTER); 
    frame.add(lbl1, BorderLayout.CENTER); 
    frame.add(lbl2, BorderLayout.CENTER); 
    frame.setSize(380,350);  
    frame.setVisible(true);
   //Actions 
    rBtn1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        	lbl1.setText("You picked small size");
        	rBtn2.setSelected(false);//When this btn is chosen
        	rBtn3.setSelected(false);//uncheck all else
        }
      });//Repeat for each btn
    rBtn2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        	lbl1.setText("You picked medium size");
        	rBtn1.setSelected(false);
        	rBtn3.setSelected(false);
        }
      });
    rBtn3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        	lbl1.setText("You picked large size");
        	rBtn2.setSelected(false);
        	rBtn1.setSelected(false);
        }
      });
    cBtn1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ae) {
    		if (cBtn1.isSelected())
            	lbl1.setText("You chose olives");
    		if (!cBtn1.isSelected())
            	lbl1.setText("You un-chose olives");
    		if (cBtn1.isSelected() && cBtn2.isSelected())
    			lbl1.setText("You chose olives and ananas");

    	}//Repeat and change for each cBtn
      });
    cBtn2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ae) {
    		if (cBtn2.isSelected())
            	lbl1.setText("You chose ananas");
    		if (!cBtn2.isSelected())
            	lbl1.setText("You un-chose ananas");
    		if (cBtn1.isSelected() && cBtn2.isSelected())
    			lbl1.setText("You chose olives and ananas");

    	}
      });
    btn1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		lbl1.setText("Have a nice day");
    		if (rBtn1.isSelected() == true)
    			str1 = "small size";
    		if (rBtn2.isSelected() == true)
    			str1 = "medium size";
    		if (rBtn3.isSelected() == true)
    			str1 = "large size";
    		if (cBtn1.isSelected() == true && cBtn1.isSelected() == true)
    			str2 = "olives and ananas";
    		if (cBtn1.isSelected() == false && cBtn1.isSelected() == false)
    			str2 = "no toppings";
    		if (cBtn1.isSelected() == true && cBtn1.isSelected() == false)
    			str2 = "olives";
    		if (cBtn1.isSelected() == false && cBtn1.isSelected() == true)
    			str2 = "ananas";
        	str3 = (String) jComboBoxS.getSelectedItem();
    		lbl2.setText("You chose " + str1 + " with " + str2 + " and " +str3);
    	}
    });
    btn2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		System.exit(0);
    	}
    });
  }
  
  public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RadioButtonTest();
			}
		});
	}
}
  