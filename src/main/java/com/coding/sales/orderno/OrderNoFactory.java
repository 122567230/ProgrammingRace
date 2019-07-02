 package com.coding.sales.orderno;

 /**
 * @author hy
 * @date 2019/07/02
 */
public class OrderNoFactory {
    
    public static String produceOrderNo() {
        return String.valueOf(Math.round((Math.random()*10000000)));
    }
    
}
