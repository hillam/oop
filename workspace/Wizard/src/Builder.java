
public class Builder {
	
	private static Builder m_builder = null;
	
	private Builder(){}
	
	public static Builder getInstance(){
		if(m_builder == null)
			m_builder = new Builder();
		return m_builder;
	}
	
	public IDecision buildWizard(){
		IDecision d1 = new Decision("Do you want to buy a snowboard?");
		IDecision d2 = new Decision("Have you snowboarded before?");
		IDecision d3 = new Decision("Are you an expert?");
		IDecision d4 = new Decision("Do you like to go fast?");
		IDecision d5 = new Decision("Do you want to buy downhill skis?");
		IDecision d6 = new Decision("Have you gone skiing before?");
		IDecision d7 = new Decision("Are you an expert?");
		IDecision d8 = new Decision("Do you like to jump?");
		
		d1.setYes(d2);
		d1.setNo(d5);
		
		d2.setYes(d3);
		d2.setNoTerminal("Buy the XG100 model.");
		
		d3.setYes(d4);
		d3.setNoTerminal("Buy the XG200 model.");
		
		d4.setYesTerminal("Buy the XG300 model.");
		d4.setNoTerminal("Buy the XG200 model.");
		
		d5.setYes(d6);
		d5.setNoTerminal("You should go skiing someday.");
		
		d6.setYes(d7);
		d6.setNoTerminal("Buy the ZR100 model.");
		
		d7.setYes(d8);
		d7.setNoTerminal("Buy the ZR200 model.");
		
		d8.setYesTerminal("Buy the ZR300 model.");
		d8.setNoTerminal("Buy the ZR200 model.");
		
		return d1;
	}
}
