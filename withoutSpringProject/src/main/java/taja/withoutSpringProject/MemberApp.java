package taja.withoutSpringProject;

import taja.withoutSpringProject.member.Grade;
import taja.withoutSpringProject.member.Member;
import taja.withoutSpringProject.member.MemberService;
import taja.withoutSpringProject.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
