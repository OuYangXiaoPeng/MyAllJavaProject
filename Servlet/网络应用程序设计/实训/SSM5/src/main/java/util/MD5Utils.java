package util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

@Component
public class MD5Utils {

    private static final String salt = "(*%213&)()fdskfj2136";

    public static void main(String[] args) {
        System.out.println(encode("123"));
    }


    public static String encode(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            text = text + salt;
            byte[] buffer = digest.digest(text.getBytes());

            StringBuffer sb = new StringBuffer();
            for (byte b : buffer) {
                int a = b & 0xff;

                String hex = Integer.toHexString(a);

                if (hex.length() == 1) {
                    hex = 0 + hex;
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encode(InputStream in) {
        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            byte[] bytes = new byte[8192];
            int byteCount;
            while ((byteCount = in.read(bytes)) > 0) {
                digester.update(bytes, 0, byteCount);
            }
            byte[] digest = digester.digest();


            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                int a = b & 0xff;

                String hex = Integer.toHexString(a);

                if (hex.length() == 1) {
                    hex = 0 + hex;
                }

                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
        }
        return null;
    }
}
