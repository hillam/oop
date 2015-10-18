
public class Player {
	private int m_score = 0;
	
	public int getScore(){
		return m_score;
	}
	
	public void score(){
		m_score++;
	}
	
	public void reset(){
		m_score = 0;
	}
}
