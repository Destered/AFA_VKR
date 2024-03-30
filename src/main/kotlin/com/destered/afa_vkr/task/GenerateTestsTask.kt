package com.destered.afa_vkr.task

import com.destered.afa_vkr.generator.TestGenerator
import com.destered.afa_vkr.model.HtmlElement
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project

class GenerateTestsTask(project: Project, private val elements: List<HtmlElement>)
    : Task.Modal(project, "Генерация автотестов", true) {

    override fun run(indicator: ProgressIndicator) {
        indicator.isIndeterminate = true // Устанавливаем индикатор выполнения без конкретных шагов
        generateAutoTests(elements, indicator) // Метод, где выполняется ваша логика генерации
    }

    private fun generateAutoTests(elements: List<HtmlElement>, indicator: ProgressIndicator) {
        // Примерная имитация длительной операции
        var totalSteps = 3
        var step = 1
        for (i in 1..totalSteps) {
            if (indicator.isCanceled) { // Проверяем, не был ли отменен процесс пользователем
                break
            }
            indicator.text = "Выполняем шаг: $step"
            val progress = step.toDouble() / totalSteps
            indicator.fraction = progress
            Thread.sleep(1000)
            step++
        }

        TestGenerator.generateTest(project, arrayListOf())

    }
}