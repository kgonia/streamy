package org.sda.java25.http.data;

import org.sda.java25.http.model.Header;
import org.sda.java25.http.model.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSource {

    private List<Request> requests = new ArrayList<Request>();

    private DataSource() {

        List<Header> headers = Arrays.asList(new Header("browser", "Chrome"), new Header("accept", "JSON"), new Header("xfv", "XML"));
        Request request = new Request(123, "/login", null, "GET", headers);

        requests.add(request);

        List<Header> headers1 = Arrays.asList(new Header("browser", "Chrome"), new Header("accept", "XML"));
        Request request1 = new Request(324, "/wuhan", null, "GET", headers1);

        requests.add(request1);

        List<Header> headers2 = Arrays.asList(new Header("browser", "Firefox"), new Header("accept", "XML"));
        Request request2 = new Request(90, "/wuhan", "some_data:some_value", "POST", headers2);

        requests.add(request2);

        List<Header> headers3 = Arrays.asList(new Header("browser", "IE"), new Header("accept", "XML"));
        Request request3 = new Request(45, "/logout", null, "POST", headers3);

        requests.add(request3);

    }

    private static DataSource INSTANCE = new DataSource();

    public static DataSource getInstance(){
        return INSTANCE;
    }

    public List<Request> getRequests() {
        return Collections.unmodifiableList(requests);
    }
}
