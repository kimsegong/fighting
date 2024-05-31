package start.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table
public class Item {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;
    @Column(name = "ITEM_NAME")
    private String name;
    @Column(name = "ITEM_ACOUNT")
    private int amount;
    @Column(name = "ITEM_PRICE")
    private int price;
    @Column(name = "ITEM_STATUS")
    private int status; // 상품상태

}
