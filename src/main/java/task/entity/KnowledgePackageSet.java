package task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgePackageSet {
    private long id;
    private String title;
    private List<KnowledgePackage> knowledgePackages;
}
