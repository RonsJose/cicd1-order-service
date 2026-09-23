package ie.atu.cicd1orderservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private int quantity;

    public PurchaseOrder() {}

    public PurchaseOrder(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

}
