
import java.sql.SQLException;

public class Student extends Task{
	private String name = null;
	

	Student(String name, DBtasks db) throws SQLException {
		setName(name);
		setTask(db);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	
}
