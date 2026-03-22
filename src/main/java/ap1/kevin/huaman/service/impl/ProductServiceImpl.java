package ap1.kevin.huaman.service.impl;

import ap1.kevin.huaman.model.Product;
import ap1.kevin.huaman.repository.ProductRepository;
import ap1.kevin.huaman.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        log.info("Listando todos los productos");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(Long id) {
        log.info("Buscando producto con ID {}", id);
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        log.info("Guardando producto: {}", product);
        product.setState("A");
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        log.info("Actualizando producto: {}", product);

        return productRepository.findById(product.getId())
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado")))
                .flatMap(existing -> {
                    product.setState("A"); // mantener activo
                    return productRepository.save(product);
                });
    }
}