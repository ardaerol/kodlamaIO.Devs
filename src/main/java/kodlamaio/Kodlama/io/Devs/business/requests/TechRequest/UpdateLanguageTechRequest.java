package kodlamaio.Kodlama.io.Devs.business.requests.TechRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageTechRequest {
    private int techId;
    private int languageId;
    private String techName;
}
