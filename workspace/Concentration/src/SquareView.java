import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SquareView extends JPanel implements Observer{
	private List<FancyButton> m_cards = new ArrayList<FancyButton>();
	private ActionListener m_controller = new Controller();
	private Timer m_timer;
	
	public SquareView(){
		setLayout(new GridLayout(4,6));
		
		for(int i=0; i<Model.NUM_SQUARES; i++){
			JComponent panel = new JPanel();
			FancyButton card = new FancyButton();
			m_cards.add(card);
			panel.add(card);
			add(panel);
		}
		
		// after 2 seconds, clear selected cards
		m_timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Model.getInstance().clearSelected();
               m_timer.stop();
            }
        });
	}
	
	private class FancyButton extends JButton{
		public FancyButton(){
			addActionListener(m_controller);
		}
	}
	
	public class Controller implements ActionListener{
		@Override
		
		public void actionPerformed(ActionEvent e) {
			Model m = Model.getInstance();
			for(int i = 0; i < m_cards.size(); i++){
				if(m_cards.get(i) == e.getSource()){
					/*------------------------------------------------
					 *		m_cards[i] WAS CLICKED
					 -----------------------------------------------*/
					if(m.numSelected() < 2){
						m.select(i);
					}
					if(m.numSelected() == 2){
						m_timer.start();
					}
					break;
					/*-----------------------------------------------*/
				}
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		for(int i = 0; i < m_cards.size(); i++){
			if(Model.getInstance().isSelected(i))
				addBorder(m_cards.get(i).getParent());
			else
				clearBorder(m_cards.get(i).getParent());
		}
	}
	
	public void addBorder(Container c){
		((JPanel)c).setBorder(BorderFactory.createLineBorder(Color.yellow));
	}

	public void clearBorder(Container c){
		((JPanel)c).setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void clearBorders(){
		for(JButton c : m_cards){
			clearBorder(c);
		}
	}
}
