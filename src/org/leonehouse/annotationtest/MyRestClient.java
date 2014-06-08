package org.leonehouse.annotationtest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@Rest(rootUrl = "http://company.com/ajax/services", converters = { MappingJacksonHttpMessageConverter.class })
public interface MyRestClient {
	@Get("/events")
	Object getEvents();

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByYearAndLocation(int year, String location);

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByLocationAndYear(String location, int year);
}