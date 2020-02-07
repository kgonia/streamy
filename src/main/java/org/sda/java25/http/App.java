package org.sda.java25.http;

import org.sda.java25.http.data.DataSource;
import org.sda.java25.http.model.Request;

import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Request> requests = DataSource.getInstance().getRequests();

        requests.forEach(System.out::println);

        // wypisz tylko zapytania typu GET


        // Wypisz tylko zapytania powyżej wielkości 100


        // Wypisz te zapytania które maja treść (payload)


        // Wypisz tylko te zapytania które oczekują odpowiedzi typu XML


        // Wypisz tylko te zapytania które oczekują odpowiedzi typu XML i są typu POST

        // Wypisz tylko te zapytania które zostały wysłane z przeglądarki Chrome
    }
}
