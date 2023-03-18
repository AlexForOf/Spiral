import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        Dimension dimension = new Dimension(1080, 1080);
        String fileName = "primes.bin";
        File file = new File(fileName);
        int maxNum = (dimension.height * dimension.width) * 100;
        WriteRead writeRead = new WriteRead(maxNum, file);
//        if (!file.exists()){
            writeRead.writeFile();
//        }
        System.out.println(Arrays.toString(writeRead.readFile()));
        new Spiral(maxNum, writeRead.readFile());
    }
}
