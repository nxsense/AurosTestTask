package task.dto.request;

public class KPacKPacSetRequestDto {
    private Long kPacSetId;
    private Long kPacId;

    public Long getkPacSetId() {
        return kPacSetId;
    }

    public void setkPacSetId(Long kPacSetId) {
        this.kPacSetId = kPacSetId;
    }

    public Long getkPacId() {
        return kPacId;
    }

    public void setkPacId(Long kPacId) {
        this.kPacId = kPacId;
    }
}
