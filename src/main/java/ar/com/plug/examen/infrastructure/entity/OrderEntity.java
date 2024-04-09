package ar.com.plug.examen.infrastructure.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase_order")
@Data
@SQLDelete(sql = "UPDATE purchase_order SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(
            targetEntity = ProductSnapshotEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<ProductSnapshotEntity> products;
    @ManyToOne(
            targetEntity = CustomerEntity.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(referencedColumnName = "id")
    private CustomerEntity customer;
    private BigDecimal total;
    @Column(name = "authorized")
    private Boolean isAuthorized;
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
