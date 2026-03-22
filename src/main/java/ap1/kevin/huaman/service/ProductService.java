package ap1.kevin.huaman.service;

import ap1.kevin.huaman.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> findById(Long id);

    Mono<Product> save(Product product);

    Mono<Product> update(Product product);
}