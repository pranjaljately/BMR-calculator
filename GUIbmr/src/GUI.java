
import javax.swing.JFrame;

public class GUI implements Runnable {
	
	public void run(){
		
		JFrame frame = new JFrame("BMR Calculator"); //new jframe
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//stopping close 'x' from working
		bmrControl newContentPane = new bmrControl();
		
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		frame.setBounds(250,250,500,425);
		frame.setVisible(true);
	}

}
