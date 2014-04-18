/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Soukaina
 */
public class DateUtil {
    
    public static String format(Date date){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);    
    }
}
