 package com.coding.sales.member;

import java.util.HashMap;
import java.util.Map;

import com.coding.sales.member.action.IMemberCard;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Member {
    private String name;
    private MemberCard memberCard; 
    
    public static Map<String,Member> members = new HashMap<String,Member>();
    
    static {
    	MemberCard mCard=new MemberCard("6236609999",9860,0);
    	Member member = new Member("马丁",mCard);
    	members.put("6236609999", member);
    	
    	mCard=new MemberCard("6630009999",48860,0);
        member = new Member("王立",mCard);
    	members.put("6630009999", member);
    	
    	mCard=new MemberCard("8230009999",98860,0);
    	member = new Member("李想",mCard);
    	members.put("8230009999", member);
    	
    	mCard=new MemberCard("9230009999",198860,0);
    	member = new Member("张三",mCard);
    	members.put("9230009999", member);

    }

    
    
    public Member(String name,MemberCard memberCard) {
		this.name=name;
		this.memberCard=memberCard;
	}
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public MemberCard getMemberCard() {
        return memberCard;
    }
    public void setMemberCard(MemberCard memberCard) {
        this.memberCard = memberCard;
    }
    
    
}
