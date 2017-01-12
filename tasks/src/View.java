
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class View extends JFrame {
	private JButton enter = null;
	private JButton exit = null;

	private JTextField login = null;
	private JLabel label1 = null;
	private JPasswordField password = null;
	private JLabel label2 = null;

	private JPanel loginMenu = null;

	// Main menu
	private JPanel mainMenu = null;

	private JButton bGetGroup = null;
	private JButton bWrite = null;
	private JButton bGenerate = null;
	private JButton bExitMain = null;

	private JFileChooser jfile = null;

	private JTextPane info = null;
//	private JTextArea info = null;
	private JScrollPane scroll = null;

	private JComboBox<Integer> cbMemz = null;
	private JComboBox<Integer> cbZil = null;
	private JComboBox<Integer> cbKamaz = null;
	private JComboBox<Integer> cbZmz = null;
	private JComboBox<Integer> cbVaz1111 = null;
	private JComboBox<Integer> cbVaz341 = null;

	private JLabel label3 = null;
	private JLabel label4 = null;
	private JLabel label5 = null;
	private JLabel label6 = null;
	private JLabel label7 = null;
	private JLabel label8 = null;

	private JLabel lFreeVar = null;

	private File file = null;
	private XMLParser xmlp = new XMLParser();
	private ParserX parser = null;
	private Lecturer lecturer = null;
	private DBtasks db = null;

	View() {
		super("Tasks");
		try {
			db = new DBtasks();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		loginMenu = new JPanel();
		loginMenu.setVisible(true);
		loginMenu.setLayout(null);

		enter = new JButton("Enter");
		loginMenu.add(enter);
		enter.setSize(100, 25);
		enter.setLocation(195, 275);

		exit = new JButton("Exit");
		exit.setSize(100, 25);
		exit.setLocation(305, 275);
		loginMenu.add(exit);

		login = new JTextField();
		login.setSize(210, 25);
		login.setLocation(195, 175);
		loginMenu.add(login);

		label1 = new JLabel();
		label1.setText("Login:");
		label1.setLocation(195, 150);
		label1.setSize(70, 25);
		loginMenu.add(label1);

		password = new JPasswordField();
		password.setSize(210, 25);
		password.setLocation(195, 225);
		loginMenu.add(password);

		label1 = new JLabel("Password:");
		label1.setLocation(195, 200);
		label1.setSize(100, 25);
		loginMenu.add(label1);

		mainMenu = new JPanel();
		mainMenu.setVisible(false);
		mainMenu.setLayout(null);

		setContentPane(loginMenu);
		setSize(600, 400);

		// Main menu
		bGetGroup = new JButton("File...");
		bGetGroup.setSize(100, 50);
		bGetGroup.setLocation(490, 10);
		mainMenu.add(bGetGroup);

		bGenerate = new JButton("Generate");
		bGenerate.setSize(100, 50);
		bGenerate.setLocation(490, 70);
		mainMenu.add(bGenerate);

		bWrite = new JButton("Write to DB");
		bWrite.setSize(100, 50);
		bWrite.setLocation(490, 130);
		mainMenu.add(bWrite);

		bExitMain = new JButton("Exit");
		bExitMain.setSize(100, 50);
		bExitMain.setLocation(490, 190);
		mainMenu.add(bExitMain);

		info = new JTextPane();
		info.setContentType("text/html");
		info.setEditable(false);
		scroll = new JScrollPane(info);
		scroll.setLocation(0, 0);
		scroll.setSize(480, 200);
		mainMenu.add(scroll);

		cbMemz = new JComboBox<>();
		cbMemz.setSize(40, 20);
		cbMemz.setLocation(90, 210);
		cbMemz.setEditable(false);
		mainMenu.add(cbMemz);

		label3 = new JLabel();
		label3.setText("MeMZ-245");
		label3.setSize(80, 20);
		label3.setLocation(5, 210);
		mainMenu.add(label3);

		cbZil = new JComboBox<>();
		cbZil.setSize(40, 20);
		cbZil.setLocation(90, 240);
		cbZil.setEditable(false);
		mainMenu.add(cbZil);

		label4 = new JLabel();
		label4.setText("ZIL-130");
		label4.setSize(80, 20);
		label4.setLocation(5, 240);
		mainMenu.add(label4);

		cbKamaz = new JComboBox<>();
		cbKamaz.setSize(40, 20);
		cbKamaz.setLocation(90, 270);
		cbKamaz.setEditable(false);
		mainMenu.add(cbKamaz);

		label5 = new JLabel();
		label5.setText("KAMAZ-740");
		label5.setSize(80, 20);
		label5.setLocation(5, 270);
		mainMenu.add(label5);

		cbZmz = new JComboBox<>();
		cbZmz.setSize(40, 20);
		cbZmz.setLocation(245, 210);
		cbZmz.setEditable(false);
		mainMenu.add(cbZmz);

		label6 = new JLabel();
		label6.setText("ZMZ-53");
		label6.setSize(80, 20);
		label6.setLocation(140, 210);
		mainMenu.add(label6);

		cbVaz341 = new JComboBox<>();
		cbVaz341.setSize(40, 20);
		cbVaz341.setLocation(245, 240);
		cbVaz341.setEditable(false);
		mainMenu.add(cbVaz341);

		label7 = new JLabel();
		label7.setText("VAZ-341");
		label7.setSize(80, 20);
		label7.setLocation(140, 240);
		mainMenu.add(label7);

		cbVaz1111 = new JComboBox<>();
		cbVaz1111.setSize(40, 20);
		cbVaz1111.setLocation(245, 270);
		cbVaz1111.setEditable(false);
		mainMenu.add(cbVaz1111);

		label8 = new JLabel();
		label8.setText("VAZ-1111");
		label8.setSize(80, 20);
		label8.setLocation(140, 270);
		mainMenu.add(label8);

		lFreeVar = new JLabel();
		lFreeVar.setSize(210, 20);
		lFreeVar.setLocation(5, 300);
		mainMenu.add(lFreeVar);

		jfile = new JFileChooser("/home/afterlie/Workspace/Java/ITEA/src/tasks");

		info.setVisible(true);

		addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent event) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(event.getWindow(), "Do you want to close?", "?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					event.getWindow().setVisible(false);
					;
					System.exit(0);
				}
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		initAction();
	}

	public void initAction() {
		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (xmlp.aproveLogin(login.getText(), password.getPassword())) {
					loginMenu.setVisible(false);
					setContentPane(mainMenu);
					info.setText("Hello " + login.getText() + "!");
					mainMenu.setVisible(true);
				}
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		bExitMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		bGetGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int choice = jfile.showOpenDialog(mainMenu);

				if (choice == JFileChooser.APPROVE_OPTION) {
					file = jfile.getSelectedFile();
					parser = new ParserX(file);
					for (String s : parser.getList()) {
							nStudents++;
					}
					setNumberVar(nStudents);
					info.setText(file.getPath());
				}
				;
			}
		});

		bGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (file == null) {
					info.setText("Please, choose file!");
				} else if(nVariants != 0){
					info.setText("Please, choose all variants!");
				} else {
					lecturer = new Lecturer(login.getText(), parser, db, variants);
					info.setText(lecturer.getInfo());
				}
			}
		});

		bWrite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lecturer == null) {
					info.setText("Enter group by choosing file!");
				} else {
					try {
						db.createGroup(lecturer);
					} catch (SQLException e1) {
						info.setText(e1.toString());
					}
					lecturer = null;
				}
			}
		});

		cbMemz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbMemz.getSelectedIndex() != 0) {
//					setMemz();
					setZil();
					setKamaz();
					setVaz341();
					setVaz1111();
					setZmz();
				}
			}
		});

		cbZil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbZil.getSelectedIndex() != 0) {
					setMemz();
//					setZil();
					setKamaz();
					setVaz341();
					setVaz1111();
					setZmz();
				}
			}
		});

		cbKamaz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbKamaz.getSelectedIndex() != 0) {
					setMemz();
					setZil();
//					setKamaz();
					setVaz341();
					setVaz1111();
					setZmz();
				}
			}
		});

		cbZmz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbZmz.getSelectedIndex() != 0) {
					setMemz();
					setZil();
					setKamaz();
					setVaz341();
					setVaz1111();
//					setZmz();
				}
			}
		});

		cbVaz341.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbVaz341.getSelectedIndex() != 0) {
					setMemz();
					setZil();
					setKamaz();
//					setVaz341();
					setVaz1111();
					setZmz();
				}
			}
		});


		cbVaz1111.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbVaz1111.getSelectedIndex() != 0) {
					setMemz();
					setZil();
					setKamaz();
					setVaz341();
//					setVaz1111();
					setZmz();
				}
			}
		});

	}

	private int nStudents = 0;
	private int nMemz = 0;
	private int nZil = 0;
	private int nKamaz = 0;
	private int nZmz = 0;
	private int nVaz341 = 0;
	private int nVaz1111 = 0;
	private int nVariants = 0;

	private int[] variants = new int[6];

	private void setNumberVar(int nStudents) {
		for (int i = 0; i <= nStudents; i++) {
			cbMemz.addItem(i);
			cbZil.addItem(i);
			cbKamaz.addItem(i);
			cbZmz.addItem(i);
			cbVaz341.addItem(i);
			cbVaz1111.addItem(i);
		}
	}

	private void setMemz() {
		nMemz = cbMemz.getSelectedIndex() != -1 ? cbMemz.getSelectedIndex() : nMemz;
		variants[2] = nMemz;
		cbMemz.removeAllItems();
		nVariants = nStudents - nMemz - nZil - nKamaz- nVaz341-nVaz1111-nZmz;
		for (int i = 0; i <= (nVariants + nMemz); i++) {
			cbMemz.addItem(i);
		}
		cbMemz.setSelectedIndex(nMemz);
		lFreeVar.setText(sVariants(nVariants));
	}

	private void setZil() {
		nZil = cbZil.getSelectedIndex() != -1 ? cbZil.getSelectedIndex() : nZil;
		variants[0] = nZil;
		cbZil.removeAllItems();
		nVariants = nStudents - nMemz - nZil - nKamaz- nVaz341-nVaz1111-nZmz;
		for (int i = 0; i <= (nVariants + nZil); i++) {
			cbZil.addItem(i);
		}
		cbZil.setSelectedIndex(nZil);
		lFreeVar.setText(sVariants(nVariants));
	}
	
	private void setKamaz() {
		nKamaz = cbKamaz.getSelectedIndex() != -1 ? cbKamaz.getSelectedIndex() : nKamaz;
		variants[1] = nKamaz;
		cbKamaz.removeAllItems();
		nVariants = nStudents - nMemz - nZil - nKamaz- nVaz341-nVaz1111-nZmz;
		for (int i = 0; i <= (nVariants + nKamaz); i++) {
			cbKamaz.addItem(i);
		}
		cbKamaz.setSelectedIndex(nKamaz);
		lFreeVar.setText(sVariants(nVariants));
	}

	private void setZmz() {
		nZmz = cbZmz.getSelectedIndex() != -1 ? cbZmz.getSelectedIndex() : nZmz;
		variants[3] = nZmz;
		cbZmz.removeAllItems();
		nVariants = nStudents - nMemz - nZil - nKamaz - nVaz341-nVaz1111-nZmz;
		for (int i = 0; i <= (nVariants + nZmz); i++) {
			cbZmz.addItem(i);
		}
		cbZmz.setSelectedIndex(nZmz);
		lFreeVar.setText(sVariants(nVariants));
	}

	private void setVaz341() {
		nVaz341 = cbVaz341.getSelectedIndex() != -1 ? cbVaz341.getSelectedIndex() : nVaz341;
		variants[4] = nVaz341;
		cbVaz341.removeAllItems();
		nVariants = nStudents - nMemz - nZil - nKamaz - nVaz341-nVaz1111-nZmz;
		for (int i = 0; i <= (nVariants + nVaz341); i++) {
			cbVaz341.addItem(i);
		}
		cbVaz341.setSelectedIndex(nVaz341);
		lFreeVar.setText(sVariants(nVariants));
	}

	private void setVaz1111() {
		nVaz1111 = cbVaz1111.getSelectedIndex() != -1 ? cbVaz1111.getSelectedIndex() : nVaz1111;
		variants[5] = nVaz1111;
		cbVaz1111.removeAllItems();
		nVariants = nStudents - nMemz - nZil - nKamaz - nVaz341-nVaz1111-nZmz;
		for (int i = 0; i <= (nVariants + nVaz1111); i++) {
			cbVaz1111.addItem(i);
		}
		cbVaz1111.setSelectedIndex(nVaz1111);
		lFreeVar.setText(sVariants(nVariants));
	}

	private String sVariants(int nVariants){
		String s ="There are " + nVariants + " free variants";
		return s;
	}
}
