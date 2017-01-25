import java.io.*;
import java.util.Scanner;

public class DOCXTaskCreator {

    DOCXTaskCreator(Lecturer lecturer, File location){
        creatorDOCXDirect(bodyDocumentXml(lecturer), location.getAbsolutePath());
    }

    public String bodyDocumentXml(Lecturer lecturer){
        Scanner scanner = null;
        String sFront = "";
        String body = "";
        int i = 1;
        try {
            scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/front.xml"));
            while(scanner.hasNext()){
                sFront = sFront + scanner.nextLine()+"\n";
            }
            sFront = sFront.substring(sFront.indexOf("<w:body>")+8,sFront.indexOf("</w:body>"));
            for(Student st : lecturer.getTaskList()){
                sFront = sFront.replaceAll("NUM", Integer.toString(i));
                sFront = sFront.replaceAll("GROUP", lecturer.getGroupName());
                sFront = sFront.replaceAll("TYPE", st.getType());
                sFront = sFront.replaceAll("NE", Integer.toString(st.getNe()));
                sFront = sFront.replaceAll("ND", Integer.toString(st.getn());
                sFront = sFront.replaceAll("FUEL", st.getFuel());
                sFront = sFront.replaceAll("CYLINDERS", st.getCylinders());
                sFront = sFront.replaceAll("PROTOTYPE", st.getPrototype());
                sFront = sFront.replaceAll("DETAIL", st.getDetail());
                sFront = sFront.replaceAll("PHI", Integer.toString(st.getPhi());
                body = body + sFront;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String sBack = "";
        try {
            scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/back.xml"));
            while(scanner.hasNext()){
                sBack = sBack + scanner.nextLine()+"\n";
            }
            sBack = sBack.substring(sBack.indexOf("<w:body>")+8,sBack.indexOf("</w:body>"));
            body = body + sBack;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String form = "";
        try {
            scanner = new Scanner(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/form/word/document.xml"));
            while(scanner.hasNext()){
                form = form + scanner.nextLine()+"\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        form = form.replaceAll("BODY", body);

        return form;
    }

    public void creatorDOCXDirect(String body, String targetLoc) {
        File file = new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/form/word/document.xml");
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            fw.write(body);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            copyDirectory(new File("/home/after/ProjectNTU/tasksad/tasks/src/Patterns/form/word/"), new File(targetLoc));
            if (new File(targetLoc).isDirectory()) {
                new File(targetLoc).renameTo(new File(targetLoc+".docx"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void copyDirectory(File sourceLocation , File targetLocation)
            throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

}
