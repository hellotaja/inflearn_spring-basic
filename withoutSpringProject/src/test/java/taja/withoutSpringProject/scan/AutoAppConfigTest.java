package taja.withoutSpringProject.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import taja.withoutSpringProject.member.MemberService;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfigTest.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService)
    }
}
