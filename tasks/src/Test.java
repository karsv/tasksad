import org.apache.xmlbeans.XmlException;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, XmlException {
        Scanner scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/task_ad/word/document.xml"));
        String sFront = "";
        String body = "";
        while(scanner.hasNext()){
            sFront = sFront + scanner.nextLine()+"\n";
        }
        body = sFront.substring(sFront.indexOf("<w:body>")+8,sFront.indexOf("</w:body>"));

        scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/task_ad_back/word/document.xml"));
        String sBack = "";
        String bodyBack = "";
        while(scanner.hasNext()){
            sBack = sBack + scanner.nextLine()+"\n";
        }
        bodyBack = sBack.substring(sBack.indexOf("<w:body>")+8,sBack.indexOf("</w:body>"));

        sFront = sFront.replaceAll(sFront.substring(sFront.indexOf("<w:body>")+8,sFront.indexOf("</w:body>")), body);
        System.out.println(body);
    }
}

