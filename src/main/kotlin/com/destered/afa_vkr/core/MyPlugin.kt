import com.destered.afa_vkr.dialog.EnterDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.util.io.FileUtil
import java.awt.BorderLayout
import java.io.File
import javax.swing.*

class MyPlugin : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = EnterDialog()
        dialog.show()
    }
}