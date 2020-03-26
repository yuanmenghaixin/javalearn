package networkCode.chapter3;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/3/5.
 */
public class DigestThread extends Thread {
    private String fileName;

    public DigestThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try {
            FileInputStream in = new FileInputStream(fileName);
            try {
                MessageDigest sha = MessageDigest.getInstance("SHA-256");
                DigestInputStream din = new DigestInputStream(in, sha);
                while (din.read() != -1) ;
                din.close();
                byte[] digest = sha.digest();
                StringBuilder result=new StringBuilder(fileName);
                result.append(": ");
                result.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(result);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        for (String fileName:args){
            Thread t =new DigestThread(fileName);
            t.start();
        }
    }
}
