package taja.withoutSpringProject;

import taja.withoutSpringProject.discount.DiscountPolicy;
import taja.withoutSpringProject.discount.FixDiscountPolicy;
import taja.withoutSpringProject.discount.RateDiscountPolicy;
import taja.withoutSpringProject.member.MemberRepository;
import taja.withoutSpringProject.member.MemberService;
import taja.withoutSpringProject.member.MemberServiceImpl;
import taja.withoutSpringProject.member.MemoryMemberRepository;
import taja.withoutSpringProject.order.OrderService;
import taja.withoutSpringProject.order.OrderServiceImpl;

public class AppConfig {
    // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
    // 생성자 주입

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

// 각각의 역할이 명확하게 보여짐
// 애플리케이션 전체구성이 어떻게 생겼는지 빠르게 파악도 가능함