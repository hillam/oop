
public class StrategyBuilder {
	
	private static StrategyBuilder m_builder;
	private StrategyBuilder(){}
	public static StrategyBuilder getInstance(){
		if(m_builder == null)
			m_builder = new StrategyBuilder();
		return m_builder;
	}

	public IStrategy buildStrategy(String strat){
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
