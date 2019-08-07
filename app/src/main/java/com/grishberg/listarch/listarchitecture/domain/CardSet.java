package com.grishberg.listarch.listarchitecture.domain;
import java.util.*;

public interface CardSet
{
	void onCardsReceived(List<Card> newCards);
}
