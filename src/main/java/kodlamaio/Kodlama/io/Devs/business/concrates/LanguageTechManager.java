package kodlamaio.Kodlama.io.Devs.business.concrates;

import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageTechService;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.CreateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.UpdateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.TechResponses.GetAllLanguageTechResponses;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepostory;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageTechRepostory;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import kodlamaio.Kodlama.io.Devs.entities.concretes.LanguageTech;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageTechManager implements LanguageTechService {
    LanguageTechRepostory languageTechRepostory;
    LanguageRepostory languageRepostory;

    public LanguageTechManager(LanguageTechRepostory languageTechRepostory, LanguageRepostory languageRepostory) {
        this.languageTechRepostory = languageTechRepostory;
        this.languageRepostory = languageRepostory;
    }

    @Override
    public void addTech(CreateLanguageTechRequest createLanguageTechRequest) {
        LanguageTech languageTech = new LanguageTech();
        Language language = new Language();

        language.setLanguageId(createLanguageTechRequest.getLanguage());
        languageTech.setTechName(createLanguageTechRequest.getTechName());
        languageTech.setTechId(createLanguageTechRequest.getTechId());
        languageTech.setLanguage(language);
        languageTechRepostory.save(languageTech);

    }

    @Override
    public void deleteTech(int id) {
        languageTechRepostory.deleteById(id);


    }

    @Override
    public void updateTechLanguage(int id, UpdateLanguageTechRequest updateLanguageTechRequest) {
        LanguageTech languageTech = languageTechRepostory.findById(id).get();

        languageTech.setTechName(updateLanguageTechRequest.getTechName());
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
