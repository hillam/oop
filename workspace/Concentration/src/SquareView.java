import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquareView extends JPanel implements Observer{
	private ActionListener m_controller = new Controller();
	
	public SquareView(){
		setLayout(new GridLayout(4,6));
		
		for(int i=0; i<Model.NUM_SQUARES; i++){
			JComponent panel = new JPanel();
			panel.add(new CardView());
			add(panel);
		}
	}
	
	private class CardView extends JButton{
		public CardView(){
			addActionListener(m_controller);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
