
package PS;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {

    private static final String KEY = "yoursecretkey123";
    private static final byte[] IV = new byte[16];

    public static String encrypt(String plainText) {
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(IV);

            SecretKeySpec keySpec = new SecretKeySpec(
                    KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

            byte[] encrypted = cipher.doFinal(
                    plainText.getBytes("UTF-8"));

            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {
            System.err.println(e);
            return "ENCRYPT_ERR";
        }
    }

    public static String decrypt(String cipherText) {
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(IV);

            SecretKeySpec keySpec = new SecretKeySpec(
                    KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] decodedBytes =
                    Base64.getDecoder().decode(cipherText);

            byte[] original = cipher.doFinal(decodedBytes);

            return new String(original, "UTF-8");

        } catch (Exception e) {
            System.err.println(e);
            return "DECRYPT_ERR";
        }
    }

    public static void main(String[] args) {
        String text = "Hello Java";

        String encrypted = encrypt(text);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
