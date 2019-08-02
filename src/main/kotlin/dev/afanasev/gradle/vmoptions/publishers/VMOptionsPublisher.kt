package dev.afanasev.gradle.vmoptions.publishers

interface VMOptionsPublisher {

    fun publish(
            username: String,
            vmOptions: Collection<String>
    )

}