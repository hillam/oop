import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.List;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SquareView extends JPanel implements Observer{
	private List<FancyButton> m_cards = new ArrayList<FancyButton>();
	private ActionListener m_controller = new Controller();
	private Timer m_timer;
	private final Model MODEL = Model.getInstance();
	
	private IStrategy m_opponent;
	
	private File match = new File("match.wav");
	private File noMatch = new File("noMatch.wav");
	
	public SquareView(){
		setBackground(Color.GRAY);  
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
            	
            	boolean gameover = true;
            	for(int i = 0; i < Model.NUM_SQUARES; i++){
            		if(!MODEL.isFound(i)){
            			gameover = false;
            			break;
            		}
            	}
            	if(gameover)
            		showPlayAgain();
            	
            	if(MODEL.isPlayerTurn()){
            		m_timer.stop();
            		setBackground(Color.GRAY);
            	}
            	else
            		m_opponent.doMove();
            }
        });
	}
	
	public void selectDifficulty(){
		String[] strategies = {"Easy", "Medium", "Hard"};
	    String selection = (String) JOptionPane.showInputDialog(this, "Select an opponent strategy.",
	        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, 
	        strategies, 
	        strategies[0]); 
	    m_opponent = StrategyBuilder.getInstance().buildStrategy(selection);
	}
	
	public void showPlayAgain(){
		JDialog.setDefaultLookAndFeelDecorated(true);
	    int response = JOptionPane.showConfirmDialog(this, "Play again?", 
	    		"Confirm",
	    		JOptionPane.YES_NO_OPTION, 
	    		JOptionPane.QUESTION_MESSAGE);
	    if(response == JOptionPane.YES_OPTION){
	    	MODEL.reset();
	    	selectDifficulty();
	    }
	    else
	    	System.exit(0);
	}
	
	private class FancyButton extends JButton{
		public FancyButton(){
			addActionListener(m_controller);
			setOpaque(false);
			setContentAreaFilled(false);
			clearBorder(this);
			setIcon(new ImageIcon("cardback.jpg"));
		}
	}
	
	public class Controller implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			for(int i = 0; i < m_cards.size(); i++){
				if(m_cards.get(i) == event.getSource() && 
						MODEL.isPlayerTurn() && !MODEL.isFound(i)){
					/*------------------------------------------------
					 *		m_cards[i] WAS CLICKED
					 -----------------------------------------------*/
					if(MODEL.numSelected() < 2)
						MODEL.select(i);
					if(MODEL.numSelected() == 2){
						if(Model.checkMatch(i))
							MODEL.player1Score();
						setBackground(Color.BLACK); 
						
						// Play Sound
						try{
							Clip clip = AudioSystem.getClip();
							if(Model.checkMatch(i))
								clip.open(AudioSystem.getAudioInputStream(match));
							else
								clip.open(AudioSystem.getAudioInputStream(noMatch));
							clip.start();
					    }
					    catch (Exception e){
					    	e.printStackTrace(System.out);
					    }
						
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
