package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task2.entity.Task;

public interface TaskRep extends JpaRepository<Task,Integer> {
}
