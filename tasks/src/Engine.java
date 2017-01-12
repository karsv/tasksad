import java.sql.SQLException;



public class Engine {
	
private static Engine engine = null;
	
	private Engine() throws ClassNotFoundException, SQLException{
		View engine = new View();
	}
	
        /**
         * single tone
         * @return
         * @throws ClassNotFoundException
         * @throws SQLException 
         */
	public static Engine start() throws ClassNotFoundException, SQLException{
		if(engine == null){
			engine = new Engine();
		}
		return engine;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		start();
	}

}
