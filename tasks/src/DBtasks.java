
import java.sql.*;

public class DBtasks {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	private String query = null;
	private String fuel = null;
	private String detail = null;
	private int phi;
	
	DBtasks() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/tasksad?useSSL=false&user=root&password=1");
		st = con.createStatement();
	}

        /**
         * Create a table of a lecturer group with tasks
         * @param lecturer
         * @throws SQLException 
         */
	public void createGroup(Lecturer lecturer) throws SQLException {
		query = "CREATE TABLE " + lecturer.getShortName() + lecturer.getGroupName().replaceAll("-", "") + lecturer.getYear()
				+ "(id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "name TEXT, type TEXT, Ne INTEGER, n INTEGER, fuel TEXT, cylinders TEXT, prototype TEXT, detail TEXT, phi INTEGER);";
		st.execute(query);
		for (Student student : lecturer.getTaskList()) {
			query = "INSERT INTO " + lecturer.getShortName() + lecturer.getGroupName().replaceAll("-", "") + lecturer.getYear()
					+ "(name, type, Ne, n, fuel, cylinders, prototype, detail, phi) VALUES('" + student.getName()
					+ "','" + student.getType() + "'," + student.getNe() + "," + student.getn() + ",'" + student.getFuel()
					+ "','" + student.getCylinders() + "','" + student.getPrototype() + "','" + student.getDetail() + "',"
					+ student.getPhi() + ");";
			st.execute(query);
		}
	}
	
        /**
         * get a random parameter phi from db 
         * @return phi
         * @throws SQLException 
         */
	public int getPhi() throws SQLException{
		query = "SELECT COUNT(*) FROM phi;";
		rs = st.executeQuery(query);
		if(rs.next()){
			query = "SELECT angle FROM phi WHERE id="+((int) (Math.random()*rs.getInt(1)))+";";
		}
		rs = st.executeQuery(query);
		if(rs.next()){
			phi = rs.getInt(1);
		}
		return phi; 
	}

        /**
         * get a random detail from db 
         * @return detail
         * @throws SQLException 
         */
	public String getDetail() throws SQLException{
		query = "SELECT COUNT(*) FROM details;";
		rs = st.executeQuery(query);
		if(rs.next()){
			query = "SELECT name FROM details WHERE id="+((int) (Math.random()*rs.getInt(1))+1)+";";
		}
		rs = st.executeQuery(query);
		if(rs.next()){
			detail = rs.getString(1);
		}
		return detail; 
	}
	
        /**
         * get a random engine from db 
         * @return engine
         * @throws SQLException 
         */
	public ResultSet getEngine() throws SQLException{
		query = "SELECT COUNT(*) FROM engines;";
		rs = st.executeQuery(query);
		if(rs.next()){
			query = "SELECT * FROM engines WHERE id ="+((int) (Math.random()*rs.getInt(1))+1)+";";
		}
		rs = st.executeQuery(query);
		return rs;
	}

        /**
         * get a random fuel from db 
         * @return fuel
         * @throws SQLException 
         */
	public String getFuel(String f) throws SQLException{
		switch (f){
			case "diesel":
				fuel = "diesel";
				break;
			case "petrol":
				query = "SELECT COUNT(*) FROM petrol;";
				rs = st.executeQuery(query);
				if(rs.next()){
					query = "SELECT name FROM petrol WHERE id="+(((int) (Math.random()*rs.getInt(1)))+1)+";";
				}
				rs = st.executeQuery(query);
				if(rs.next()){
					fuel = rs.getString(1);
				}
		}
		return fuel;
	}

        /**
         * close db connection
         * @throws SQLException 
         */
	public void closeDB() throws SQLException {
		rs.close();
		st.close();
		con.close();
	}

}
