package com.coding.sales.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;



public class MemberCardTest {

	@Test
	public void should_return_common_Level_when_member_card_increase_1000_point() {
		
		MemberCard memberCard=new MemberCard("",0,0);
		
		MemberLevel memberLevel = memberCard.electMemberLevel(9999);
		
		MemberLevel memberLevelCommon = new MemberLevel("1", "普卡", new BigDecimal("1.0"));
	    assertEquals(memberLevelCommon.level, memberLevel.level);
	    assertEquals(memberLevelCommon.levelName, memberLevel.levelName);
	    assertEquals(memberLevelCommon.ratio, memberLevel.ratio);

	}
	
	@Test
	public void should_return_gold_Level_when_member_card_increase_10000_point() {
		
		MemberCard memberCard=new MemberCard("",0,0);
		
		MemberLevel memberLevel = memberCard.electMemberLevel(10000);
		
		MemberLevel memberLevelCommon = new MemberLevel("2", "金卡", new BigDecimal("1.5"));
	    assertEquals(memberLevelCommon.level, memberLevel.level);
	    assertEquals(memberLevelCommon.levelName, memberLevel.levelName);
	    assertEquals(memberLevelCommon.ratio, memberLevel.ratio);

	}
	
	@Test
	public void should_return_white_gold_Level_when_member_card_increase_50000_point() {
		
		MemberCard memberCard=new MemberCard("",0,0);
		
		MemberLevel memberLevel = memberCard.electMemberLevel(50000);
		
		MemberLevel memberLevelCommon = new MemberLevel("3", "白金卡", new BigDecimal("1.8"));
	    assertEquals(memberLevelCommon.level, memberLevel.level);
	    assertEquals(memberLevelCommon.levelName, memberLevel.levelName);
	    assertEquals(memberLevelCommon.ratio, memberLevel.ratio);

	}
	@Test
	public void should_return_diamond_Level_when_member_card_increase_100000_point() {
		
		MemberCard memberCard=new MemberCard("",0,0);
		
		MemberLevel memberLevel = memberCard.electMemberLevel(100000);
		
		MemberLevel memberLevelCommon = new MemberLevel("4", "钻石卡", new BigDecimal("2.0"));
	    assertEquals(memberLevelCommon.level, memberLevel.level);
	    assertEquals(memberLevelCommon.levelName, memberLevel.levelName);
	    assertEquals(memberLevelCommon.ratio, memberLevel.ratio);

	}
}
