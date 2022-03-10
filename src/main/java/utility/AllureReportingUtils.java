package utility;


import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class AllureReportingUtils {

    static final String ProjectPath = "C:/Users/njakovljevic/IdeaProjects/PersonalSeleniumProject/";
    static final String ResultPath = "target/allure-results";
    static final String ReportPath = "target/allure-report";
    static final File dirFrom = new File(ProjectPath + ReportPath + "/history");
    static final File dirTo = new File(ProjectPath + ResultPath);
    static final File dirToHistory = new File(ProjectPath + ResultPath + "/history");

    public static void main() throws InterruptedException, IOException {
        if (dirFrom.exists() && dirTo.exists()) {
            moveFile();
            Thread.sleep(300);
            AllureEnvironmentSetup.main();
            Thread.sleep(300);
            generateAllureReport();
        } else if (dirTo.exists() && !dirFrom.exists()) {
            generateAllureReport();
            Thread.sleep(300);
            moveFile();
        }
    }


    public static void moveFile() throws IOException {

           FileUtils.copyDirectory(dirFrom, dirToHistory);

    }
    public static void generateAllureReport() throws IOException {

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "allure generate " + ProjectPath + ResultPath + " -o " + ProjectPath + ReportPath + " --clean");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }

    }



}


