package com.jhlz.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.multipart.StreamingFileUpload
import java.io.File

/**
 * @author jhlz
 * @version x.x.x
 */
@Controller("/file")
class FileController {

    @Post(consumes = [MediaType.MULTIPART_FORM_DATA])
    fun uploadFile(file: StreamingFileUpload) {

        println(file.filename)
        println(file.size)
        println(file.contentType)
        file.transferTo(File("D:\\" + file.filename))
    }
}