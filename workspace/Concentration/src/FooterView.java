import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FooterView extends JPanel implements Observer{
	
	private JLabel m_scoreLabel = new JLabel();
	
	public FooterView(){
		setScore(0,0);
		add(m_scoreLabel);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Model m = Model.getInstance();
		setScore(m.getPlayer1Score(), m.getPlayer2Score());
	}
	
	public void setScore(int player1, int player2){
		m_scoreLabel.setText("<html><p><font style='font-weight: bold;'>Player 1:</font> Human (" + player1 + ") " +
							 "<font style='font-weight: bold;'>Player 2:</font> Computer (" + player2 + ")</p></html>");
	}
}
