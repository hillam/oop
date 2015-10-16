import java.util.Observable;

public class Model extends Observable
{
	private static Model m_instance = null;
	public static Model getInstance()
	{
		if (m_instance == null)
			m_instance = new Model();
		return m_instance;
	}
	private Model(){}

	private int score = 0;

	public void click(){
		score ++;
		setChanged();
		notifyObservers();
	}

	public int getScore(){
		return score;
	}

}
