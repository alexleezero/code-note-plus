package org.bravo.code.note.plus.action.org.bravo.code.note.plus.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.psi.PsiFile;
import org.apache.commons.lang3.StringUtils;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.extension.service.MyData;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.extension.service.TestPersistentService;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.gui.TestForm;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijian
 * @since 2021/10/25
 */
public class AddNoteAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        TestPersistentService instance = TestPersistentService.getInstance();
        String title = null;
        if (null == instance.getState()) {
            MyData myData = new MyData();
            myData.setId("alex_id");
            myData.setName("alex_name");
            Map<String, String> caches = new HashMap<>();
            caches.put("key1", "value1");
            caches.put("key2", "value2");
            myData.setCaches(caches);
            instance.setData(myData);
            title = "我的标题";
        } else {
            instance.setData(null);
            title = "alex_name";
            System.out.println(instance.getState());
        }

        // get the class file of current operated
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        String classPath;
        if (null != psiFile) {
            classPath = psiFile.getVirtualFile().getName();
        }

        // get selected text
        String selectedText;
        Editor data = e.getData(CommonDataKeys.EDITOR);
        if (null != data) {
            SelectionModel selectionModel = data.getSelectionModel();
            selectedText = selectionModel.getSelectedText();
            if (StringUtils.isEmpty(selectedText))
                return;

            Document document = data.getDocument();
            int startLineNum = document.getLineNumber(selectionModel.getSelectionStart());
            int endLineNum = document.getLineNumber(selectionModel.getSelectionEnd());

            TestForm.show(title);
        }

    }
}
