package com.grishberg.listarch.listarchitecture.common;
import com.github.grishberg.consoleview.*;
import android.os.*;
import android.util.*;

public class L
{
	private final Logger log;
	private final Handler handler;

	public L()
	{
		log = new LoggerImpl();
		handler = new LogHandler(Looper.getMainLooper());
	}
	
	public void d(String t, String m){
		Message msg = handler.obtainMessage(0, new Pair<String,String>(t, m));
		handler.sendMessage(msg);
	}
	
	private class LogHandler extends Handler
	{
		LogHandler(Looper looper){
			super(looper);
		}
		
		@Override
		public void dispatchMessage(Message msg)
		{
			Pair<String, String> m = (Pair<String, String>) msg.obj;
			log.d(m.first, m.second);
		}
		
	}
}
