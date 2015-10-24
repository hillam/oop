
public class StrategyBuilder {

	public static IStrategy buildStrategy(String strat){
		IStrategy result = null;
		try {
			Class<?> strategy = Class.forName(strat + "Player");
			result = (IStrategy) strategy.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
