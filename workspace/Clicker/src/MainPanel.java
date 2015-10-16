import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel // implements Observer
{
	private Controller m_controller = null;
	private JButton m_click = null;

	private class Controller implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == m_click)
			{
				Model.getInstance().click();
			}
		}
	}

	public MainPanel()
	{
		m_controller = new Controller();
		m_click = new JButton("Click!");

		m_click.addActionListener(m_controller);
		add(m_click);
	}
}
