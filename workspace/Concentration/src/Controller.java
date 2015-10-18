import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// handle events
		
		// TODO: remove this.. it's just test code rn
		Model.getInstance().player1Score();
	}
}