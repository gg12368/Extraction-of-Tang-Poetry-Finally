package lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalSHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //MD5
        //SHA-256
        MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
        String s="你好世界";
        byte[] bytes=s.getBytes("utf-8");
        messageDigest.update(bytes);
        byte[] result=messageDigest.digest();
        System.out.println(result.length);
        for(byte b:result){
            System.out.printf("%02x",b);
        }
        System.out.println();
    }
}
