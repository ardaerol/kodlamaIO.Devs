package kodlamaio.Kodlama.io.Devs.dataAccess.abstracts;

import kodlamaio.Kodlama.io.Devs.entities.concretes.LanguageTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageTechRepostory extends JpaRepository<LanguageTech,Integer> {
}
