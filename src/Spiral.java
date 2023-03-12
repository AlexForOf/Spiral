import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class Spiral extends Component {

    PrimeFinder primesToDisplay;
//    ReadingBIN numbers;
    int maxNum;
    int[] primes;

    public Spiral(int maxNum, int[] primes) throws IOException {
//        this.primesToDisplay = primes;
        this.maxNum = maxNum;
//        this.numbers = new ReadingBIN(maxNum);
        this.primes = primes;

    }
    @Override
    public void paint(Graphics g){

//        g.drawLine(0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getHeight());
//        g.drawLine((int)this.getSize().getWidth(), 0, 0, (int)this.getSize().getHeight());
//        g.setColor(Color.orange);
//        g.fillRect((int)(this.getSize().getWidth()/2 - 4), (int)(this.getSize().getHeight()/2 - 4), 10, 10);
        int x = (int)this.getSize().getWidth() / 2;
        int y = (int)this.getSize().getHeight() / 2;
        int counter = 0;
        int stepMax = 1;
        int stepToIncrease = 0;
        int stepCurrent = 0;

        int red = 220;
        boolean redFlag = false;

        boolean axis = false;
        boolean sign = true;
//        while (counter < maxNum){
//            for (int i = 0; i < numbers.allStrings.size(); i++) {
//                for (int j = 0; j < numbers.allStrings.get(i).length; j++) {
//                    System.out.println(numbers.allStrings.get(i)[j]);
//                    if(numbers.allStrings.get(i)[j] != null)
//                        if (counter == Integer.parseInt(numbers.allStrings.get(i)[j])) {
//                            g.setColor(new Color(255,255,255));
//                            System.out.println(Integer.parseInt(numbers.allStrings.get(i)[j]));
//                        }
//                        else{g.setColor(new Color(red, 0, 0));}
////                System.out.println();
//                g.fillRect(x, y, 1, 1);
//
////                System.out.println("X: " + x + " Y: " + y);
//
//                if(redFlag){
//                    red++;
//                }else{
//                    red--;
//                }
//                if(red == 220 || red == 40){
//                    redFlag = !redFlag;
//                }
//                if(stepCurrent == stepMax) {
//                    axis = !axis;
//                    stepToIncrease++;
//                    stepCurrent = 0;
//                }
//                if(stepToIncrease == 2){
//                    sign = !sign;
//                    stepToIncrease = 0;
//                    stepMax++;
//                }
//                if(!axis){
//                    if(sign){
//                        x+= 1;
//                    }else {
//                        x-= 1;
//                    }
//                }else{
//                    if(sign){
//                        y -= 1;
//                    }else {
//                        y += 1;
//                    }
//                }
//                stepCurrent++;
//                counter++;

//                }
//
//            }
//        }
//        System.out.println(numbers.fullNumbers[2] + " aaa");
//        int[] primes = numbers.read();
        for (int i = 0; i < maxNum; i++) {
//            if(numbers.allStrings.get(i)[j] != null)
                if (i == primes[i]) {
                    g.setColor(new Color(255,255,255));
//                    System.out.println(Integer.parseInt(numbers.allStrings.get(i)[j]));
                }
                else{g.setColor(new Color(red, 0, 0));}
//                System.out.println();
            g.fillRect(x, y, 1, 1);

//                System.out.println("X: " + x + " Y: " + y);

            if(redFlag){
                red++;
            }else{
                red--;
            }
            if(red == 220 || red == 40){
                redFlag = !redFlag;
            }
            if(stepCurrent == stepMax) {
                axis = !axis;
                stepToIncrease++;
                stepCurrent = 0;
            }
            if(stepToIncrease == 2){
                sign = !sign;
                stepToIncrease = 0;
                stepMax++;
            }
            if(!axis){
                if(sign){
                    x+= 1;
                }else {
                    x-= 1;
                }
            }else{
                if(sign){
                    y -= 1;
                }else {
                    y += 1;
                }
            }
            stepCurrent++;
//            counter++;
        }
    }
}
