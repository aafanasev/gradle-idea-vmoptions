package dev.afanasev.gradle.vmoptions.publishers

class InfluxDbPublisher(
        private val dbUrl: String,
        private val dbUsername: String,
        private val dbPassword: String
) : VMOptionsPublisher {

    override fun publish(
            username: String,
            vmOptions: Collection<String>
    ) {
        // TODO: upload
        println("Fake uploading to $dbUrl ($dbUsername, $dbPassword) data of $username $vmOptions")
    }

}