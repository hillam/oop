
public interface IDecision {
	public void setYes(IDecision yes);
	public void setNo(IDecision no);
	public void setYesTerminal(String terminal);
	public void setNoTerminal(String terminal);
	public IDecision ask();
}
