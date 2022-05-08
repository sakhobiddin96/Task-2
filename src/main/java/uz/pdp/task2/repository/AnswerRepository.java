package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.task2.entity.Answer;
@RepositoryRestResource(path = "answer")
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
