${package}

import ${package}.${domain};
import ${package}.${domain}Service;
import ${package}.${domain}Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* ${domain} 业务接口实现层
*
* @author ${author}
* @since 1.0
*/
@Service
public class ${domain}ServiceImpl implements ${domain}Service {

    private static final Logger log = LoggerFactory.getLogger(${domain}ServiceImpl.class);
    private final ${domain}Repository ${domain?uncap_first}Repository;

    public ${domain}ServiceImpl(${domain}Repository ${domain?uncap_first}Repository) {
        this.${domain?uncap_first}Repository = ${domain?uncap_first}Repository;
    }

    @Override
    public Page<${domain}> listPage(${domain} ${domain?uncap_first}, Pageable page) {
        return ${domain?uncap_first}Repository.findAll(Example.of(${domain?uncap_first}), page);
    }

    @Override
    public ${domain} findById(Long id) {
        return ${domain?uncap_first}Repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${domain?uncap_first} save(${domain} ${domain?uncap_first}) {
        return ${domain?uncap_first}Repository.save(${domain?uncap_first});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(${domain} ${domain?uncap_first}) {
        ${domain?uncap_first}Repository.save(${domain?uncap_first});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        ${domain?uncap_first}Repository.deleteAllById(ids);
    }
}