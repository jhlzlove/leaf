package com.jhlz.record

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @version 1.0.0
 */
@JvmRecord
data class R( /* 状态码 */
              val status: Int,  /* 信息 */
              val message: String,  /* 信息描述 */
              @field:JsonInclude(value = JsonInclude.Include.NON_NULL) @param:JsonInclude(
                  value = JsonInclude.Include.NON_NULL
              ) val description: String?,  /* 数据 */
              @field:JsonInclude(value = JsonInclude.Include.NON_NULL) @param:JsonInclude(
                  value = JsonInclude.Include.NON_NULL
              ) val data: Any?
) : Serializable {
    override fun toString(): String {
        return this.message
    }

    companion object {
        @JvmOverloads
        fun ok(data: Any? = null): R {
            return ok(200, "操作成功！", data)
        }

        fun ok(code: Int, message: String, data: Any?): R {
            return ok(code, message, null, data)
        }

        fun error(message: String): R {
            return error(500, message)
        }

        @JvmOverloads
        fun error(code: Int = 500, message: String = "内部错误！"): R {
            return ok(code, message, null, null)
        }

        /**
         * 返回信息构造
         *
         * @param code        响应码
         * @param message     响应信息
         * @param description 响应信息详情
         * @param data        响应数据
         * @return Response 对象
         */
        private fun ok(code: Int, message: String, description: String?, data: Any?): R {
            return R(code, message, description, data)
        }
    }
}
