package hello.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);

    Member findByUsername(String name);
}
