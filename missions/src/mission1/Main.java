package com.jungmo.mission1.membership;

public class Main {
    public static void main(String[] args) {
        MembershipService service = new MembershipService();
        service.enrollMembership("배정모","010-5755-2108");
        service.enrollMembership("소신선생","010-5182-6165");
        service.savePoints("010-5755-2108",10000);
        service.payPoints("010-5755-2108",521);
        service.payPoints("010-5755-2108",521);
        service.getAllMemberList();
        service.getAllMemberCount();
        service.enrollMembership("배겐남","010-5755-2108");
        service.fixMemberInfo("010-5755-2108","배겐남","010");
        //System.out.println(service.memberMap);
    }
}
