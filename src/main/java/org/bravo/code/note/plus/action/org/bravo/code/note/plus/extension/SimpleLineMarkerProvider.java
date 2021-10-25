package org.bravo.code.note.plus.action.org.bravo.code.note.plus.extension;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.util.RetinaImage;
import com.intellij.util.io.IOUtil;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.util.ImageHelper;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Collection;

/**
 * @author lijian
 * @since 2021/10/25
 */
public class SimpleLineMarkerProvider extends RelatedItemLineMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        // Add the property to a collection of line marker info
        NavigationGutterIconBuilder<PsiElement> builder =
                NavigationGutterIconBuilder.create(ImageHelper.MARKER_ICON)
                        .setTarget(element)
                        .setTooltipText("Navigate to Simple language property");
        result.add(builder.createLineMarkerInfo(element));
    }

}
