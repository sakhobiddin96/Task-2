package uz.pdp.task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task2.entity.Section;
import uz.pdp.task2.payload.Response;
import uz.pdp.task2.payload.SectionDto;
import uz.pdp.task2.service.SectionService;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    SectionService sectionService;
    @GetMapping
    public ResponseEntity<?> getSections(){
        List<Section> sections = sectionService.getSections();
        return ResponseEntity.ok(sections);
    }
    @PostMapping
    public ResponseEntity<Response> addSection(@RequestBody SectionDto sectionDto){
        Response response = sectionService.addSection(sectionDto);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response> editSection(@RequestBody SectionDto sectionDto,@PathVariable Integer id){
        Response response = sectionService.editSection(id, sectionDto);
        if (response.isSuccess())
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteSection(@PathVariable Integer id){
        Response response = sectionService.deleteSection(id);
        if (response.isSuccess())
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
