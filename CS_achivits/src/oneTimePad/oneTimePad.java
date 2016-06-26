/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneTimePad;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Martínez
 */
public class oneTimePad {
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        String text_to_encrypt = "Hola mundo!";
        List<String> string_parts = encryptString(text_to_encrypt, 11);
        string_parts.forEach(System.out :: println);
        
        String decrypt_text = decryptString(string_parts);
        System.out.println("Mensaje desencriptado: " + decrypt_text);
    }
    
    private static String generateKey(int length) throws UnsupportedEncodingException {
        SecureRandom r = new SecureRandom();
        byte[] values = new byte[length];
        r.nextBytes(values);
        return new String(values, "ASCII");
    }
    
    private static String decryptString(List<String> string_parts) {
        String ret_val = new String(
                            new char[string_parts.get(0).length()])
                            .replace("\0", Character.toString((char)0));
        
        for (String part : string_parts)
            ret_val = xor(part, ret_val);
                
        return ret_val;
    }
    
    private static List<String> encryptString(String string_to_encrypt, int size) throws UnsupportedEncodingException {
        List<String> string_parts = new ArrayList();
        
        for (int index = 0; index < size - 1; index++)
            string_parts.add(generateKey(string_to_encrypt.length()));
        
        for (int index = 0; index < size - 1; index++) 
            string_to_encrypt = xor(string_parts.get(index), string_to_encrypt);
        
        string_parts.add(string_to_encrypt);
        return string_parts;
    }
    
    private static String xor(String a, String b) {
        String ret_val = "";
        for (int index = 0; index <a.length(); index++) {
            char a_char = a.charAt(index), b_char = b.charAt(index);
            ret_val += (char)((int)a_char ^ (int)b_char);
        }
        return ret_val;
    }
}

