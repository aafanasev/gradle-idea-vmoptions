package dev.afanasev.gradle.vmoptions.publishers

class InfluxDbVMOptionsPublisher  : VMOptionsPublisher {

    override fun publish(
            username: String,
            vmOptions: Collection<String>
    ){
        // TODO: upload to InfluxDB server
    }

}