package com.jungmo.mission1.membership;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class MembershipService {
    private Map<String, Member> memberMap = new HashMap<>();
    private boolean findMemberInfo(String phoneNumber){
        if(memberMap.containsKey(phoneNumber)){
            return true;
        }else{
            return false;
        }
    }
    public void enrollMembership(String name, String phoneNumber){
        Member member = new Member(name,phoneNumber);
        if(this.findMemberInfo(phoneNumber)){
            System.out.printf("\n>> %s 는 이미 등록된 전화번호 입니다.\n",phoneNumber);
        }else{
            this.memberMap.put(phoneNumber,member);
            System.out.printf("\n>> %s 님, 회원 등록이 완료되었습니다.\n",phoneNumber);
        }
    }
    public void savePoints(String phoneNumber, int savings){
        if (this.findMemberInfo(phoneNumber)){
            if(savings > 0){
                memberMap.get(phoneNumber).setPoint((int)(savings * 0.1));
                System.out.printf("\n전화번호 : %s\n",phoneNumber);
                System.out.printf("적립할 금액 : %d\n",savings);
                System.out.printf(">> %d 포인트 적립 완료, 잔여 포인트 %d\n",(int)(savings * 0.1),memberMap.get(phoneNumber).getPoint());
            } else{
                System.out.printf("\n전화번호 : %s\n",phoneNumber);
                System.out.printf(">> 적립금액이 잘못입력 되었습니다.\n");
            }
        } else{
            System.out.println("\n>> 회원을 찾을 수 없습니다.");
        }
    }
    public void payPoints(String phoneNumber,int payings){
        if (this.findMemberInfo(phoneNumber)){
            Member member = memberMap.get(phoneNumber);
            if(payings > member.getPoint()){
                System.out.printf("\n>> %s 님, 잔여포인트가 부족합니다.",phoneNumber);
            }else if(payings <= 0){
                System.out.printf("\n전화번호 : %s\n",phoneNumber);
                System.out.printf(">> 시용 금액이 잘못 입력되었습니다.\n");
            }else{
                member.setPoint(-1*payings);
                System.out.printf("\n전화번호 : %s\n",phoneNumber);
                System.out.printf("사용할 금액 : %d\n",payings);
                System.out.printf(">> 사용완료, 잔여 포인트 : %d\n",member.getPoint());
            }
        } else{
            System.out.println("\n>> 회원을 찾을 수 없습니다.");
        }
    }
    public void getAllMemberList(){
        System.out.println("\n===================member list===================");
        for(Map.Entry<String,Member> entry : memberMap.entrySet()){
            System.out.printf("이름 : %s / 번호 : %s / 포인트 : %d\n",entry.getValue().getName(),entry.getValue().getPhoneNumber(),entry.getValue().getPoint());
        }
        System.out.println("=================================================");
    }
    public void getAllMemberCount(){
        System.out.printf("\n>> 현재 회원 수 : %d\n",memberMap.size());
    }
    public void fixMemberInfo(String phoneNumber,String fixedName,String fixedPhoneNumber){
        if (this.findMemberInfo(phoneNumber)){
            System.out.printf("\n수정하실 회원 : %s\n",phoneNumber);
            int numFix = 0;
            Member member = memberMap.get(phoneNumber);
            if (!fixedName.isEmpty() && fixedName != null && fixedName != member.getName()){
                member.setName(fixedName);
                System.out.printf(">> 이름 수정 완료 : %s\n",memberMap.get(phoneNumber).getName());
                numFix += 1;
            }
            if(!fixedPhoneNumber.isEmpty() && fixedPhoneNumber != null && fixedPhoneNumber != member.getPhoneNumber()){
                member.setPhoneNumber(fixedPhoneNumber);
                memberMap.remove(phoneNumber);
                memberMap.put(fixedPhoneNumber,member);
                System.out.printf(">> 전화번호 수정 완료 : %s\n",memberMap.get(fixedPhoneNumber).getPhoneNumber());
                numFix += 1;
            }
            if(numFix == 0){
                System.out.println("수정하실 내용이 없으시군요.");
            }
        }else{
            System.out.println("\n>> 회원을 찾을 수 없습니다.");
        }
        this.getAllMemberList();
    }





}
