import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame //implements Observer
{
	public MainFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);

		JPanel scorePanel1 = new ScorePanel();
		add(scorePanel1, BorderLayout.NORTH);

		JPanel scorePanel2 = new ScorePanel();
		add(scorePanel2, BorderLayout.WEST);

		JPanel scorePanel3 = new ScorePanel();
		add(scorePanel3, BorderLayout.EAST);

		JPanel scorePanel4 = new ScorePanel();
		add(scorePanel4, BorderLayout.SOUTH);

		setSize(300, 300);
		setVisible(true);

		//Model.getInstance().addObserver((Observer)mainPanel);
		//Model.getInstance().addObserver(this);
		Model.getInstance().addObserver((Observer)scorePanel1);
		Model.getInstance().addObserver((Observer)scorePanel2);
		Model.getInstance().addObserver((Observer)scorePanel3);
		Model.getInstance().addObserver((Observer)scorePanel4);
	}
}
