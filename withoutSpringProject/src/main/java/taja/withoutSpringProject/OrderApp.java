package taja.withoutSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import taja.withoutSpringProject.member.Grade;
import taja.withoutSpringProject.member.Member;
import taja.withoutSpringProject.member.MemberService;
import taja.withoutSpringProject.member.MemberServiceImpl;
import taja.withoutSpringProject.order.Order;
import taja.withoutSpringProject.order.OrderService;
import taja.withoutSpringProject.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        직접 호출 - OCP, DIP가 지켜지지 않음
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

//        스프링 없이 AppConfig(DI컨테이너)를 호출
//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너에 객체 생성하여 관리
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
    }
}
