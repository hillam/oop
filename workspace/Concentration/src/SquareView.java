import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
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
			panel.add(new CardView(i));
			add(panel);
		}
	}
	
	private class CardView extends JButton implements Observer{
		private int m_index;
		public CardView(int index){
			setName("" +index);
			m_index = index;
			addActionListener(m_controller);
			
			Model.getInstance().addObserver(this);
		}
		
		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			if(Model.getInstance().isSelected(m_index))
				((JComponent) getParent()).setBorder(BorderFactory.createLineBorder(Color.yellow));
			else
				((JComponent) getParent()).setBorder(BorderFactory.createEmptyBorder());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
