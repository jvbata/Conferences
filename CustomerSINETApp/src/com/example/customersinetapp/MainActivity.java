package com.example.customersinetapp;

import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView lv_conference_and_events;
	Vector<Events> eventsList = new Vector<Events>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	private void init() {

		Events e = new Events();
		e.setDescription("Do you see any Teletubbies in here? Do you see a slender plastic tag clipped to my shirt with my name printed on it? Do you see a little Asian child with a blank expression on his face sitting outside on a mechanical helicopter that shakes when you put quarters in it? No? Well, that's what you see at a toy store. And you must think you're in a toy store, because you're here shopping for an infant named Jeb.");
		e.setType(1);
		eventsList.add(e);

		Events b = new Events();
		b.setDescription("El snort testosterone trophy driving gloves handsome, dis el snort handsome gent testosterone trophy Fallen eyebrow driving gloves cardinal richelieu gentleman face broom, chevron driving gloves dis cardinal richelieu gentleman gent el snort handsome ron burgundy Leonine funny walk groucho marx Fallen eyebrow rock n roll star great dictator testosterone trophy face broom?");
		b.setType(2);
		eventsList.add(b);

		Events a = new Events();
		a.setDescription("El snort testosterone trophy driving gloves handsome, dis el snort handsome gent testosterone trophy Fallen eyebrow driving gloves cardinal richelieu gentleman face broom, chevron driving gloves dis cardinal richelieu gentleman gent el snort handsome ron burgundy Leonine funny walk groucho marx Fallen eyebrow rock n roll star great dictator testosterone trophy face broom?");
		a.setType(3);
		eventsList.add(a);

		lv_conference_and_events = (ListView) findViewById(R.id.lv_conferences_and_events);

		lv_conference_and_events.setAdapter(new MyListAdapter(this,
				R.id.lv_conferences_and_events, eventsList));
	}

	private class MyListAdapter extends ArrayAdapter<Events> {

		public MyListAdapter(Context context, int resource, List<Events> objects) {
			super(context, resource, objects);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			Events currentEvent = eventsList.get(position);

			if (convertView == null) {
				convertView = getLayoutInflater().inflate(R.layout.list_item,
						null);
			}

			TextView tv_eventType = (TextView) convertView
					.findViewById(R.id.tv_event_type);
			TextView tv_eventDescription = (TextView) convertView
					.findViewById(R.id.tv_conference_events_description);

			setEventTypeColor(tv_eventType, currentEvent.getEventType());

			tv_eventDescription.setText(currentEvent.getDescription());

			return convertView;
		}

		@SuppressWarnings("deprecation")
		private void setEventTypeColor(final TextView tv_eventType,
				final int eventType) {

			final Resources mResources = getResources();

			int color = 0;

			switch (eventType) {

			case 1:
				color = mResources.getColor(R.color.light_blue);
				break;
			case 2:
				color = mResources.getColor(R.color.light_purple);
				break;
			case 3:
				color = mResources.getColor(R.color.light_green);
				break;

			}

			tv_eventType.setBackgroundColor(color);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
