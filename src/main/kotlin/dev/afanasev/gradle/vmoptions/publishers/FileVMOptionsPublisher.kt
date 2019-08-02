package dev.afanasev.gradle.vmoptions.publishers

class FileVMOptionsPublisher : VMOptionsPublisher {

    override fun publish(vmOptions: String) {
        // TODO: save in file
        println(vmOptions)
    }

}