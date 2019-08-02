package dev.afanasev.gradle.vmoptions.publishers

interface VMOptionsPublisher {

    fun publish(vmOptions: String)

}