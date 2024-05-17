package start.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "member")
public class Member {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "MEMBER_NAME")
    private String name;
    @Column(name = "MEMBER_AGE")
    private int age;
    @Column(name = "MEMBER_PW")
    private int pw;

}
