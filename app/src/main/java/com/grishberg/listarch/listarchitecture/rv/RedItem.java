package com.grishberg.listarch.listarchitecture.rv;

public class RedItem implements Item<ItemViewHolder> {
    private final String title;
    private final int id;


    public RedItem(int id, String title) {
        this.id = id;
        this.title = "red " + title;
    }

    @Override
    public int getId() {
        return id;
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
