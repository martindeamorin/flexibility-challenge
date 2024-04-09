package ar.com.plug.examen.infrastructure.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seller")
@Data
@SQLDelete(sql = "UPDATE seller SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String businessName;
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
