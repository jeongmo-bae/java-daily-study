package mission3.service;

import mission3.domain.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
