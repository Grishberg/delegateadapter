package com.grishberg.listarch.listarchitecture.domain;

import java.util.*;

public class AlertLineCardsSet implements CardSet, Zen.TeaserReceivedAction {

    private final CardList cardList;
    private final Zen zen;

    public AlertLineCardsSet(CardList cardList, Zen zen) {
        this.cardList = cardList;
        this.zen = zen;
        zen.addTeasersReceivedAction(this);
    }

    @Override
    public void onCardsReceived(List<Card> newCards) {
        // TODO: Implement this method
    }

    @Override
    public void onTeasersReceived() {
        // TODO: Implement this method
    }
}
