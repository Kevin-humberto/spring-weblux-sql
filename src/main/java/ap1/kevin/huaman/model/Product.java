package ap1.kevin.huaman.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "product")
public class Product {

    @Id
    @Column("id")
    private Long id;

    @Column("code")
    private String code;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("price")
    private Double price;

    @Column("stock")
    private Integer stock;

    @Column("category")
    private String category;

    @Column("state")
    private String state;

    @Column("created_at")
    private java.time.LocalDateTime createdAt;

}