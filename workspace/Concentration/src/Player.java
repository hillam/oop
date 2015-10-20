
public class Player {
	private int m_score = 0;
	private boolean m_turn = false;
	
	public int getScore(){
		return m_score;
	}
	
	public void score(){
		m_score++;
	}
	
	public void toggleTurn(){
		m_turn = !m_turn;
	}
	
	public boolean isTurn(){
		return m_turn;
	}
	
	public void reset(){
		m_score = 0;
		m_turn = false;
	}
}
