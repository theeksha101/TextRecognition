import java.io.File;
import java.util.Scanner;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {

    public void scanFile(String img_file_name){

        Tesseract tesseract = new Tesseract();
        try {

//            tesseract.setDatapath("D:/Tess4J/tessdata");
            tesseract.setDatapath("C:\\Tess4J\\tessdata");

            String text
                    = tesseract.doOCR(new File("images/" + img_file_name +".jpg"));
            System.out.print(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Test test = new Test();

        Scanner sc = new Scanner(System.in);
        String img_file_name = sc.next();
        test.scanFile(img_file_name);
    }
}