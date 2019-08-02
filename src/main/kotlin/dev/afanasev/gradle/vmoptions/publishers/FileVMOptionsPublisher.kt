package dev.afanasev.gradle.vmoptions.publishers

class FileVMOptionsPublisher : VMOptionsPublisher {

    override fun publish(
            username: String,
            vmOptions: Collection<String>
    ){
        // TODO: save in file
        println(vmOptions)
    }

}