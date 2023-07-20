package kodlamaio.Kodlama.io.Devs.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.security.PublicKey;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Language")

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId")
    private int languageId;
    @Column(name = "languageName")
    private String languageName;

    @OneToMany(mappedBy = "language")
    private List<LanguageTech> languageTeches;

    @Override public String toString() { return "Language{" + "languageId=" + languageId + ", languageName='" + languageName + '\'' + '}'; }



}
