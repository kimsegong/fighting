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

    // 상품전체조회
    public List<Item> itemFindAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

    // 상품수정
    public boolean modifyItem(Item item){

        int modifyResult = em.createQuery("update Item i set i.name = :name, i.price = :price, i.amount = :amount, i.status = :status where i.id = :id")
               .setParameter("name", item.getName())
               .setParameter("price", item.getPrice())
               .setParameter("amount", item.getAmount())
               .setParameter("status", item.getAmount())
               .executeUpdate();

        return modifyResult == 1;
    }

    // 상품삭제
    public void deleteItem(Item item){

    }

}
