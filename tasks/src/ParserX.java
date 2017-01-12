
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParserX {
	private ArrayList<String> xlsfile = null;
	private ArrayList<String> list = null;
	private FileInputStream fis = null;
	private String group = null;
	
	ParserX(File file){
		getXLS(file);
	}

	public void getXLS(File file){
		xlsfile = new ArrayList<>();
		list = new ArrayList<>();
		try {
			fis = new FileInputStream(file);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					xlsfile.add(cell.getStringCellValue());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < xlsfile.size(); i++){
			if(i == 0){
				group = xlsfile.get(i);
			}else if(i%2 == 0){
				list.add(xlsfile.get(i));
			}
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getList(){
		return list;
	}

	public String getGroupName(){
		return group;
	}

}		
	

