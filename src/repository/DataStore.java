package repository;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

import java.security.Security;
import java.util.Arrays;
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
    @Test
    public void writeData(){


        String algorithms = "AES";
//        key must be 18 bytes, 24 bytes, 32 bytes
        String keyString = "Sokpheng123@*#$%";
//
        String data;

        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("dataStore/text.txt"));
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dataStore/words.txt"));
        ){
            try{
//                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithms);

                SecretKey secretKey = new SecretKeySpec(keyString.getBytes(),algorithms);
                Cipher cipher = Cipher.getInstance(algorithms);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//
                byte[] buffer = new byte[4096];
                CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
                while ((data=bufferedReader.readLine())!=null){

                    for(int i=0;i<data.length();i++){
                        cipherOutputStream.write(buffer, 0 ,data.charAt(i));
                    }
                }
                cipherOutputStream.flush();
                cipherOutputStream.close();
            }catch (Exception exception){
                System.out.println(STR."Error during encrypt data and write to file: \{exception.getMessage()}");
            }
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
