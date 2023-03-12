import java.util.Arrays;

public class PrimeFinder {
//    boolean[] arePrimes;
//    int maxNumber;
//
//    public PrimeFinder(int number){
//        this.arePrimes = new boolean[number+1];
//        this.maxNumber = number;
//        Arrays.fill(arePrimes,true);
//    }

//    public void isPrime(){
//        arePrimes[0] = arePrimes[1] = false;
//        for (int i = 2; i <= Math.sqrt(maxNumber); i++)
//        {
//            if (arePrimes[i])
//            {
//                for (int j = 2; i * j <= maxNumber; j++) {
//                    arePrimes[i * j] = false;
//                }
//            }
//        }
//    }
public boolean isPrime(int number){
    if (number == 0 || number == 1) return false;
    for (int i = 2; i <= Math.sqrt(number); i++){
        if (number % i == 0) return false;
    }
    return true;
}

}
