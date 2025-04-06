package com.jhlz.file

import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

/**
 * @author jhlz
 * @version x.x.x
 */
@Factory
class FileStorageFactory {

    @Singleton
    fun create(storageProperties: StorageProperties): FileStorageService {
        return FileStorageManager.create(storageProperties)
    }
}