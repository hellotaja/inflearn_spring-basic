package taja.withoutSpringProject.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository  implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 사실은 해쉬맵을 쓰면 동시성 이슈가 있을 수 있는데,, 간단한 예시플젝이니까

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
