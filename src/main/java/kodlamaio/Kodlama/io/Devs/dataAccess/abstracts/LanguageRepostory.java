package kodlamaio.Kodlama.io.Devs.dataAccess.abstracts;

import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageRepostory extends JpaRepository<Language,Integer> {
    Language findById(int id);

    boolean existsByLanguageName(String languageName);

}
