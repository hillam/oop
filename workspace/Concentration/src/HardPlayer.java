import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class HardPlayer implements IStrategy, Observer {
	private IStrategy m_easy = new EasyPlayer();
	
	// initialize list full of -1's
	private List<Integer> m_memory = new ArrayList<Integer>(Collections.nCopies(Model.NUM_SQUARES, -1));
	
	private final Model MODEL = Model.getInstance();
	
	public HardPlayer(){
		MODEL.addObserver(this);
	}
	
	@Override
	public void doMove() {		
		boolean found = false;
		// if a duplicate value exists in m_memory, select that pair
		for(int i=0; i<Model.NUM_SQUARES; i++){
			if(m_memory.get(i) != -1 && !MODEL.isFound(i)){
				int choice1 = m_memory.indexOf(m_memory.get(i));
				int choice2 = m_memory.lastIndexOf(m_memory.get(i));
				if(choice1 != choice2){
					MODEL.select(choice1);
					MODEL.select(choice2);
					
					// we don't need checkMatch here, because we checked the id's already
					MODEL.find(choice1, choice2); 
					found = true;
					MODEL.player2Score();
					break;
				}
			}
		}
		
		if(!found)
			m_easy.doMove();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(int i=0; i<Model.NUM_SQUARES; i++){
			if(MODEL.isSelected(i))
				m_memory.set(i, MODEL.idOf(i));
		}
	}

}
