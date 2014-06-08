package org.leonehouse.annotationtest;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.leonehouse.annotationtest.data.TimeData;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@Rest(rootUrl = "http://time.jsontest.com/", converters = { MappingJacksonHttpMessageConverter.class })
public interface MyRestClient {
	@Get("")
	@Accept(MediaType.APPLICATION_JSON)
	TimeData getTime();
	
	@Get("")
	Object getEvents();

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByYearAndLocation(int year, String location);

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByLocationAndYear(String location, int year);
}