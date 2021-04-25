package ru.perm.v.arangodata;

import com.arangodb.springframework.annotation.Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Document(collection = "sp2_recorder_stv")
public class RecommendOrderStv extends AEntity {
    private String agreement;
    private String discount;
    private String position;
    private String name;
    private String shortName;
    private String price;
    private String count;
    private String category;
    private String group;
    private String tCoefficient;
    private String version;
    private String ppoUserId;
    private String dealerId;
}
