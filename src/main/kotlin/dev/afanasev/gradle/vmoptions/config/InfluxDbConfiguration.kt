package dev.afanasev.gradle.vmoptions.config

open class InfluxDbConfiguration {
    var url: String = ""
    var username: String = ""
    var password: String = ""
    var database: String = ""
    var retentionPolicy: String = ""
}