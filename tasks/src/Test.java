import org.apache.xmlbeans.XmlException;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, XmlException {
        Scanner scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/front.xml"));
        String sFront = "";
        String body = "";
        while(scanner.hasNext()){
            sFront = sFront + scanner.nextLine()+"\n";
        }
        sFront = sFront.substring(sFront.indexOf("<w:body>")+8,sFront.indexOf("</w:body>"));
        System.out.println(sFront);

        scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/back.xml"));
        String sBack = "";
        while(scanner.hasNext()){
            sBack = sBack + scanner.nextLine()+"\n";
        }
        sBack = sBack.substring(sBack.indexOf("<w:body>")+8,sBack.indexOf("</w:body>"));
        System.out.println(sBack);

        String form = "";
        scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/form/word/document.xml"));
        while(scanner.hasNext()){
            form = form + scanner.nextLine()+"\n";
        }
        System.out.println(form);

        body = sFront+sBack;
        form = form.replaceAll("BODY", body);

        System.out.println(form);

        FileWriter fw = new FileWriter("/home/after/ProjectNTU/tasksad/tasks/src/document.xml");
        fw.write(form);
        fw.flush();
    }
}

