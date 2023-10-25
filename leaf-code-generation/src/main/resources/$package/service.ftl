${package}

import ${package}.${domain};
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
* ${domain} 业务接口
*
* @author ${author}
* @since 1.0
*/
public interface ${domain}Service {

    /**
    * 分页列表
    *
    * @param ${domain?uncap_first} 条件参数
    * @param page     分页参数
    * @return 符合条件的分页数据
    */
    Page<${domain}> listPage(${domain} ${domain?uncap_first}, Pageable page);

    /**
    * 根据 ID 获取详情
    *
    * @param id id
    * @return 详情对象
    */
    ${domain} findById(Long id);

    /**
    * 添加
    *
    * @param ${domain?uncap_first} 数据对象
    */
    ${domain} save(${domain} ${domain?uncap_first});

    /**
    * 更新
    *
    * @param ${domain?uncap_first} 数据对象
    */
    void update(${domain} ${domain?uncap_first});

    /**
    * 删除
    *
    * @param ids 删除数据的 id 集合
    */
    void remove(List<Long> ids);
}

