import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteRead {

    int maxValue;
    File fileName;

    ArrayList<Integer> primeNumbers = new ArrayList<>();
    long[] allPrimes;

    public WriteRead(int maxValue, File fileName){
        this.maxValue = maxValue;
        this.fileName = fileName;
    }

    public boolean isPrime(int number){
        if (number == 0 || number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }
        return true;
    }

    public int[] readFile() throws IOException{
        int[] allValues;

        try (InputStream fis = new FileInputStream(fileName)) {

            int length = 0;
            for (int i = 0; i < allPrimes.length; i++) {
                length += (int) allPrimes[i];
            }
            allValues = new int[length];

            int i = 0;
            int counter = 0;
            int am_of_bytes = 0;
            while (fis.available() != 0) {
                if (i == 0 || i == 251 || i == 65521 || i == 16777213) {
                    long n = 0L;
                    n |= ((fis.read() & 0xFFL));
                    n |= ((fis.read() & 0xFFL) << 8);
                    n |= ((fis.read() & 0xFFL) << 16);
                    n |= ((fis.read() & 0xFFL) << 24);
                    n |= ((fis.read() & 0xFFL) << 32);
                    n |= ((fis.read() & 0xFFL) << 40);
                    n |= ((fis.read() & 0xFFL) << 48);
                    n |= ((fis.read() & 0xFFL) << 56);
                    am_of_bytes++;
                }
                i = 0;
                switch (am_of_bytes) {
                    case 1:
                        i |= ((fis.read() & 0xFF));
                        break;
                    case 2:
                        i |= ((fis.read() & 0xFF));
                        i |= ((fis.read() & 0xFF) << 8);
                        break;
                    case 3:
                        i |= ((fis.read() & 0xFF));
                        i |= ((fis.read() & 0xFF) << 8);
                        i |= ((fis.read() & 0xFF) << 16);
                        break;
                    case 4:
                        i |= ((fis.read() & 0xFF));
                        i |= ((fis.read() & 0xFF) << 8);
                        i |= ((fis.read() & 0xFF) << 16);
                        i |= ((fis.read() & 0xFF) << 24);
                        break;
                }
                allValues[counter] = i;
                counter++;

            }
        }
        return allValues;
    }

    public void writeFile() throws IOException {

        try (OutputStream ous = new FileOutputStream(fileName))
        {
            int am_of_bytes = 1;


            long primesForOneByte = 0L;
            long primesForTwoBytes = 0L;
            long primesForThreeBytes = 0L;
            long primesForFourBytes = 0L;
            allPrimes = new long[4];


            for (int i = 1; i < maxValue; i++){
                if( ( ( 31 - Integer.numberOfLeadingZeros(i) ) / 8 + 1 ) != am_of_bytes){
                    am_of_bytes++;
                }
                if(isPrime(i)) {
                    switch (am_of_bytes) {
                        case 1:
                            primesForOneByte++;
                            break;
                        case 2:
                            primesForTwoBytes++;
                            break;
                        case 3:
                            primesForThreeBytes++;
                            break;
                        case 4:
                            primesForFourBytes++;
                            break;
                    }
                    primeNumbers.add(i);
                }
            }

            allPrimes[0] = primesForOneByte;
            allPrimes[1] = primesForTwoBytes;
            allPrimes[2] = primesForThreeBytes;
            allPrimes[3] = primesForFourBytes;

            am_of_bytes = 0;

            for (int i = 0; i < primeNumbers.size(); i++) {

                if( ( ( 31 - Integer.numberOfLeadingZeros(primeNumbers.get(i)) ) / 8 + 1 ) != am_of_bytes){
                    ous.write( (byte) (allPrimes[am_of_bytes]) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 8) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 16) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 24) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 32) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 40) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 48) );
                    ous.write( (byte) (allPrimes[am_of_bytes] >> 54) );
                    am_of_bytes++;
                }
                switch (am_of_bytes){
                    case 1:
                        ous.write((primeNumbers.get(i)) & 0xff);
                        break;
                    case 2:
                        ous.write((primeNumbers.get(i)) & 0xff);
                        ous.write((primeNumbers.get(i) >> 8) & 0xff);
                        break;
                    case 3:
                        ous.write((primeNumbers.get(i)) & 0xff);
                        ous.write((primeNumbers.get(i) >> 8) & 0xff);
                        ous.write((primeNumbers.get(i) >> 16) & 0xff);
                        break;
                    case 4:
                        ous.write((primeNumbers.get(i)) & 0xff);
                        ous.write((primeNumbers.get(i) >> 8) & 0xff);
                        ous.write((primeNumbers.get(i) >> 16) & 0xff);
                        ous.write((primeNumbers.get(i) >> 24) & 0xff);
                        break;
                }
            }
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new IOException(e);
        }
    }
}
