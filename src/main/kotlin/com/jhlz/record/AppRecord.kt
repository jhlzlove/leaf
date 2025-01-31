package com.jhlz.record

/**
 * @author jhlz
 * @version 1.0.0
 */
// @ConfigProperties(prefix = "leaf")
@JvmRecord
data class AppRecord( /* 系统版本 */
                      val version: String
)
