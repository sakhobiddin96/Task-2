package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task2.entity.Solution;

public interface SolutionRep extends JpaRepository<Solution,Integer> {
}
