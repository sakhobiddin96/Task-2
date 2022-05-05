package uz.pdp.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task2.entity.Section;

public interface SectionRep extends JpaRepository<Section,Integer> {
}
