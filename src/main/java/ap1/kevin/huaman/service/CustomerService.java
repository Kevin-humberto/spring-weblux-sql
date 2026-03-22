package ap1.kevin.huaman.service;

import ap1.kevin.huaman.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Mono<Customer> findById(Long id);

    Mono<Customer> save(Customer customer);

    Mono<Customer> update(Customer customer);
    
}
