package ap1.kevin.huaman.rest;

import ap1.kevin.huaman.model.Customer;
import ap1.kevin.huaman.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Customer> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping ("/update")
    public Mono<Customer> update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

}