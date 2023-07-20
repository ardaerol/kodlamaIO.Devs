package kodlamaio.Kodlama.io.Devs.webApi.controllers;

import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetByIdLanguageRespons;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll(){
        return languageService.getAll();
    }

    @PostMapping("/add")
    void addLanguage(CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.addLanguage(createLanguageRequest);
    }

    @DeleteMapping("/{id}")
    void deleteLanguage(@PathVariable int id){
        languageService.deleteLanguage(id);
    }

    @PutMapping("/update")
    void updateLanguage(UpdateLanguageRequest updateLanguageRequest){
        languageService.updateLanguage(updateLanguageRequest);
    }

    @GetMapping("/{id}")
    public GetByIdLanguageRespons getId(@PathVariable int id){
      return   languageService.getLanguageId(id);
    }




}
