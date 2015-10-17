import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// TODO: Add views
		
		
		setSize(800, 600);
		setVisible(true);
		
		// TODO: Add Observers to the model
	}
}
