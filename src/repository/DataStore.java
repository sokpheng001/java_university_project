package repository;

import java.io.*;

import java.util.Map;
import java.util.TreeMap;


public class DataStore {
    public static Map<String, String> getAllWords(){
        Map<String, String> stringStringMap = new TreeMap<>();
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("dataStore/words.txt"))
                )
        {
            String word;
            while (true){
                if((word = bufferedReader.readLine())!=null){
                    String [] result = word.split(":");
//                    System.out.println(Arrays.toString(result));
                    stringStringMap.put(result[0],result[1]);
                }else {
                    break;
                }
            }
        }catch (IOException exception){
            System.out.println("Problem during read data from a file: " + exception.getMessage());
        }
        return stringStringMap;
    }
}
