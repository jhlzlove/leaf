${package};

import ${package}.${domain}Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
* ${domain} 控制层
*
* @author ${author}
* @since 1.0
*/
@Tag(name = "/${domain?uncap_first}")
@RestController
@RequestMapping("/${domain?uncap_first}")
public class ${domain}Controller {

    private static final Logger log = LoggerFactory.getLogger(LeafUserController.class);
    private final ${domain}Service ${domain?uncap_first}Service;

    public ${domain}Controller(${domain}Service ${domain?uncap_first}Service) {
        this.${domain?uncap_first}Service = ${domain?uncap_first}Service;
    }

    /**
    * ${domain} 分页列表
    */
    @GetMapping
    @Operation(summary = "分页列表", description = "默认分页从 0 开始，每页 10 条数据")
    public Page<${domain}> listPage(@RequestBody ${domain} ${domain?uncap_first}, @PageableDefault(page = 0, size = 10) Pageable page) {
        return ${domain?uncap_first}Service.listPage(${domain?uncap_first}, page);
    }

    @GetMapping("/{id}")
    @Operation(summary = "详情", description = "根据 id 获取详情")
    public ${domain} queryById(@PathVariable Long id) {
        return ${domain?uncap_first}Service.findById(id);
    }

    @PostMapping
    @Operation(summary = "添加")
    public void add(@RequestBody LeafUser request) {
        ${domain?uncap_first}Service.save(request);
    }

    @PutMapping
    @Operation(summary = "修改")
    public void edit(@RequestBody LeafUser leafUser) {
        ${domain?uncap_first}Service.update(leafUser);
    }

    @DeleteMapping("/{ids}")
    @Operation(summary = "删除")
    public Response delete(@PathVariable List<Long> ids) {
        ${domain?uncap_first}Service.remove(ids);
        return Response.ok();
    }
}