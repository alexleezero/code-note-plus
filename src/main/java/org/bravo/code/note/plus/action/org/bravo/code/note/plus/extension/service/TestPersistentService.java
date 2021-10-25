package org.bravo.code.note.plus.action.org.bravo.code.note.plus.extension.service;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author lijian
 * @since 2021/10/25
 */
@State(
        name = "MyIdeaDemo",
        storages = {@Storage("my-idea-demo.xml")}
)
public class TestPersistentService implements PersistentStateComponent<MyData> {

    private MyData data;

    public static TestPersistentService getInstance() {
        return ApplicationManager.getApplication().getService(TestPersistentService.class);
    }

    @Override
    public @Nullable MyData getState() {
        return this.data;
    }

    @Override
    public void loadState(@NotNull MyData state) {
        this.data = state;
    }

    public void setData(MyData data) {
        this.data = data;
    }
}
