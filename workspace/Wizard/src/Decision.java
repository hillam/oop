import java.util.Scanner;

public class Decision implements IDecision {
	
	private String m_question = "";
	private IDecision m_yes = null;
	private IDecision m_no = null;
	private String m_yesTerminal = "";
	private String m_noTerminal = "";
	
	public Decision(String question){
		m_question = question;
	}

	@Override
	public void setYes(IDecision yes) {
		m_yes = yes;
	}

	@Override
	public void setNo(IDecision no) {
		m_no = no;
	}

	@Override
	public void setYesTerminal(String terminal) {
		m_yesTerminal = terminal;
	}

	@Override
	public void setNoTerminal(String terminal) {
		m_noTerminal = terminal;
	}

	@Override
	public IDecision ask() {		
		Scanner keybd = new Scanner(System.in);
		String input = "";
		IDecision decision = null;
		String terminal = "";
		boolean flag;
		
		do{
			System.out.println(m_question);
			input = keybd.nextLine();
			
			if(input.equals("yes")){
				decision = m_yes;
				terminal = m_yesTerminal;
				flag = false;
			}
			else if(input.equals("no")){
				decision = m_no;
				terminal = m_noTerminal;
				flag = false;
			}
			else{
				System.out.println("Invalid input. Please enter yes or no.");
				flag = true;
			}
		} while(flag);
		
		if(decision == null){
			System.out.println(terminal);
		}
		
		//keybd.close();
		return decision;
	}

}
