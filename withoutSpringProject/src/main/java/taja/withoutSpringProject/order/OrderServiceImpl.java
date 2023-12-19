package taja.withoutSpringProject.order;

import taja.withoutSpringProject.discount.DiscountPolicy;
import taja.withoutSpringProject.discount.FixDiscountPolicy;
import taja.withoutSpringProject.discount.RateDiscountPolicy;
import taja.withoutSpringProject.member.Member;
import taja.withoutSpringProject.member.MemberRepository;
import taja.withoutSpringProject.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 추상에만 의존해야하는데 구현에도 의존하게 됨 -> DIP(의존역전원칙) 위반!
    // 기존의 코드를 변경해야만 기능을 바꿀 수 있음 -> OCP(개방폐쇄원칙) 위반!

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
