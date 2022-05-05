package uz.pdp.task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.task2.entity.Language;
import uz.pdp.task2.payload.Response;
import uz.pdp.task2.repository.LanguageRep;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRep languageRep;
    public Response addLanguage(Language language) {
        if (!languageRep.existsByName(language.getName())) {
            languageRep.save(language);
            return new Response("Language added", true);
        }
        return new Response("Language already exist",false);
    }
    public List<Language> getLanguages(){
        return languageRep.findAll();
    }
    public Response editLanguage(Integer id,Language language){
        Optional<Language> optionalLanguage = languageRep.findById(id);
        if (optionalLanguage.isPresent()){
            Language language1 = optionalLanguage.get();
            language1.setName(language.getName());
            languageRep.save(language1);
            return new Response("Language edited",true);
        }
        return new Response("Language not found",false);
    }
    public Response deleteLanguage(Integer id){
        Optional<Language> optionalLanguage = languageRep.findById(id);
        if (optionalLanguage.isPresent()){
            languageRep.deleteById(id);
            return new Response("Language deleted",true);
        }
        return new Response("Language not found",false);
    }
}
