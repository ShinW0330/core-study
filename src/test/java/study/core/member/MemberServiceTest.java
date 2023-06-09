package study.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.AppConfig;

class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl();

    MemberService memberService;
    @BeforeEach // 테스트 실행전 무조건 먼저 실행 한다.
    public void beforeEach(){
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();

    }
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
