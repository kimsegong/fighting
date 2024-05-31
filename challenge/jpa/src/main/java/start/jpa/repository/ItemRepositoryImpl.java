package start.jpa.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Item;
import start.jpa.entity.QItem;

import java.util.List;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemCustomerRepository{

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Item> getItem() {
    QItem qItem = QItem.item;
    return jpaQueryFactory
           .selectFrom(qItem)
           .fetch();
  }

}
