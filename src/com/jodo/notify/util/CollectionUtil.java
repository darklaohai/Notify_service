package com.jodo.notify.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * 大约就是各种Collection和数组的拼接转换吧
 *
 * @author Administrator
 * 
 */
public class CollectionUtil {

    /**
     * 使用前确保E.toString()已经正确重写
     */
    public static <E> String collection2String(Collection<E> coll, String seperator) {
        StringBuilder sb = new StringBuilder();
        for(Iterator<E> it = coll.iterator(); it.hasNext();) {
            E e = it.next();
            sb.append(e.toString()).append(seperator);
        }
        if(sb.length() > 0) {
            return sb.subSequence(0, sb.length() - seperator.length()).toString();
        }
        return sb.toString();
    }
    
    public static int[] tointArray(String str, String seperator) {
        str = str.trim();
        if( str == null || str.isEmpty()) {
            return null;
        }
        String[] arr = str.split(seperator);
        int[] result = new int[arr.length];
        for( int i=0; i<arr.length; i++ ) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
    
    public static String joinArray(int [] arr, String seperator) {
        StringBuilder sb = new StringBuilder();
        for(Integer i : arr) {
            sb.append(i).append(seperator  );
        }
        
        if(sb.length() > 0) {
            return sb.subSequence(0, sb.length() - seperator.length()).toString();
        }
        return sb.toString();
    }
    
}
