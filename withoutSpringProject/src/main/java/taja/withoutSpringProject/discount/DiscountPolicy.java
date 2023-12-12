package taja.withoutSpringProject.discount;

import taja.withoutSpringProject.member.Member;
import taja.withoutSpringProject.member.MemberRepository;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */

    int discount(Member member, int price);
}
