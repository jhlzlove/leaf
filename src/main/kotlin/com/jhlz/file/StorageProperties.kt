package com.jhlz.file

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

/**
 * 只有配置了 storage.type 才加载，如果没有则正常启动
 *
 * @author jhlz
 * @version x.x.x
 */
@Requires(property = "storage.type")
@ConfigurationProperties("storage")
data class StorageProperties(val type: String, val local: Local, val minio: Minio)

@ConfigurationProperties("storage.local")
data class Local(val path: String)

@ConfigurationProperties("storage.minio")
data class Minio(val url: String, val accessKey: String, val secretKey: String)
