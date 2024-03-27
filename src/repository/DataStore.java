package repository;

import model.Dictionary;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

import java.util.*;


public class DataStore {
    private final String algorithms = "AES";
    //        key must be 18 bytes, 24 bytes, 32 bytes
    private final String keyString = "Sokpheng123@*#$%";
    private final SecretKey secretKey = new SecretKeySpec(keyString.getBytes(),algorithms);
    //
    private final byte[] buffer = new byte[4096];
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
            System.out.println(STR."Problem during read data from a file: \{exception.getMessage()}");
        }
        return stringStringMap;
    }
//    testing
    @Test
    public void writeObjectToFile(){
        Long startedTime = System.currentTimeMillis();
        try(ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream("dataStore/newGenWordsFile.bin")
                            ))
        ){
            List<Dictionary> dictionaryList = new ArrayList<>();
            for(int i=0;i<1;i++){
                dictionaryList.add(new Dictionary(UUID.randomUUID().toString(),"Banana","គឺជាផ្លែឈឺមួយប្រភេទ"));
                dictionaryList.add(new Dictionary(UUID.randomUUID().toString(),"Apple","គឺជាផ្លែឈឺមួយប្រភេទ"));
            }
            objectOutputStream.writeObject(dictionaryList);
            objectOutputStream.flush();

        }catch (Exception exception){
            System.out.println("Problem during writing object to a file.!!!");
        }
        Long endedTime = System.currentTimeMillis();
        System.out.println((endedTime-startedTime)/1000);
    }
    public static List<Dictionary> readObjectFromFile(){
        try(ObjectInputStream objectInputStream =
                new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("dataStore/newGenWordsFile.bin")
                        )
                )
        ){
            return (List<Dictionary>) objectInputStream.readObject();

        }catch (Exception exception){
            System.out.println("Problem during reading object from file.");
        }
        return null;
    }
//    Below two methods are wrong with architecture implementation
    public void getAllDecryptedWords(){
        Map<String, String> stringStringMap = new TreeMap<>();
        try(
                InputStream inputStream = new FileInputStream("dataStore/text.txt");
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("dataStore/decrypted.txt"));
                        ){
            Cipher cipher = Cipher.getInstance(algorithms);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream,cipher);
            int data;
            while ((data=cipherInputStream.read())!=-1){
                System.out.println(data);
                outputStream.write(data);
            }
            cipherInputStream.close();
        }catch (Exception exception){
            System.out.println(STR."Error during reading decrypted data: \{exception.getMessage()}");
        }
//        return stringStringMap;
    }
    public void writeEncryptedData(){
//
        String data;

        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("dataStore/text.txt"));
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dataStore/words.txt"));
        ){
            try{
//                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithms);
                Cipher cipher = Cipher.getInstance(algorithms);
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
//                while ((data=bufferedReader.readLine())!=null){
////                    System.out.println(data);
//                    for(int i=0;i<data.length();i++){
//                        cipherOutputStream.write(buffer, 0 ,data.charAt(i));
//                    }
//                }
                cipherOutputStream.write(buffer,0,'H');
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
