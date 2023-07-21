package kodlamaio.Kodlama.io.Devs.business.concrates;

import kodlamaio.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetByIdLanguageRespons;
import kodlamaio.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepostory;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageTechRepostory;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import kodlamaio.Kodlama.io.Devs.entities.concretes.LanguageTech;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LanguageManager implements LanguageService {
    private LanguageRepostory languageRepostory;
    private LanguageTechRepostory languageTechRepostory;
    List<Language> languages;
    private ModelMapperService modelMapperService;



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

        Language language = this.modelMapperService.forRequest().map(createLanguageRequest,Language.class);

        this.languageRepostory.save(language);
    }

    @Override
    public void deleteLanguage(int id) {


        Language language = languageRepostory.findById(id);
        languageRepostory.delete(language);


    }

    @Override
    public void updateLanguage(UpdateLanguageRequest updateLanguageRequest) {
        Language language = this.modelMapperService.forRequest().map(updateLanguageRequest,Language.class);

                languageRepostory.save(language);


    }

    @Override
    public GetByIdLanguageRespons    getLanguageId(int id) {

        Language language = languageRepostory.findById(id);
        GetByIdLanguageRespons responseItem = this.modelMapperService.forResponse()
                .map(language,GetByIdLanguageRespons.class);

            return responseItem ;

    }

//    GetByIdLanguageRespons respons = new GetByIdLanguageRespons();
//        respons.setLanguageName(language.getLanguageName());

//         return respons;


}
