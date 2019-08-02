package dev.afanasev.gradle.vmoptions.publishers

import org.gradle.api.logging.Logging

class SystemOutPublisher : VMOptionsPublisher {

    override fun publish(
            username: String,
            vmOptions: Collection<String>
    ) {
        val logger = Logging.getLogger(SystemOutPublisher::class.java)
        logger.info("User: $username, Options: $vmOptions")
    }

}