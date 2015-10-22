import java.util.Random;

public class EasyPlayer implements IStrategy {
	private Random m_rand = new Random();
	private final Model MODEL = Model.getInstance();
	
	@Override
	public void doMove() {
		int choice1, choice2;
		do{			
			choice1 = m_rand.nextInt(Model.NUM_SQUARES);
			choice2 = m_rand.nextInt(Model.NUM_SQUARES);
		}while(MODEL.isSelectedOrFound(choice1) || MODEL.isSelectedOrFound(choice2) || choice1 == choice2);
		
		MODEL.select(choice1);
		MODEL.select(choice2);
		
		if(Model.checkMatch(choice1)){
			MODEL.player2Score();
		}
	}
}
