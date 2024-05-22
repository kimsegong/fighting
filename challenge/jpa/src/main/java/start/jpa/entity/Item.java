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
@Table(name = "item")
public class Item {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;
    @Column(name = "ITAM_NAME")
    private String name;
    @Column(name = "ITAM_ACOUNT")
    private int amount;
    @Column(name = "ITAM_PRICE")
    private int price;

}
