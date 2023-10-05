package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 저장소가 확정되기전까지 임시로 사용
public class MemoryMemberRepository implements MemberRepository {

    // 저장소
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
