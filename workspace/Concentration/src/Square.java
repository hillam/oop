
public class Square {
	/* 	
	 * matching squares will have matching ids, 
	 * and therefore matching images
	 */
	private int m_id;
	private boolean m_selected = false;
	private boolean m_found = false;
	
	public static final String[] IMAGES = {
		"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", 
		"7.jpg", "8.jpg", "9.jpg", "10.jpg", "11.jpg", "12.jpg"
	};
	
	public Square(int id){
		m_id = id;
	}
	
	public int getId(){
		return m_id;
	}
	
	public boolean isMatching(Square other){
		return other.m_id == m_id;
	}
	
	public boolean isSelected(){
		return m_selected;
	}
	
	public void select(){
		m_selected = true;
	}
	
	public void deselect(){
		m_selected = false;
	}
	
	public void find(){
		m_found = true;
	}
	
	public boolean isFound(){
		return m_found;
	}
	
	public String getImage(){
		return IMAGES[m_id];
	}

	public void reset(){
		m_selected = false;
		m_found = false;
	}
}
