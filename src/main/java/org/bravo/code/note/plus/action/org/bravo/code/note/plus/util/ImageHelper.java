package org.bravo.code.note.plus.action.org.bravo.code.note.plus.util;

import com.intellij.idea.LoggerFactory;
import com.intellij.openapi.diagnostic.Logger;
import org.bouncycastle.cms.PasswordRecipientId;
import org.bravo.code.note.plus.action.org.bravo.code.note.plus.extension.SimpleLineMarkerProvider;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lijian
 * @since 2021/10/25
 */
public class ImageHelper {
    private static final Logger LOG = Logger.getInstance(ImageHelper.class);
    private static final String MARKER_ICON_PATH = "icons/code.png";
    public static byte[] MARKER_ICON_BYTES = null;
    public static ImageIcon MARKER_ICON = null;

    static {
        try (InputStream is = SimpleLineMarkerProvider.class.getClassLoader().getResourceAsStream(MARKER_ICON_PATH)) {
            if (null != is) {
                byte[] bytes = new byte[is.available()];
                is.read(bytes);
                MARKER_ICON_BYTES = bytes;
                MARKER_ICON = new ImageIcon(ImageIO.read(new ByteArrayInputStream(MARKER_ICON_BYTES)));
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

}
