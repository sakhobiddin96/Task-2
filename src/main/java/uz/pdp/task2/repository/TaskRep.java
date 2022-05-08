package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.task2.entity.Task;
@RepositoryRestResource(path = "task")
public interface TaskRep extends JpaRepository<Task,Integer> {
}
