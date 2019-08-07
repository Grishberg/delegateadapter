package com.grishberg.listarch.listarchitecture.domain;

public interface Zen
{
	boolean isEnabled();
	void addTeasersReceivedAction(TeaserReceivedAction action);
	
	public interface TeaserReceivedAction{
		void onTeasersReceived();
	}
}
