package one.digitalinnovation.lab.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
