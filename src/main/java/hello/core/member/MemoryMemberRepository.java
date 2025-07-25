package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long,Member> store = new HashMap<Long,Member>();

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public void save(Member member){
        store.put(member.getId(),member);
    }

//    @Override
//    public Member findByUsername(String name){
//        return store.get(name);
//    }
}
