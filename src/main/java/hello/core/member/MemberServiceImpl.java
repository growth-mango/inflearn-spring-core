package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 구현체 없이 인터페이스만 있을 경우 NullPointerException 확률 큼
    // -> 그래서 구현 객체(MemoryMemberRepository) 선택해야 함
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 다형성에 의해 MemoryMemberRepository 에 있는 override한 save가 호출됨
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);    }
}
