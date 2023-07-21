package kodlamaio.Kodlama.io.Devs.business.concrates;

import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageTechService;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.CreateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.UpdateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.TechResponses.GetAllLanguageTechResponses;
import kodlamaio.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepostory;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageTechRepostory;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import kodlamaio.Kodlama.io.Devs.entities.concretes.LanguageTech;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LanguageTechManager implements LanguageTechService {
    LanguageTechRepostory languageTechRepostory;
    LanguageRepostory languageRepostory;
    ModelMapperService modelMapperService;



    @Override
    public void addTech(CreateLanguageTechRequest createLanguageTechRequest) {
        LanguageTech languageTech = this.modelMapperService.forRequest().map(createLanguageTechRequest,LanguageTech.class);
        Language language = this.modelMapperService.forRequest().map(createLanguageTechRequest,Language.class);

//        language.setLanguageId(createLanguageTechRequest.getLanguage());
//        languageTech.setTechName(createLanguageTechRequest.getTechName());
//        languageTech.setTechId(createLanguageTechRequest.getTechId());
         languageTech.setLanguage(language);
        languageTechRepostory.save(languageTech);


    }

    @Override
    public void deleteTech(int id) {
        languageTechRepostory.deleteById(id);


    }

    @Override
    public void updateTechLanguage(int id, UpdateLanguageTechRequest updateLanguageTechRequest) {
//        LanguageTech languageTech = languageTechRepostory.findById(id).get();
        LanguageTech languageTech = this.modelMapperService.forRequest().map(updateLanguageTechRequest,LanguageTech.class);

//        languageTech.setTechName(updateLanguageTechRequest.getTechName());
        languageTechRepostory.save(languageTech);
    }

    @Override
    public List<GetAllLanguageTechResponses> getAll() {
        List<LanguageTech> languageTech = languageTechRepostory.findAll();

        List<GetAllLanguageTechResponses> getAllLanguageTechResponses = new ArrayList<GetAllLanguageTechResponses>();




        for (LanguageTech languageTech1:languageTech) {
            GetAllLanguageTechResponses responses = new GetAllLanguageTechResponses();


            responses.setTechId(languageTech1.getTechId());
            responses.setTechName(languageTech1.getTechName());
            responses.setLanguage(languageTech1.getLanguage().getLanguageId());

            getAllLanguageTechResponses.add(responses);
        }



        return getAllLanguageTechResponses;
    }


}
