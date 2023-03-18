import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.Arrays;

public class Spiral extends Frame {

    int maxNum;
    int[] primes;

    public Spiral(int maxNum, int[] primes) throws HeadlessException {
        addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        super.componentResized(e);
                        repaint();
                    }
                }
        );
        this.setSize(1080, 1080);
        this.setVisible(true);

        this.maxNum = maxNum;
        this.primes = primes;

    }
    @Override
    public void paint(Graphics g){

        int x = (int)this.getSize().getWidth() / 2;
        int y = (int)this.getSize().getHeight() / 2;
        int currentPrime = 0;
        int stepMax = 1;
        int stepToIncrease = 0;
        int stepCurrent = 0;

        int red = 220;
        boolean redFlag = false;

        boolean axis = false;
        boolean sign = true;

        for (int i = 1; i < maxNum; i++) {
                if (i == primes[currentPrime]) {
                    g.setColor(new Color(255,255,255));
                    if(currentPrime < primes.length - 1){
                        currentPrime++;
                    }
                    System.out.println(currentPrime);
                }
                else{g.setColor(new Color(red, 0, 0));}
            g.fillRect(x, y, 1, 1);


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
        }
    }
}
