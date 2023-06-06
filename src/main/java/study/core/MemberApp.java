package study.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;


public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);  // 메서드 이름 명으로 찾아온다.

       Member member = new Member(1L, "memberShin", Grade.VIP);
       memberService.join(member);

       Member findMember = memberService.findMember(1L);
        System.out.println("new Member =  "   + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
