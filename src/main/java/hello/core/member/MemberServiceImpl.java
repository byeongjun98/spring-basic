package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);

    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
}
