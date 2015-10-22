import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class HardPlayer implements IStrategy, Observer {

	private HashMap<Integer,Integer> m_memory = new HashMap<Integer,Integer>();
	private final Model MODEL = Model.getInstance();
	
	@Override
	public void doMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
