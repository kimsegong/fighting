package start.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    public Optional<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
               .setParameter("name", name)
               .getResultList().stream().findAny();
    }

    public List<Member> findById(Long id){
        return em.createQuery("select m from Member m where m.id = :id", Member.class)
               .setParameter("id", id)
               .getResultList();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public int update(Member member) {
        return em.createQuery("update Member m set m.name = :name, m.age = :age, m.pw = :pw where m.id = :id")
               .setParameter("name", member.getName())
               .setParameter("age", member.getAge())
               .setParameter("pw", member.getPw())
               .setParameter("id", member.getId())
               .executeUpdate();
    }


    // 삭제 메소드
    public void delete(Long id) {
        Member member = em.find(Member.class, id);
        if (member != null) {
            em.remove(member);
        }

    }
}
