package start.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Item;
import start.jpa.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    // 상품등록
    public void save(Item item) {
        em.persist(item);
    }

}
