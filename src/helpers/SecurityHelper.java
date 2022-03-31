package helpers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SecurityHelper {
    private static final SecureRandom rand = new SecureRandom();
    private static final int iterations = 65536;
    private static final int key_length = 512;
    private static final String algorithm = "PBKDF2WithHmacSHA512";

    public static String generateSaltValue(int length)
    {
        if (length >= 1)
        {
            byte[] salt;
            salt = rand.generateSeed(length);

            return Base64.getEncoder().encodeToString(salt);
        }
        else
        {
            System.err.println("error in generateSalt: length must be > 0");
            return null;
        }
    }

    public static String hashPassword(String password, String salt)
    {
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, key_length);
        Arrays.fill(passwordChars, Character.MIN_VALUE);

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
            byte[] securePassword = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(securePassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
}
