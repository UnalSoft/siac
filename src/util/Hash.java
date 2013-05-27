package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class Hash {
    
    public static String hashMD5 (String password) {
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            //TODO: Cambiar
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
    
}
