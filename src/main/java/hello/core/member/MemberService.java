package hello.core.member;

public interface MemberService {

    // 요구사항
    // 1. 회원가입
    void join(Member member);

    // 2. 회원조회
    Member findMember(Long memberId);
}
