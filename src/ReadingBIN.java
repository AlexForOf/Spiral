import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadingBIN {
    public ArrayList<String[]> allStrings = new ArrayList<>();
    public int[] fullNumbers;
    int maxNum;
    public ReadingBIN(int maxNum){
        this.fullNumbers = new int[maxNum];
        this.maxNum = maxNum;
    }

    public int[] read() throws IOException{
        File file = new File("src/file/newFile.bin");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        int[] nums = new int[maxNum];
        int counter = 0;
        int c;
        while ((c = br.read()) != -1) {
            char character = (char) c;
            if(character != ' ' && character != '\n'){
                line += character;
            }else if(character == ' '){
                nums[counter] = Integer.parseInt(line);
//                br.read();
                line = "";
            }else if(character == '\n'){
                line = "";
            }
        counter++;
    }
        return nums;
}
public int[] getFullNumbers(){
        return fullNumbers;
}
}
