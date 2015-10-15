import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel implements Observer
{
	private JLabel m_score = null;

	public ScorePanel()
	{
		m_score = new JLabel("Score: " + 0);
		add(m_score);
	}

	@Override
	public void update(Observable o, Object arg)
	{
		m_score.setText("Score: " + Model.getInstance().getScore());
	}
}
