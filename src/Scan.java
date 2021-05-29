import java.io.File;
import java.util.Scanner;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.swing.*;

public class Scan {

    JFrame frame ;

    public void scanFile(String img_file_name){

        frame = new JFrame();

        Tesseract tesseract = new Tesseract();
        try {

//            tesseract.setDatapath("D:/Tess4J/tessdata");
            tesseract.setDatapath("C:\\Tess4J\\tessdata");

            String text
                    = tesseract.doOCR(new File("images/" + img_file_name +".jpg"));

            JOptionPane.showMessageDialog(frame, text);

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scan scan = new Scan();

        Scanner sc = new Scanner(System.in);
        String img_file_name = sc.next();
        scan.scanFile(img_file_name);
    }
}