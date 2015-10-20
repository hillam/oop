import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	private static Model m_model;
	public static Model getInstance(){
		if(m_model == null)
			m_model = new Model();
		return m_model;
	}
	
	private Player m_player1;
	private Player m_player2;
	private List<Square> m_squares;
	private int m_selected = 0;
	
	public static final int NUM_SQUARES = 24;
	
	private Model(){
		m_player1 = new Player();
		m_player2 = new Player();
		m_squares = new ArrayList<Square>();
		newSquares();
	}
	
	public void reset(){
		m_player1.reset();
		m_player2.reset();
		newSquares();
		changed();
	}
	
	private void newSquares(){	
		m_squares.clear();
		for(int i = 0; i < NUM_SQUARES/2; i++){
			m_squares.add(new Square(i));
			m_squares.add(new Square(i));
		}
		Collections.shuffle(m_squares);
	}
	
	public int getPlayer1Score() {
		return m_player1.getScore();
	}
	
	public int getPlayer2Score() {
		return m_player2.getScore();
	}
	
	public void player1Score(){
		m_player1.score();
		changed();
	}
	
	public void player2Score(){
		m_player2.score();
		changed();
	}
	
	public void select(int index){
		if(!isSelected(index)){
			m_selected++;
			m_squares.get(index).select();
		}
		changed();
	}
	
	public int numSelected(){
		return m_selected;
	}
	
	public void clearSelected(){
		m_selected = 0;
		for(Square s : m_squares)
			s.deselect();
		changed();
	}
	
	public boolean isSelected(int index) {
		return m_squares.get(index).isSelected();
	}
	
	public void changed(){
		setChanged();
		notifyObservers();
	}
}
