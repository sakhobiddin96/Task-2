package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task2.entity.Language;

public interface LanguageRep extends JpaRepository<Language,Integer> {
    boolean existsByName(String name);
}
