package org.leonehouse.annotationtest.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeData {	
	
	@JsonProperty("time")
	private String time;
	
	@JsonProperty("milliseconds_since_epoch")
	private long millis;
	
	@JsonProperty("date")
	private String date;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("time : ").append(this.time).append("\n");
		builder.append("millis : ").append(this.millis).append("\n");
		return builder.toString();
	}
}
