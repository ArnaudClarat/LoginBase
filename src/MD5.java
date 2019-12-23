import org.apache.commons.codec.binary.Hex;
import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class MD5 {
    private String hash;

    public String getHash(){
       return this.hash;
    }

    public void setHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        System.out.println(Arrays.toString(digest));
        String passMD5 = DatatypeConverter.printHexBinary(digest).toUpperCase();
        // String passMD5 = Hex.encodeHexString(digest);
        // String passMD5 = new String(digest);
        System.out.println(passMD5);
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
        MessageDigest md;
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
