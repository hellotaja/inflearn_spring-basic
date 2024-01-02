package taja.withoutSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import taja.withoutSpringProject.member.Grade;
import taja.withoutSpringProject.member.Member;
import taja.withoutSpringProject.member.MemberService;
import taja.withoutSpringProject.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        직접 호출 - OCP, DIP가 지켜지지 않음
//        MemberService memberService = new MemberServiceImpl();

//        스프링 없이 AppConfig(DI컨테이너)를 호출
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너에 객체 생성하여 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
