import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// handle events
		
		int index = Integer.parseInt(((JButton)e.getSource()).getName());
		Model.getInstance().toggleSelected(index);
	}
}