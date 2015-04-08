package com.jodo.notify.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.mail.internet.MimeUtility;

/**
 * @author Treeman
 */
public class Base64Utils {

    public static byte[] encode(byte[] b) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream b64os = MimeUtility.encode(baos, "base64");
        b64os.write(b);
        b64os.close();
        return baos.toByteArray();
    }

    public static byte[] decode(byte[] b) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        InputStream b64is = MimeUtility.decode(bais, "base64");
        byte[] tmp = new byte[b.length];
        int n = b64is.read(tmp);
        byte[] res = new byte[n];
        System.arraycopy(tmp, 0, res, 0, n);
        return res;
    }

    public static String encode(String str) throws Exception {
        if (null == str || str.isEmpty()) {
            return "";
        }
        return new String(encode(str.getBytes())).replaceAll("\r?\n", "");
    }

    public static String decode(String str) throws Exception {
        if (null == str || str.isEmpty()) {
            return "";
        }
        return new String(decode(str.getBytes()));
    }

    public static void main(String[] args) throws Exception {
        String encoded = "eyJBIjoiNDYwMDAiLCJCIjoi5Lit5Zu956e75YqoIiwiQyI6IjIiLCJEIjoiOTg6ZmE6ZTM6NTk6YzU6MjMiLCJFIjoiTlVMTCIsIkYiOiI3MjAqMTI4MCIsIkciOiIyLjAiLCJIIjoiNTIyMDkiLCJJIjoiOTQ0MiIsIkoiOiIyMDE0NTAxIiwiSyI6InVua25vd24iLCJMIjoiQ04iLCJNIjoiemgiLCJRIjoiY29tLnBva2V0ZWMudGV4YXMuZWoyMDE0IiwiUiI6IjI0MiIsImEiOiJlZTdmMzZlZGVmNmEzYTY0IiwiYiI6IlhpYW9taSIsImMiOiIyMDE0NTAxIiwiZCI6IjVUQ01WNFZPWTlFRUxWUk8iLCJlIjoiMjEyYThlNTdkOGFiODQ0NyIsImYiOiI0LjQuMiIsImciOiIxOSIsImgiOiJLT1Q0OUgiLCJpIjoiWGlhb21pIiwiaiI6IjIwMTQ1MDEiLCJrIjoiYXJtZWFiaS12N2EiLCJsIjoiS09UNDlIIiwibSI6IkhNMjAxNDUwMSIsIm4iOiJYaWFvbWkvMjAxNDUwMS9ITTIwMTQ1MDE6NC40LjIvS09UNDlIL0tISENOQkY1LjA6dXNlci9yZWxlYXNlLWtleXMiLCJvIjoiODY1ODk5MDI3Mzg0NTI3IiwicCI6IjQ2MDAyOTg2MzA5NDEwNCIsInEiOiI3OCIsInIiOiJOVUxMIiwicyI6IjEiLCJ0IjoiODk4NjAwODAxOTE0OTUyODQzNTAiLCJ1IjoiY24iLCJ2IjoiNDYwMDIiLCJ3IjoiQ01DQyIsIngiOiI1IiwieSI6Ik5VTEwiLCJ6IjoiY24ifQ==";
        System.out.println(decode(encoded));
    }

}
