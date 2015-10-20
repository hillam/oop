#	Concentration Game

###	Square
* 	String m_image
* 	boolean m_found
* 	boolean m_flipped

###	SquareView
* 	is an Observer
*	re-draw all FancyButtons
* 	FancyButton[] m_squares
* 	Controller m_controller

### FancyButton
* 	is not an Observer
* 	int m_row
* 	int m_col
* 	no border by default
*	border & image (image is set by SquareView)
