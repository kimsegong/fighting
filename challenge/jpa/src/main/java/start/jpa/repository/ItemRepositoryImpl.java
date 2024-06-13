package start.jpa.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Item;
import start.jpa.entity.QItem;

import java.util.List;

@Primary
@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemCustomerRepository {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Item> findAll() {
    QItem qItem = QItem.item;
    return jpaQueryFactory
           .selectFrom(qItem)
           .fetch();
  }

  @Override
  public List<Item> findById(Long id) {
    QItem qItem = QItem.item;
    return jpaQueryFactory
           .selectFrom(qItem)
           .where(qItem.id.eq(id))
           .fetch();
  }


  @Override
  public Item modifyItem(Long id, String name) {
    QItem qItem = QItem.item;

    long updateRows = jpaQueryFactory
           .update(qItem)
           .where(qItem.id.eq(id))
           .set(qItem.name, name)
           .execute();

    if (updateRows > 0) {
      return jpaQueryFactory
             .selectFrom(qItem)
             .where(qItem.id.eq(id))
             .fetchOne();
    } else {
      throw new IllegalStateException("Item update failed.");
    }
  }

  @Override
  public int deleteItem(Long id) {
    return 0;
  }
}
