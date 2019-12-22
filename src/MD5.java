import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.binary.Hex;

public class MD5 {
    public String hash;

    public String getHash(){
       return this.hash;
    }

    public void setHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String passMD5 = DatatypeConverter.printHexBinary(digest).toUpperCase();
        passMD5 : Hex.en
        this.hash = passMD5;

        /*
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        assertThat(myHash.equals(hash)).isTrue();
         */
    }

    public boolean equals(String s) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            return Arrays.toString(md.digest()).equals(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
