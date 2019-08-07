package com.grishberg.listarch.listarchitecture.rv;

public class RedItem implements Item<ItemViewHolder> {
    private final String title;

    public RedItem(String title) {
        this.title = "red " + title;
    }

    @Override
    public boolean isRed() {
        return true;
    }

    public void doSpecialForRed() {
    }

    @Override
    public void renderToViewHolder(ItemViewHolder vh) {
        vh.setTitle(title);
    }
}
