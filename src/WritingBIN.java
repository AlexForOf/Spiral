import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class WritingBIN {
    public WritingBIN(String filePath, int maxNum) throws IOException{
        int numOfBytes = 1;


        OutputStreamWriter ous = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);

        BufferedWriter bwriter = new BufferedWriter(ous);
        PrimeFinder finder = new PrimeFinder();

        int counter = 0;
        boolean setLastCounter = false;

        StringBuilder stringBuilder = new StringBuilder();
        try{
            for (int i = 0; i < maxNum; i++) {
                System.out.print(i + " is prime? " + finder.isPrime(i) + " ");
                if ( ((31 - Integer.numberOfLeadingZeros(i)) / 8 + 1) == numOfBytes && finder.isPrime(i)){
                    stringBuilder.append(Integer.toString(i)).append(" ");
                    counter++;
                    if(setLastCounter) setLastCounter =! setLastCounter; //to false value
                }else if(((31 - Integer.numberOfLeadingZeros(i)) / 8 + 1) != numOfBytes && finder.isPrime(i)){
                    bwriter.write(Integer.toString(counter) + " ");
                    bwriter.write(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                    stringBuilder.append(Integer.toString(i)).append(" ");
//                    stringBuilder.append(Integer.toBinaryString(i)).append(" ");
                    bwriter.newLine();
                    numOfBytes++;
                    System.out.println("New line");
                    counter = 0;
                    setLastCounter = !setLastCounter; //to true value
                }
            }
            if(!setLastCounter){
                bwriter.write(Integer.toString(counter) + " ");
                bwriter.write(stringBuilder.toString());
                bwriter.newLine();
                System.out.println("New line");
            }
            bwriter.close();
        }catch (IOException e){
            throw e;
        }

    }

}
