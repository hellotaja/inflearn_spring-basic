package taja.withoutSpringProject.order;

import taja.withoutSpringProject.discount.DiscountPolicy;
import taja.withoutSpringProject.discount.FixDiscountPolicy;
import taja.withoutSpringProject.member.Member;
import taja.withoutSpringProject.member.MemberRepository;
import taja.withoutSpringProject.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
