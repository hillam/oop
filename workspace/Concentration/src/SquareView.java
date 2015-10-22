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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SquareView extends JPanel implements Observer{
	private List<FancyButton> m_cards = new ArrayList<FancyButton>();
	private ActionListener m_controller = new Controller();
	private Timer m_timer;
	private final Model MODEL = Model.getInstance();
	
	private IStrategy m_opponent = new EasyPlayer();
	
	public SquareView(){
		setLayout(new GridLayout(4,6));
		
		for(int i=0; i<Model.NUM_SQUARES; i++){
			FancyButton card = new FancyButton();
			m_cards.add(card);
			add(card);
		}
		
		// after 2 seconds, clear selected cards
		m_timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MODEL.clearSelected();
            	for(FancyButton c : m_cards)
            		clearBorder(c);
            	MODEL.switchTurns();
            	if(MODEL.isPlayerTurn())
            		m_timer.stop();
            	else
            		m_opponent.doMove();
            }
        });
	}
	
	private class FancyButton extends JButton{
		public FancyButton(){
			addActionListener(m_controller);
			clearBorder(this);
			setIcon(new ImageIcon("cardback.jpg"));
		}
	}
	
	public class Controller implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < m_cards.size(); i++){
				if(m_cards.get(i) == e.getSource() && 
						MODEL.isPlayerTurn() && !MODEL.isFound(i)){
					/*------------------------------------------------
					 *		m_cards[i] WAS CLICKED
					 -----------------------------------------------*/
					if(MODEL.numSelected() < 2)
						MODEL.select(i);
					if(MODEL.numSelected() == 2){
						if(Model.checkMatch(i))
							MODEL.player1Score();
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
			if(MODEL.isSelected(i))
				addBorder(m_cards.get(i));
			if(MODEL.isSelectedOrFound(i))
				m_cards.get(i).setIcon(new ImageIcon(MODEL.getImage(i)));
			else{
				clearBorder(m_cards.get(i));
				m_cards.get(i).setIcon(new ImageIcon("cardback.jpg"));
			}
		}
	}
	
	public void addBorder(Container c){
		((JComponent) c).setBorder(BorderFactory.createLineBorder(Color.yellow));
	}

	public void clearBorder(Container c){
		((JComponent) c).setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void clearBorders(){
		for(JButton c : m_cards){
			clearBorder(c);
		}
	}
}
