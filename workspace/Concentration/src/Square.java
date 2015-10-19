
public class Square {
	
	private int id;
	private boolean selected = false;
	
	public Square(int id){
		this.id = id;
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	public void select(){
		selected = true;
	}
	
	public void deselect(){
		selected = false;
	}
}
