package dev.afanasev.gradle.vmoptions

import dev.afanasev.gradle.vmoptions.tasks.VMOptionsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("Unused")
class VMOptionsPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.create("vmOptions", VMOptionsPluginExtension::class.java)
        target.tasks.register("vmOptions", VMOptionsTask::class.java)
    }

}