package com.t3h.demo.dashboard;

import com.t3h.demo.BaseFrame;
import com.t3h.demo.BasePanel;

public class DashBoardFrame extends BaseFrame {
    private DashBoardPanel panel;

    @Override
    protected BasePanel getPanel() {
        panel = new DashBoardPanel();
        return panel;
    }

    @Override
    protected String getFrameTitle() {
        return "Dash Board";
    }

    public void setText(String userName, String password){
        panel.setText(userName, password);
    }
}
