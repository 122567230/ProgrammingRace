 package com.coding.sales.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * @author hy
 * @date 2019/07/02
 */
public class MemberLevel {
	
	private static final String GOLD_LEVEL = "2";
	private static final String COMMON_LEVEL = "1";
	private static final String WHITE_GOLD_LEVEL = "3";
    private static final String DIAMOND_LEVEL = "4";

	private static final String COMMON_RATIO = "1.0";
	private static final String GOLD_RATIO = "1.5";
	private static final String WHITE_GOLD_RATIO = "1.8";
    private static final String DIAMOND_RATIO = "2.0";
	
	public static Map<String,MemberLevel> memberLevelStore ;
    static{
        memberLevelStore = new HashMap<String,MemberLevel>();
        memberLevelStore.put(COMMON_LEVEL, new MemberLevel(COMMON_LEVEL,"普卡",new BigDecimal(COMMON_RATIO)));
        memberLevelStore.put(GOLD_LEVEL, new MemberLevel(GOLD_LEVEL,"金卡",new BigDecimal(GOLD_RATIO)));
        memberLevelStore.put(WHITE_GOLD_LEVEL, new MemberLevel(WHITE_GOLD_LEVEL,"白金卡",new BigDecimal(WHITE_GOLD_RATIO)));
        memberLevelStore.put(DIAMOND_LEVEL, new MemberLevel(DIAMOND_LEVEL,"钻石卡",new BigDecimal(DIAMOND_RATIO)));
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
