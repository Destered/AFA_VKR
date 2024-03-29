package com.destered.afa_vkr.dialog

import com.destered.afa_vkr.model.HtmlElement
import com.destered.afa_vkr.model.ItemModel
import com.destered.afa_vkr.renderer.HtmlElementListCellRenderer
import com.intellij.openapi.ui.DialogWrapper
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.awt.BorderLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.net.URL
import javax.swing.*

class HtmlDialog(private val model: ItemModel) : DialogWrapper(true) {
    init {
        title = "HTML Содержимое"
        init()
    }

    override fun createCenterPanel(): JComponent? {
        val panel = JPanel(BorderLayout())

        val listModel = DefaultListModel<HtmlElement>()
        val list = JList(listModel)
        list.cellRenderer = HtmlElementListCellRenderer()

        try {
            val url = URL(model.site)
            val connection = url.openConnection()
            connection.getInputStream().use { inputStream ->
                val htmlDocument = Jsoup.parse(inputStream, "UTF-8", url.toString())
                val bodyElement = htmlDocument.body()

                if (bodyElement != null) {
                    parseElement(bodyElement, listModel)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        list.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                if (e?.clickCount == 2) {
                    val selectedIndex = list.selectedIndex
                    if (selectedIndex != -1) {
                        val selectedModel = listModel.getElementAt(selectedIndex)
                        JOptionPane.showMessageDialog(null, selectedModel.fullText, "Полный HTML", JOptionPane.INFORMATION_MESSAGE)
                    }
                }
            }
        })

        panel.add(JScrollPane(list), BorderLayout.CENTER)

        return panel
    }

    private fun parseElement(element: Element, listModel: DefaultListModel<HtmlElement>) {
        val text = element.ownText().trim()
        val fullText = element.toString()
        val tag = element.tag().toString()

        if (text.isNotBlank()) {
            val htmlElement = HtmlElement(text, fullText, tag)
            listModel.addElement(htmlElement)
        }

        for (childElement in element.children()) {
            parseElement(childElement, listModel)
        }
    }
}