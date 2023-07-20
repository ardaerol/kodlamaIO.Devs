package kodlamaio.Kodlama.io.Devs.business.responses.TechResponses;

import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguageTechResponses {
    private int techId;
    private String techName;
    private int language;
}
