package dev.afanasev.gradle.vmoptions

import dev.afanasev.gradle.vmoptions.config.InfluxDbConfiguration
import groovy.lang.Closure

open class VMOptionsPluginExtension {

    var enabled: Boolean = true
    var influxDb: InfluxDbConfiguration? = null

    fun influxDb(block: InfluxDbConfiguration.() -> Unit) {
        influxDb = InfluxDbConfiguration().also(block)
    }

    fun influxDb(closure: Closure<*>) {
        influxDb = InfluxDbConfiguration()
        closure.delegate = influxDb
        closure.call()
    }

}