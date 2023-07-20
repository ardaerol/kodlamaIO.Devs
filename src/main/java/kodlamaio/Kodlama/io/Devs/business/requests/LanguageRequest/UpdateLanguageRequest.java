package kodlamaio.Kodlama.io.Devs.business.requests.LanguageRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageRequest {
    private int languageId;
    private String languageName;
}
