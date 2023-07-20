package kodlamaio.Kodlama.io.Devs.business.abstracts;

import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetByIdLanguageRespons;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    List<GetAllLanguageResponse> getAll();

    void addLanguage(CreateLanguageRequest createLanguageRequest) throws Exception;
    void deleteLanguage(int id);
    void updateLanguage(UpdateLanguageRequest updateLanguageRequest);
    GetByIdLanguageRespons getLanguageId(int id);
}
