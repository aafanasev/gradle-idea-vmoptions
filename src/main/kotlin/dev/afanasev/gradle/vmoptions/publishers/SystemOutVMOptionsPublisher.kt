package dev.afanasev.gradle.vmoptions.publishers

class SystemOutVMOptionsPublisher : VMOptionsPublisher {

    override fun publish(vmOptions: String) {
        println(vmOptions)
    }

}