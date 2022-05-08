package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.task2.entity.Solution;
@RepositoryRestResource(path = "solution")
public interface SolutionRep extends JpaRepository<Solution,Integer> {
}
