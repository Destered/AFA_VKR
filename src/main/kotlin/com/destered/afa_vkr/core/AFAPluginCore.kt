import com.destered.afa_vkr.dialog.EnterDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class AFAPluginCore : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = EnterDialog()
        dialog.show()
    }
}