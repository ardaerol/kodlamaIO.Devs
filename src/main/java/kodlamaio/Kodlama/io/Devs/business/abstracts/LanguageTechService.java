package kodlamaio.Kodlama.io.Devs.business.abstracts;

import kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.CreateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.TechRequest.UpdateLanguageTechRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlamaio.Kodlama.io.Devs.business.responses.TechResponses.GetAllLanguageTechResponses;

import java.util.List;

public interface LanguageTechService {
    void addTech(CreateLanguageTechRequest createLanguageTechRequest);
    void deleteTech(int id);
    void updateTechLanguage(int id, UpdateLanguageTechRequest updateLanguageTechRequest);

    List<GetAllLanguageTechResponses> getAll();
}
