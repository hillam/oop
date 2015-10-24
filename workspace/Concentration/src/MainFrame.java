import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel footerView = new FooterView();
		JPanel squareView = new SquareView();
		
		add(squareView, BorderLayout.CENTER);
		add(footerView, BorderLayout.SOUTH);
		
		setSize(800, 800);
		setVisible(true);

		Model.getInstance().addObserver((Observer) squareView);
		Model.getInstance().addObserver((Observer) footerView);
		
		((SquareView) squareView).selectDifficulty();
	}
}
