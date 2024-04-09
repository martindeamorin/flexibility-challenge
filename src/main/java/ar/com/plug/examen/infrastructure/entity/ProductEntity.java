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
@Table(name = "product")
@Data
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne(
            targetEntity = SellerEntity.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private SellerEntity seller;
    @Column(
            name = "deleted",
            nullable = false,
            columnDefinition = "BIT(1) NOT NULL"
    )
    private Boolean isDeleted = Boolean.FALSE;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
