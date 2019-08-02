package dev.afanasev.gradle.vmoptions.publishers

class SystemOutVMOptionsPublisher : VMOptionsPublisher {

    override fun publish(
            username: String,
            vmOptions: Collection<String>
    ) {
        println("$username: $vmOptions")
    }

}