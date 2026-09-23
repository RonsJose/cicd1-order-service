package ie.atu.cicd1orderservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrder {
    private Long id;
    private Long productId;
    private int quantity;
    public PurchaseOrder() {}
    public PurchaseOrder(Long id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

}
