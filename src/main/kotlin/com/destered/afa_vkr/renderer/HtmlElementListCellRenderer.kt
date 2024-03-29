package com.destered.afa_vkr.renderer

import com.destered.afa_vkr.model.HtmlElement
import java.awt.Component
import javax.swing.DefaultListCellRenderer
import javax.swing.JList

class HtmlElementListCellRenderer : DefaultListCellRenderer() {
    override fun getListCellRendererComponent(list: JList<*>?, value: Any?, index: Int, isSelected: Boolean, cellHasFocus: Boolean): Component {
        val renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)
        if (value is HtmlElement) {
            text = value.title
        }
        return renderer
    }
}