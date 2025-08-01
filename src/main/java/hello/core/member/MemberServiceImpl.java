package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

//    @Override
//    public Member findByUsername(String username) {
//        return memberRepository.findByUsername(username);
//    }
}
