package by.iba.xmlreport.db.services.member;

import by.iba.xmlreport.db.dao.MemberDAO;
import by.iba.xmlreport.db.entities.promoting.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public Member findById(long id) {
        return memberDAO.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public void addOrUpdate(Member member) {
        memberDAO.save(member);
    }

    @Override
    public void delete(Member member) {
        memberDAO.delete(member);
    }

    @Override
    public void delete(long id) {
        memberDAO.delete(id);
    }
}
