import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        try {

//            tesseract.setDatapath("D:/Tess4J/tessdata");
            tesseract.setDatapath("C:\\Tess4J\\tessdata");

            String text
                    = tesseract.doOCR(new File("C:\\Users\\Diksha\\IdeaProjects\\OOP_Project\\images\\book.jpg"));
            System.out.print(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}