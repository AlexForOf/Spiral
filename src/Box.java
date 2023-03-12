import java.awt.*;
import java.io.IOException;

public class Box extends Panel {
    public Box(int maxNum, int[] primes) throws IOException {
        Frame frame = new Frame();
        frame.setSize(1920, 1080);
        frame.add(new Spiral(maxNum, primes));
        frame.setVisible(true);
    }
}
