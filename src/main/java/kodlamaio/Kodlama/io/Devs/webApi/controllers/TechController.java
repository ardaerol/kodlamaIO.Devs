package kodlamaio.Kodlama.io.Devs.webApi.controllers;

import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageTechService;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.CreateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.UpdateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.TechResponses.GetAllLanguageTechResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
public class TechController {
    private LanguageTechService languageTechService;

    public TechController(LanguageTechService languageTechService) {
        this.languageTechService = languageTechService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguageTechResponses> getAllTech(){
       return languageTechService.getAll();
    }

    @PostMapping("/add")
    void addTech(CreateLanguageTechRequest createLanguageTechRequest){
        languageTechService.addTech(createLanguageTechRequest);
    }

    @DeleteMapping("/{id}")
    void deleteTech(@PathVariable int id){
        languageTechService.deleteTech(id);
    }

    @PutMapping("/update")
    void updateTech(UpdateLanguageTechRequest updateLanguageTechRequest){
        languageTechService.updateTechLanguage(updateLanguageTechRequest.getTechId(),updateLanguageTechRequest);
    }
}
