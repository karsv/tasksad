
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Lecturer {
	private String name = null;
	private String groupName = null;
	private String info = "<html><body style=\"font-size: 12pt;\"><b><h1><tr><td>#</td><td>Name</td>"
			+ "<td>Prototype</td><td>Type</td><td>Cylinders</td><td>Ne</td>"
			+ "<td>n</td><td>Fuel</td><td>Detail</td><td>Phi</td></tr></h1></b><p>";
	private ArrayList<Student> tasks = new ArrayList();
	private int year;

        /**
         * Constructor for lecturer with number of variants
         * @param name
         * @param group
         * @param db
         * @param variants 
         */
	Lecturer(String name, ParserX group, DBtasks db, int[] variants) {
		setName(name);
		setYear();
		setGroupName(group.getGroupName());
		int zil130 = 0;
		int kamaz740 = 0;
		int memz245 = 0;
		int zmz53 = 0;
		int vaz341 = 0;
		int vaz1111 = 0;
		for (String s : group.getList()) {
			Student student = null;
			try {
				while (true) {
					student = new Student(s, db);
					if (student.getPrototype().equals("ЗІЛ-130")) {
						if (zil130 < variants[0]) {
							zil130++;
							break;
						} else {
							continue;
						}
					}
					if (student.getPrototype().equals("КамАЗ-740")) {
						if (kamaz740 < variants[1]) {
							kamaz740++;
							break;
						} else {
							continue;
						}
					}
					if (student.getPrototype().equals("МеМЗ-245")) {
						if (memz245 < variants[2]) {
							memz245++;
							break;
						} else {
							continue;
						}
					}
					if (student.getPrototype().equals("ЗМЗ-53")) {
						if (zmz53 < variants[3]) {
							zmz53++;
							break;
						} else {
							continue;
						}
					}
					if (student.getPrototype().equals("ВАЗ-341")) {
						if (vaz341 < variants[4]) {
							vaz341++;
							break;
						} else {
							continue;
						}
					}
					if (student.getPrototype().equals("ВАЗ-1111")) {
						if (vaz1111 < variants[5]) {
							vaz1111++;
							break;
						} else {
							continue;
						}
					}
				}

			} catch (SQLException e1) {
			}
			addTask(student);
		}

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setYear() {
		this.year = GregorianCalendar.getInstance().getWeekYear();
	}

	public void addTask(Student student) {
		this.tasks.add(student);
	}

        /**
         * get info of tasks for all students from group
         * @return 
         */
	public String getInfo() {
		for (int i = 0; i < tasks.size(); i++) {
			info = info + "<tr style=\"font-size: 10pt;\"><td>" + (i + 1) + "</td><td>" + tasks.get(i).getName() + "</td><td>"
					+ tasks.get(i).getPrototype() + "</td><td>" + tasks.get(i).getType() + "</td><td align= \"center\">"
					+ tasks.get(i).getCylinders() + "</td><td>" + tasks.get(i).getNe() + "</td><td>"
					+ tasks.get(i).getn() + "</td><td>" + tasks.get(i).getFuel() + "</td><td>"
					+ tasks.get(i).getDetail() + "</td><td>" + tasks.get(i).getPhi() + "</td></tr>";
		}
		info = info + "</p></body></html>";
		return info;
	}

	public ArrayList<Student> getTaskList() {
		return this.tasks;
	}

	public int getYear() {
		return this.year;
	}

	public String getName() {
		return this.name;
	}

	public String getShortName() {
		return this.name.substring(0, 5);
	}

	public String getGroupName() {
		return this.groupName;
	}
}
