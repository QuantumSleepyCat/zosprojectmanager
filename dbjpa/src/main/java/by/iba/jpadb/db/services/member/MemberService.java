package by.iba.jpadb.db.services.member;

import by.iba.jpadb.db.entities.promoting.Member;

import java.util.List;

public interface MemberService {
    Member findById(long id);
    List<Member> findAll();
    void addOrUpdate(Member member);
    void delete(Member member);
    void delete(long id);
}
