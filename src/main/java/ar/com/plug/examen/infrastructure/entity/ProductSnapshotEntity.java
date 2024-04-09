package ar.com.plug.examen.infrastructure.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product_snapshot")
@Data
@SQLDelete(sql = "UPDATE product_snapshot SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProductSnapshotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long orderId;
    private BigDecimal price;
    private String name;
    private String description;
    private Long quantity;
    @Column(
            name = "deleted",
            nullable = false,
            columnDefinition = "BIT(1)"
    )
    private Boolean isDeleted = Boolean.FALSE;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
