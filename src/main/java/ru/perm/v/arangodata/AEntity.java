package ru.perm.v.arangodata;

import com.arangodb.entity.DocumentField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AEntity implements Serializable {
    @Id
    @DocumentField(DocumentField.Type.KEY)
    protected String key;
}
