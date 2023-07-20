package kodlamaio.Kodlama.io.Devs.business.responses.LanguageResponses;

import kodlamaio.Kodlama.io.Devs.entities.concretes.LanguageTech;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
    private int languageId;
    private String languageName;
    private List<String> techName;
}
