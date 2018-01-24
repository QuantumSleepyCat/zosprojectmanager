package by.iba.jpadb.db.dao;

import by.iba.jpadb.db.entities.promoting.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDAO extends JpaRepository<Member,Long> {
    Member findById(long id);
}
