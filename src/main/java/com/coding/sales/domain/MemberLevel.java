 package com.coding.sales.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * @author hy
 * @date 2019/07/02
 */
public class MemberLevel {
    public static Map<String,MemberLevel> memberLevelStore ;
    static{
        memberLevelStore = new HashMap<String,MemberLevel>();
        memberLevelStore.put("1", new MemberLevel("1","普卡",new BigDecimal("1")));
        memberLevelStore.put("2", new MemberLevel("2","金卡",new BigDecimal("1.5")));
        memberLevelStore.put("3", new MemberLevel("3","白金卡",new BigDecimal("1.8")));
        memberLevelStore.put("4", new MemberLevel("4","钻石卡",new BigDecimal("2")));
    }
    String level ;
    String levelName;
    BigDecimal ratio;
    
    public MemberLevel() {};
    
    public MemberLevel(String level,String levelName,BigDecimal ratio) {
        this.level = level;
        this.levelName = levelName;
        this.ratio = ratio;
    }
    public MemberLevel(String level) {
        MemberLevel memberLevel = new MemberLevel();
        memberLevel = memberLevelStore.get(level);
        this.level = memberLevel.level;
        this.levelName = memberLevel.levelName;
        this.ratio = memberLevel.ratio;
    }
    
}
