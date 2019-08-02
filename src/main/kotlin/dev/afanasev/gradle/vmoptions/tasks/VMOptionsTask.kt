package dev.afanasev.gradle.vmoptions.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class VMOptionsTask : DefaultTask() {

    @TaskAction
    fun taskAction() {
        val paths = System.getProperty("jb.vmOptionsFile", "")

        if (paths.isNotEmpty()) {
            paths.split(",").forEach {
                println("asdasd $it")
            }
        } else {
            println("asdasd empty")
        }
    }

}