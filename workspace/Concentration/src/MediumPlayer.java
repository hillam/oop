import java.util.Random;

public class MediumPlayer implements IStrategy {
	private Random m_rand = new Random();
	private IStrategy m_easy = new EasyPlayer();
	private IStrategy m_hard = new HardPlayer();
	
	@Override
	public void doMove() {
		if(m_rand.nextFloat() < .3)
			m_easy.doMove();
		else 
			m_hard.doMove();
	}
}
