package mission3.repository;

import java.util.Map;
import mission3.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(Long id);
    List<Member> findAll();
}
