package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private Map<Long,Member> store = new HashMap<Long,Member>();

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public void save(Member memeber){
        store.put(memeber.getId(),memeber);
    }
}
