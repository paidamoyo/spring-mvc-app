package hello;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);


}