package uz.pdp.task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.task2.entity.Language;
import uz.pdp.task2.entity.Section;
import uz.pdp.task2.payload.Response;
import uz.pdp.task2.payload.SectionDto;
import uz.pdp.task2.repository.LanguageRep;
import uz.pdp.task2.repository.SectionRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    SectionRep sectionRep;
    @Autowired
    LanguageRep languageRep;
    public List<Section> getSections(){
        return sectionRep.findAll();
    }
    public Response addSection( SectionDto sectionDto){
        List<Language> checked = new ArrayList<>();
        List<Integer> languageId = sectionDto.getLanguageId();
        for (Integer integer : languageId) {
            if (languageRep.existsById(integer)){
                Optional<Language> optionalLanguage = languageRep.findById(integer);
                Language language = optionalLanguage.get();
                checked.add(language);
            }
        }
        Section section=new Section();
        section.setLanguage(checked);
        section.setName(sectionDto.getName());
        sectionRep.save(section);
        return new Response("Section added",true);
    }
    public  Response editSection(Integer id, SectionDto sectionDto){
        Optional<Section> optionalSection = sectionRep.findById(id);
        if (optionalSection.isPresent()){
            Section section = optionalSection.get();
            section.setName(sectionDto.getName());
            List<Language> checked=new ArrayList<>();
            List<Integer> integers = sectionDto.getLanguageId();
            for (Integer integer : integers) {
                Optional<Language> optionalLanguage = languageRep.findById(integer);
                optionalLanguage.ifPresent(checked::add);
            }
            section.setLanguage(checked);
            sectionRep.save(section);
            return new Response("Section updated",true);
        }
        return new Response("Section not fond",false);
    }
    public Response deleteSection(Integer id){
        Optional<Section> optionalSection = sectionRep.findById(id);
        if (optionalSection.isPresent()){
            sectionRep.deleteById(id);
            return new Response("Section deleted",true);
        }
        return new Response("Section not found",false);
    }
}
