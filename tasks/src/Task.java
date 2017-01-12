
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Task {
	private String fuel = null;
	private String cylinders = null;
	private String type = null;
	private String prototype = null;
	private String detail = null;
	private int n;
	private int Ne;
	private int phi;

        /**
         * set random task from db
         * @param db
         * @throws SQLException 
         */
	public void setTask(DBtasks db) throws SQLException {
		setPhi(db.getPhi());
		setDetail(db.getDetail());
		ResultSet rs = db.getEngine();
		if (rs.next()) {
			setPrototype(rs.getString(2));
			setCylinders(rs.getString(8));
			setType(rs.getString(3));
			setN((int) ((rs.getInt(5) - rs.getInt(4)) * Math.random() + rs.getInt(4)) / 50 * 50);
			setNe((int) ((rs.getInt(7) - rs.getInt(6)) * Math.random() + rs.getInt(6)) / 2 * 2);
			setFuel(db.getFuel(rs.getString(9)));
		}
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public void setCylinders(String cylinders) {
		this.cylinders = cylinders;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void setNe(int Ne) {
		this.Ne = Ne;
	}

	public void setPhi(int phi) {
		this.phi = phi;
	}

	public String getFuel() {
		return this.fuel;
	}

	public String getCylinders() {
		return this.cylinders;
	}

	public String getType() {
		return this.type;
	}

	public String getPrototype() {
		return this.prototype;
	}

	public String getDetail() {
		return this.detail;
	}

	public int getn() {
		return this.n;
	}

	public int getNe() {
		return this.Ne;
	}

	public int getPhi() {
		return this.phi;
	}
}
