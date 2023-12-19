package taja.withoutSpringProject.member;

public class MemberServiceImpl implements MemberService {

    // 추상화에만 의존, DIP가 지켜짐
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
