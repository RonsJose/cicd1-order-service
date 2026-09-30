package ie.atu.cicd1orderservice.service;

import ie.atu.cicd1orderservice.Repository.PurchaseOrderRepository;
import ie.atu.cicd1orderservice.client.CatalogClient;
import ie.atu.cicd1orderservice.client.dto.ProductResponse;
import ie.atu.cicd1orderservice.model.PurchaseOrder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public ProductResponse testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }

    public ProductResponse getProductForOrder(Long orderId) {
        PurchaseOrder order = purchaseOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found"
                ));
        return catalogClient.getProductById(order.getProductId());
    }
}