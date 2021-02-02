package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "detail_emp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "national_code")
    private String nationalCode;

    @Column(name = "certificate_id")
    private String certificateId;

}
