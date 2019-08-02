package dev.afanasev.gradle.vmoptions.tasks

import dev.afanasev.gradle.vmoptions.VMOptionsPluginExtension
import dev.afanasev.gradle.vmoptions.publishers.SystemOutVMOptionsPublisher
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

private const val VM_OPTIONS_PROPERTY = "jb.vmOptionsFile"
private const val USERNAME_PROPERTY = "user.name"

open class VMOptionsTask : DefaultTask() {

    @TaskAction
    fun taskAction() {
        val ext = extensions.findByType(VMOptionsPluginExtension::class.java) ?: VMOptionsPluginExtension()
        if (!ext.enabled) {
            logger.debug("Gradle VM Options plugin disabled")
        }

        val paths = System.getProperty(VM_OPTIONS_PROPERTY, "")
        val username = System.getProperty(USERNAME_PROPERTY, "unknown")

        if (paths.isNotEmpty()) {
            val options = mutableSetOf<String>()

            paths.split(",").forEach {
                logger.debug("Reading VM Options from $it")

                File(it).useLines { lines ->
                    lines.filter { line ->
                        line.startsWith("-")
                    }.forEach { line ->
                        options.add(line)
                    }
                }
            }

            SystemOutVMOptionsPublisher().publish(username, options)
        } else {
            logger.debug("Gradle VM Options plugin was executed not from IDE")
        }
    }

}