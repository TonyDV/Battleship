import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        int charAsNumber = reader.read();
        int wordsCount = 0;
        int spaceCode = (char) ' ';
        boolean wordFlag = false;
        while (charAsNumber != -1) {
            if (charAsNumber != spaceCode && !wordFlag) {
                wordFlag = true;
                wordsCount++;
            }
            if (charAsNumber == spaceCode && wordFlag) {
                wordFlag = false;
            }
            charAsNumber = reader.read();
        }
        reader.close();
        System.out.println(wordsCount);
    }
}