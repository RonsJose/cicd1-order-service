package ie.atu.cicd1orderservice.service;

import ie.atu.cicd1orderservice.Repository.PurchaseOrderRepository;
import ie.atu.cicd1orderservice.client.CatalogClient;
import ie.atu.cicd1orderservice.model.PurchaseOrder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final CatalogClient catalogClient;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, CatalogClient catalogClient) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.catalogClient = catalogClient;
    }

    public List<PurchaseOrder> getAll() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return purchaseOrderRepository.save(order);
    }

    public String testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
}