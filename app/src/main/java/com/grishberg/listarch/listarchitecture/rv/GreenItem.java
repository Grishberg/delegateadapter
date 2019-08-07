package com.grishberg.listarch.listarchitecture.rv;

public class GreenItem implements Item<ItemViewHolder> {
    private final String title;

    public GreenItem(String title) {
        this.title = "green " + title;
    }

    @Override
    public boolean isRed() {
        return false;
    }

    public void doSpecialForGreen() {
    }

    @Override
    public void renderToViewHolder(ItemViewHolder vh) {
        vh.setTitle(title);
    }
}
