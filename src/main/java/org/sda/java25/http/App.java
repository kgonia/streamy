package org.sda.java25.http;

import org.sda.java25.http.data.DataSource;
import org.sda.java25.http.model.Header;
import org.sda.java25.http.model.Request;

import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Request> requests = DataSource.getInstance().getRequests();

        requests.forEach(System.out::println);

        // wypisz tylko zapytania typu GET

        requests.stream()
                .filter(request -> request.getType().equals("GET"))
                .forEach(System.out::println);

        // Wypisz tylko zapytania powyżej wielkości 100

        requests.stream()
                .filter(request -> request.getSize() > 100)
                .forEach(System.out::println);


        // Wypisz te zapytania które maja treść (payload)

        requests.stream()
                .filter(request -> request.getPayload() != null)
                .forEach(System.out::println);


        // Wypisz tylko te zapytania które oczekują odpowiedzi typu XML

        System.out.println("odpowiedzi typu XML");
        //nie działa, trzeba nadpisać equals żeby zadziałało
        requests.stream()
                .filter(request ->
                    request.getHeaders().contains(new Header("accept", "XML"))
                ).forEach(System.out::println);;

        requests.stream()
                .filter(request -> {
                    return request.getHeaders()
                            .stream()
                            .anyMatch(header -> "accept".equals(header.getKey()) && "XML".equals(header.getValue()));
                })
                .forEach(System.out::println);

        requests.stream()
                .filter(App::filterRequestThatAcceptXML)
                .forEach(System.out::println);

        requests.stream()
                .filter(request -> {
                    long result = request.getHeaders()
                            .stream()
                            .filter(header -> header.getKey().equals("accept") && header.getValue().equals("XML"))
                            .count();
                    return result > 0;
                })
                .forEach(System.out::println);


        // Wypisz tylko te zapytania które oczekują odpowiedzi typu XML i są typu POST

        // Wypisz tylko te zapytania które zostały wysłane z przeglądarki Chrome
    }

    private static boolean filterRequestThatAcceptXML(Request request) {
        return request.getHeaders()
                .stream()
                .anyMatch(header -> header.getKey().equals("accept") && header.getValue().equals("XML"));
    }
}
