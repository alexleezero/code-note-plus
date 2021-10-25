package org.bravo.code.note.plus.action.org.bravo.code.note.plus.action;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.file.PsiFileImplUtil;
import com.intellij.psi.impl.source.PsiFileImpl;
import io.netty.util.NetUtil;
import org.apache.commons.lang3.StringUtils;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.constant.CommonConstant;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.gui.TestForm;
import org.jetbrains.annotations.NotNull;
import org.kohsuke.rngom.digested.DContainerPattern;

import javax.swing.*;
import java.awt.*;

/**
 * @author lijian
 * @since 2021/10/25
 */
public class AddNoteAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
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

            TestForm.show();
        }

    }
}
