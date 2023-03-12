import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
//        PrimeFinder primeFinder = new PrimeFinder();
//        primeFinder.isPrime();
    int maxNum = 66000;
//    WritingBIN writingBIN = new WritingBIN("src/file/newFile.bin", maxNum);
    ReadingBIN readingBIN = new ReadingBIN(maxNum);
    int[] primes = readingBIN.read();

//        System.out.println(Arrays.toString(nums));
//    System.out.println(Arrays.toString(readingBIN.allStrings.get(1)));
//        for (int i = 0; i < readingBIN.allStrings.toArray().length; i++) {
//            System.out.println(readingBIN.allStrings.toArray()[i]);
//        }


        new Box(maxNum, primes);

    }
}
