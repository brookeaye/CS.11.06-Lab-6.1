import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        writeFileAllAnswers("I Know How to Pilot Submarines", challengeOne("inputOneTwo.txt"), challengeTwo("inputOneTwo.txt"), challengeThree("inputThreeFour.txt"), challengeFour("inputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] array = readFile(fileName);
        int count = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i] > array[i-1]){
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int letterNum = countLinesInFile(fileName) -2;
        int[] array = readFile(fileName);
        int sum = array[0] + array[1] + array[2];
        int count = 0;
        for (int i = 1; i <= letterNum-2; i++){
            if (array[i] + array[i+1] + array[i+2] > sum){
                count++;
            }
            sum = array[i] + array[i+1] + array[i+2];
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int horiz = 0;
        int depth = 0;
        String[] instructions = readFileString(fileName);
        int[] nums = readFileNums(fileName);

        for (int i = 0; i < instructions.length; i++){
            if (instructions[i].equals("forward")){
                horiz+=nums[i];
            }
            if (instructions[i].equals("down")){
                depth+=nums[i];
            }
            if (instructions[i].equals("up")){
                depth-=nums[i];
            }
        }
        return horiz * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int aim = 0;
        int horiz = 0;
        int depth = 0;
        String[] instructions = readFileString(filename);
        int[] nums = readFileNums(filename);
        for (int i = 0; i < instructions.length; i++){
            if (instructions[i].equals("forward")){
                horiz+=nums[i];
                depth+= aim * nums[i];
            }
            if (instructions[i].equals("up")){
                aim-=nums[i];
            }
            if (instructions[i].equals("down")){
                aim+=nums[i];
            }
        }
        return horiz * depth;
    }


    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readFileString(String inputFileName) throws FileNotFoundException{
        File file = new File(inputFileName);
        Scanner scanner = new Scanner(file);
        String[] array = new String[countLinesInFile(inputFileName)];
        String line = "";
        for (int i = 0; i < array.length; i++){
            line = scanner.nextLine();
            for (int j = 0; j < array.length; j++) {
                if (line.charAt(j) == ' ') {
                    array[i] = line.substring(0, j);
                    break;
                }
            }
        }
        return array;
    }

    private static int[] readFileNums(String inputFileName) throws FileNotFoundException{
        File file = new File(inputFileName);
        Scanner scanner = new Scanner(file);
        int[] array = new int[countLinesInFile(inputFileName)];
        String line = "";
        for (int i = 0; i < array.length; i++){
            line = scanner.nextLine();
            for (int j = line.length()-1; j > 0; j--){
                if (line.charAt(j) == ' '){
                    array[i] = Integer.parseInt(line.substring(j+1, line.length()));
                    break;
                }
            }
        }
        return array;
    }

}