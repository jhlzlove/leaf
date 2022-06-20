package com.market.web.controller.tool;

import com.market.common.core.controller.BaseController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * swagger 接口
 * 测试冲突所写 jhlz
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/tool/swagger")
public class SwaggerController extends BaseController {

    @PreAuthorize("@ss.hasPermi('tool:swagger:view')")
    @GetMapping()
    public String index() {
        return redirect("/swagger-ui.html");
    }
}
