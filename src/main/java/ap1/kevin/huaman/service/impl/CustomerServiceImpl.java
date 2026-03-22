package ap1.kevin.huaman.service.impl;

import ap1.kevin.huaman.model.Customer;
import ap1.kevin.huaman.repository.CustomerRepository;
import ap1.kevin.huaman.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Flux<Customer> findAll() {
        log.info("Mostrando datos");
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(Long id) {
        log.info("Mostrando datos por ID ");
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        log.info("Registrando datos " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        log.info("Actualizando datos " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

}