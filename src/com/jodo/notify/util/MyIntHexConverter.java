package com.jodo.notify.util;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class MyIntHexConverter {
    
    private static final String INITIAL_SEQ =  "0AKV239BCDE45GM8"; 
    private static HashMap<Character, Integer> char_index;
    static {
        if(INITIAL_SEQ.length() != 16) {
            throw new InvalidParameterException("INITIAL_SEQ length invalid");
        }
        char_index = new HashMap<Character,Integer>();
        for(int i=0; i<INITIAL_SEQ.length(); i++) {
            char cc = INITIAL_SEQ.charAt(i);
            cc = Character.toUpperCase(cc);
            if(char_index.get(cc) != null) {
                throw new InvalidParameterException("INITIAL_SEQ error. duplicate character");
            }
            
            char_index.put(cc, i);
        }
    }
    public static String toMyHexString(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++) {
            int index = (0xF & value);
            sb.append(INITIAL_SEQ.charAt(index));
            value = value >> 4;
        }
        return sb.toString();
    }
    
    public static int myHexStringToint(String hexString) throws Exception{
        if(hexString == null || hexString.isEmpty() || hexString.length() != 8 ) {
            throw new InvalidParameterException("hexString length invalid." + hexString);
        }
        int value = 0;
        for(int i=hexString.length() - 1; i>=0; i--) {
            char charAt = hexString.charAt(i);
            Character cc = Character.toUpperCase(charAt);
            Integer index = char_index.get(cc);
            if(index == null || index > 15) {
                throw new InvalidParameterException("hexString can not be parse. " + hexString);
            }
            value = ( value << 4 ) | index;
        }
        return value;
    }
    
    public static void main(String[] args) throws Exception {
        String myHexString = toMyHexString(80371).toLowerCase();
        System.out.println(myHexString);
        
        System.out.println(myHexStringToint("EM4VA000"));
        System.out.println(myHexStringToint("DK000000"));
        
//        for(int i=10; i<100; i++) {
//            System.out.println(toMyHexString(i));
//        }
    }
    
}
