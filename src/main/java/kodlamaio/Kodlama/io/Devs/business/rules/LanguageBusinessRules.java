package kodlamaio.Kodlama.io.Devs.business.rules;

import kodlamaio.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepostory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {
    private LanguageRepostory languageRepostory;

    public void checkIfLanguageNameExists(String languageName) {
        if (languageRepostory.existsByLanguageName(languageName)) {
            throw new BusinessException("Language name already exists");
        }
    }
}
