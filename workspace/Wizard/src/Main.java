
public class Main {

	public static void main(String[] args) {
		IDecision next = Builder.getInstance().buildWizard();
		 do
		 {
			 next = next.ask();
		 } while (next != null);
	}

}
