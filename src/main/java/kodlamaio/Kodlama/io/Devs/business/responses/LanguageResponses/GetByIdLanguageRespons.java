package kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageRespons {
    private int languageId;
    private String languageName;

}
