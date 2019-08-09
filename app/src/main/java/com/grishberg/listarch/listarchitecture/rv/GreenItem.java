package com.grishberg.listarch.listarchitecture.rv;

public class GreenItem implements Item<ItemViewHolder> {
    private final int id;
    private final String title;

    public GreenItem(int id, String title) {
        this.id = id;
        this.title = "green " + title;
    }

    @Override
    public int getId() {
        return id;
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
