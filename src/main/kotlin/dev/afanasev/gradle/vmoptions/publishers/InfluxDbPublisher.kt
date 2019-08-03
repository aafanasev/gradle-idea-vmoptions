package dev.afanasev.gradle.vmoptions.publishers

import org.gradle.api.logging.Logging
import org.influxdb.BatchOptions
import org.influxdb.InfluxDBFactory
import org.influxdb.dto.Point
import java.util.concurrent.*

class InfluxDbPublisher(
        private val dbUrl: String,
        private val dbUsername: String,
        private val dbPassword: String,
        private val dbName: String,
        private val rpName: String
) : VMOptionsPublisher {

    override fun publish(
            username: String,
            vmOptions: Collection<String>
    ) {
        val logger = Logging.getLogger(InfluxDbPublisher::class.java)
        val influx = InfluxDBFactory.connect(dbUrl, dbUsername, dbPassword)

        influx.enableBatch(BatchOptions.DEFAULTS.exceptionHandler { _, throwable ->
            logger.lifecycle("Cannot write to InfluxDB: $dbUrl, db: $dbName", throwable)
        })

        val record = Point.measurement("vmoptions")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("username", username)
                .addField("vmoptions", vmOptions.toString())
                .build()

        influx.write(dbName, rpName, record)
        influx.close()
    }

}