package kodlamaio.Kodlama.io.Devs.business.concrates;

import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetByIdLanguageRespons;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepostory;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageTechRepostory;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import kodlamaio.Kodlama.io.Devs.entities.concretes.LanguageTech;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepostory languageRepostory;
    private LanguageTechRepostory languageTechRepostory;
    List<Language> languages;

    public LanguageManager(LanguageRepostory languageRepostory,LanguageTechRepostory languageTechRepostory) {
        this.languageRepostory = languageRepostory;
        this.languageTechRepostory = languageTechRepostory;
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = languageRepostory.findAll();
        List<GetAllLanguageResponse> getAllLanguageResponses = new ArrayList<GetAllLanguageResponse>();



        for (Language language:languages ) {
            List<String> techName = new ArrayList<>();
            GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
            responseItem.setLanguageId(language.getLanguageId());
            responseItem.setLanguageName(language.getLanguageName());
            for (LanguageTech languageTech:language.getLanguageTeches()){
                techName.add(languageTech.getTechName());
            }
            responseItem.setTechName(techName);

            getAllLanguageResponses.add(responseItem);
        }
        return getAllLanguageResponses;
    }

    @Override
    public void addLanguage(CreateLanguageRequest createLanguageRequest) throws Exception {

        Language language = new Language();
        language.setLanguageName(createLanguageRequest.getLanguageName());
        this.languageRepostory.save(language);
    }

    @Override
    public void deleteLanguage(int id) {
        List<Language> languages = languageRepostory.findAll();

        for (Language language: languages) {
            if (language.getLanguageId() == id){
                languageRepostory.deleteById(id);
            }
        }
    }

    @Override
    public void updateLanguage(UpdateLanguageRequest updateLanguageRequest) {
        Language language = languageRepostory.findById(updateLanguageRequest.getLanguageId());


                language.setLanguageName(updateLanguageRequest.getLanguageName());
                languageRepostory.save(language);


    }

    @Override
    public GetByIdLanguageRespons    getLanguageId(int id) {

        Language language = languageRepostory.findById(id);
        GetByIdLanguageRespons responseItem = new GetByIdLanguageRespons();
        responseItem.setLanguageId(language.getLanguageId());
        responseItem.setLanguageName(language.getLanguageName());


            return responseItem ;

    }

//    GetByIdLanguageRespons respons = new GetByIdLanguageRespons();
//        respons.setLanguageName(language.getLanguageName());

//         return respons;


}
