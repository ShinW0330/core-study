package study.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findByid(Long memberId );
}
