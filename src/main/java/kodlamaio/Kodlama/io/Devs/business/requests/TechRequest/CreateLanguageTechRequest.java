package kodlamaio.Kodlama.io.Devs.business.requests.TechRequest;

import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageTechRequest {
    private String techName;
    private int techId;
    private int language;
}
