
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;


public class bmrControl extends JPanel implements ActionListener{
		
	private static final long serialVersionUID = 1865964649; //unique ID
	
	private JButton calculateButton,resetButton,exitButton;//two buttons
	private JRadioButton maleRadio,femaleRadio;//radio buttons
	private JTextField ageField,heightField,weightField;//text for user input
	private JLabel genderLabel,ageLabel,bmrResult;//text labels
	private JTextArea YourBmr,txtrBmrCalculator,errorMessage ;//text areas 
	
	
	public bmrControl()
	{
		setBackground(UIManager.getColor("Button.light"));
        
        
        //grouping radio buttons
        ButtonGroup group = new ButtonGroup();
       
          
        //male radio button
          maleRadio = new JRadioButton("Male");//new button
          maleRadio.setBackground(UIManager.getColor("Button.light"));
          maleRadio.setBounds(225, 93, 64, 23);
          maleRadio.setActionCommand("Male"); //the event when checked
          maleRadio.setSelected(true);
          group.add(maleRadio);
          
     
          
           setLayout(null);
          
       //label to display message for user to select gender
           genderLabel = new JLabel("Please select your gender:");//caption
           genderLabel.setBounds(49, 97, 156, 14);
           
           
          //female radio button
          femaleRadio = new JRadioButton("Female");//new button
          femaleRadio.setBackground(UIManager.getColor("Button.light"));
          femaleRadio.setBounds(318, 93, 72, 23);
          femaleRadio.setActionCommand("Female");//the event when checked
          femaleRadio.setSelected(true);
          group.add(femaleRadio);
  
          
          //calculate button
          calculateButton = new JButton("Calculate");//caption
          calculateButton.setBounds(215, 261, 88, 23);
          calculateButton.setVerticalTextPosition(AbstractButton.CENTER);
          calculateButton.setHorizontalTextPosition(AbstractButton.CENTER);
          calculateButton.setActionCommand("Calculate");//event when clicked
         
          
          //reset button
          resetButton = new JButton("Reset");//caption
          resetButton.setBounds(149, 313, 90, 23);
          resetButton.setVerticalTextPosition(AbstractButton.CENTER);
          resetButton.setHorizontalTextPosition(AbstractButton.CENTER);
          resetButton.setActionCommand("Reset");//event when clicked
          
          //age
          ageLabel = new JLabel("Please enter your age:");//caption
          ageLabel.setBounds(49, 137, 152, 14);
          
          //exit button
          exitButton = new JButton("Exit");//caption
          exitButton.setBounds(283, 313, 90, 23);
          exitButton.setVerticalTextPosition(AbstractButton.CENTER);
          exitButton.setHorizontalTextPosition(AbstractButton.CENTER);
          exitButton.setActionCommand("Exit");//event when clicked
          
        //user text fields
         
        //field for height
         heightField = new JTextField(5);
         heightField.setBounds(226, 206, 46, 20);
         
         //field for weight
         weightField = new JTextField(5);
         weightField.setBounds(226, 167, 46, 20);
        
         //field for age
         ageField = new JTextField(5);
         ageField.setBounds(226, 134, 46, 20);
        
         //labels
         
         JLabel weightLabel = new JLabel("Please enter your weight (kg):");//caption
         weightLabel.setBounds(49, 170, 185, 14);
         
         
         JLabel heightLabel = new JLabel("Please enter your height (cm):");//caption
         heightLabel.setBounds(49, 209, 185, 14);
         
         //output messages
         
         //Your daily BMR is...
         YourBmr = new JTextArea();
         YourBmr.setEditable(false);
         YourBmr.setBackground(UIManager.getColor("Button.light"));
         YourBmr.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
         YourBmr.setText("Your daily BMR is :");//caption
         YourBmr.setBounds(304, 165, 118, 28);
         YourBmr.setVisible(false);
         
         //Title
         txtrBmrCalculator = new JTextArea();
         txtrBmrCalculator.setEditable(false);
         txtrBmrCalculator.setFont(new Font("Monospaced", Font.PLAIN, 38));
         txtrBmrCalculator.setText(" BMR CALCULATOR");//caption
         txtrBmrCalculator.setBounds(49, 16, 373, 64);
         
         //result/BMR
         bmrResult = new JLabel("");
         bmrResult.setBounds(432, 164, 57, 20);
         bmrResult.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
          bmrResult.setVisible(false);
         
          //error messages
         errorMessage = new JTextArea();
         errorMessage.setLineWrap(true);
         errorMessage.setBackground(UIManager.getColor("CheckBox.light"));
         errorMessage.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
         errorMessage.setEditable(false);
         errorMessage.setText("INVALID INPUT!");//caption
         errorMessage.setBounds(304, 165, 160, 46);
         errorMessage.setVisible(false);
         
         
         //event listeners
         femaleRadio.addActionListener(this);
         maleRadio.addActionListener(this);
         calculateButton.addActionListener(this);
         resetButton.addActionListener(this);
         exitButton.addActionListener(this);
         ageField.addActionListener(this);
         weightField.addActionListener(this);
         heightField.addActionListener(this);
         
         //adding the components to GUI
         add(femaleRadio);
         add(genderLabel);
         add(maleRadio);
         add(calculateButton);
         add(resetButton);
         add(ageLabel);
	     add(weightField);
         add(weightLabel);
         add(heightLabel);
         add(YourBmr);
         add(txtrBmrCalculator);
         add(bmrResult);
         add(errorMessage);
         add(heightField);
         add(ageField);
         add(exitButton);
       
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("Calculate"))//when the action is 'calculate' do this...
		{
			double bmr = 0;
			double age = 0;
			double weight = 0;
			double height = 0;
			
			//error correction
			//try this code
			try{
			 age = Double.parseDouble (ageField.getText());
			 weight = Double.parseDouble(weightField.getText());
			 height = Double.parseDouble(heightField.getText());
			
			} catch (NumberFormatException error)//if number format error then..
			{
				YourBmr.setVisible(false);//hide your bmr
				bmrResult.setVisible(false);//hide bmr result
				errorMessage.setVisible(true);//display error message
				
			}
		
			if(age>0 && weight>0 && height >0)//making sure values are greater than 0
			{
				errorMessage.setVisible(false);//hide error message
				
				if(maleRadio.isSelected())//if male radio button selected do this...
				{
				//bmr for men = 66.47 + (13.7*kg) + (5*cm) - (6.8 *age)
					bmr = 66.47 + (13.7*weight) + (5*height) - (6.8 *age);
				}
			
				if(femaleRadio.isSelected())//if female radio button selected do this...
				{
				//BMR for Women = 655.1 + (9.6 * weight [kg]) + (1.8 * size [cm]) − (4.7 * age [years])
				bmr = 665.1 + (9.6*weight) + (1.8*height) - (4.7 *age);
				}
			
				YourBmr.setVisible(true);//display your bmr	
				bmrResult.setVisible(true);//display bmr
				bmrResult.setText(Integer.toString((int)bmr));//convert int to string and display value
				}
			else
			{
				YourBmr.setVisible(false);//hide Your Bmr
				bmrResult.setVisible(false);//hide result
				errorMessage.setVisible(true);//show error message
			}
			
			}
		
		if (e.getActionCommand().equals("Exit"))//when the action is 'exit' do this...
        {
        	
        	JFrame parent = (JFrame)SwingUtilities.getWindowAncestor(this);
        	parent.setVisible(false);//Hide the Window
        	parent.dispose();//Get rid of the Window
        }   
		
		if (e.getActionCommand().equals("Reset"))//when the action is 'reset' do this...
		{
			
			YourBmr.setVisible(false);//hide Your BMR
			bmrResult.setVisible(false);//hide result
			ageField.setText("");//clear field
			weightField.setText("");//clear field	
			heightField.setText("");//clear field
		}
	}
}
