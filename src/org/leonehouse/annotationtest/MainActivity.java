package org.leonehouse.annotationtest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.rest.RestService;

import android.app.Activity;
import android.util.Log;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	
	
	
    @RestService
    MyRestClient myRestClient; //Inject it

    @AfterViews
    @Background
    void afterViews() {
        Object result = myRestClient.getTime(); //Play with it
        Log.d("test",result.toString());
    }
    
    

	/*
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
	*/
	
}