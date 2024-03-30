package com.destered.afa_vkr.generator

import com.destered.afa_vkr.generator.core.CoreGenerator
import com.destered.afa_vkr.model.HtmlElement
import com.intellij.lang.Language
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory


object TestGenerator {

    fun saveTextToFile(text: String, project: Project) {
        var factory = PsiFileFactory.getInstance(project);
        var file = factory.createFileFromText(Language.ANY, text)
    }

    fun generateTest(project: Project, elements: List<HtmlElement>) {
        var testCode = CoreGenerator.generateTestHeader() + "\n" + CoreGenerator.generateTestFooter()
        saveTextToFile(testCode, project)
    }



}