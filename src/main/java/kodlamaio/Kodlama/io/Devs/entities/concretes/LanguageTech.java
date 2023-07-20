package kodlamaio.Kodlama.io.Devs.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Technology")
@Entity

public class LanguageTech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "techId")
    private int techId;
    @Column(name = "techName")
    private String techName;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;

    @Override
    public String toString() {
        return "Technologi{" + "techId=" + techId + ", techName='" + techName + '\'' + '}';
    }
}
