package com.agungsubastian.tlab.Presenter;

import com.agungsubastian.tlab.View.IOverflowView;

public class OverflowPresenter implements IOverflowPresenter{

    IOverflowView overflowView;

    public OverflowPresenter(IOverflowView overflowView) {
        this.overflowView = overflowView;
    }

    @Override
    public void search(String key) {

    }
}
