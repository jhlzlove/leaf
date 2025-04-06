package com.jhlz.file

/**
 * @author jhlz
 * @version x.x.x
 */
class FileStorageManager {
    companion object {
        fun create(storageProperties: StorageProperties): FileStorageService {
            return when (storageProperties.type) {
                "minio" -> MinioStorageService()
                else -> LocalStorageService()
            }
        }
    }
}