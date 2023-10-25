${package}

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.time.LocalDateTime;

/**
* (${domain}) 实体
*
* @author ${author}
* @since 1.0
*/
@Entity(name = "${"${domain}"?replace("([a-z])([A-Z]+)","$1_$2","r")?lower_case}")
@DynamicInsert
@DynamicUpdate
public class ${domain} extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @Override
    public String toString() {
        return "LeafUser{" +
        "userId=" + userId +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", nickName='" + nickName + '\'' +
        ", avatar='" + avatar + '\'' +
        ", status=" + status +
        ", delFlag=" + delFlag +
        '}';
    }
}
