package org.leonehouse.annotationtest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.HttpsClient;
import org.androidannotations.annotations.UiThread;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import android.app.Activity;
import android.widget.Toast;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	
	
	/*
    @RestService
    MyRestClient myRestClient; //Inject it

    @AfterViews
    void afterViews() {
        myRestClient.getEvents(); //Play with it
    }
    */
    

	
	@HttpsClient
	HttpClient httpsClient;

	@AfterInject
	@Background
	public void securedRequest() {
		try {
			HttpGet httpget = new HttpGet("https://www.verisign.com/");
			HttpResponse response = httpsClient.execute(httpget);
			doSomethingWithResponse(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@UiThread
	public void doSomethingWithResponse(HttpResponse resp) {
		Toast.makeText(this,
				"HTTP status " + resp.getStatusLine().getStatusCode(),
				Toast.LENGTH_LONG).show();
	}
	
}