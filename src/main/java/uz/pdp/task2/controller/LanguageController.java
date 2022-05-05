package uz.pdp.task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task2.entity.Language;
import uz.pdp.task2.payload.Response;
import uz.pdp.task2.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @GetMapping
    public ResponseEntity<?> getLanguages() {
        List<Language> languages = languageService.getLanguages();
        if (languages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Language list is empty");
        }
        return ResponseEntity.ok(languages);
    }

    @PostMapping
    public ResponseEntity<Response> addLanguage(@RequestBody Language language) {
        Response response = languageService.addLanguage(language);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> editLanguage(@PathVariable Integer id, @RequestBody Language language) {
        Response response = languageService.editLanguage(id, language);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteLanguage(@PathVariable Integer id) {
        Response response = languageService.deleteLanguage(id);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}
