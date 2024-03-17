package utils;

import view.WindowsFrame;

public enum WindowsFrameObject {
    WINDOWS_APP_OBJECT(new WindowsFrame());
    private final WindowsFrame windowsFrame;
    WindowsFrameObject(WindowsFrame windowsFrame) {
        this.windowsFrame = windowsFrame;
    }
    public WindowsFrame getObject(){
        return windowsFrame;
    }
}
