package application.dataLayer.repository;

import application.model.test.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
    Test getById(Long id);
}
