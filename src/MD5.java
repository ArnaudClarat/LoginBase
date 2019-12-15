import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5 {
    public String hash;

    public MD5(String hash) {
        this.hash = hash;
    }

    public String getHash(){
       return this.hash;
    }

    public void setHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        this.hash = Arrays.toString(md.digest());
    }

    public boolean equals(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        return Arrays.toString(md.digest()).equals(s);
    }
}
