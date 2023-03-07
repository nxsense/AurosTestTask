package task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class KnowledgePackage {
    private long id;
    private String title;
    private String description;
    private String creationDate;

    public KnowledgePackage() {
        creationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

}
