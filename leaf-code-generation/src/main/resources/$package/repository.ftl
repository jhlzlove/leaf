${package}

import ${package}.${domain};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* ${domain} 持久层
*
* @author ${author}
* @since 1.0
*/
@Repository
public interface ${domain}Repository extends JpaRepository<${domain}, Long> {

}

