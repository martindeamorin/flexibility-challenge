package ar.com.plug.examen.infrastructure.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "purchase_order")
@Data
public class PurchaseOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(
            targetEntity = ProductSnapshotEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    Set<ProductSnapshotEntity> products;
    private BigDecimal total;
    private Boolean isAuthorized;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
