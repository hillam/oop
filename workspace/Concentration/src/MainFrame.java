import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// TODO: Add views
		JPanel footerView = new FooterView();
		JPanel squareView = new SquareView();
		
		add(squareView, BorderLayout.CENTER);
		add(footerView, BorderLayout.SOUTH);
		
		setSize(800, 800);
		setVisible(true);
		
		// TODO: Add Observers to the model
		Model.getInstance().addObserver((Observer) squareView);
		Model.getInstance().addObserver((Observer) footerView);
	}
}
