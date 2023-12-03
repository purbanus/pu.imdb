package pu.imdb.tryout;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;

public class TryoutImdbSearch
{
//@Test
public void tryoutImdbSearchLowercaseExactIsFalse() throws IOException, InterruptedException
{
	HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://moviesdatabase.p.rapidapi.com/titles/search/title/the%20matrix?titleType=movie"))
		.header("X-RapidAPI-Key", "4eb08fde59mshf619ed1389ec74ep1c12d5jsnbbdbd29ee814")
		.header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
}
//@Test
public void tryoutImdbSearchRightcaseExactIsTrue() throws IOException, InterruptedException
{
	HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://moviesdatabase.p.rapidapi.com/titles/search/title/The%20Matrix?exact=true&titleType=movie"))
		.header("X-RapidAPI-Key", "4eb08fde59mshf619ed1389ec74ep1c12d5jsnbbdbd29ee814")
		.header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
}
@Test
public void tryoutImdbSearchDoesNotExist() throws IOException, InterruptedException
{
	HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://moviesdatabase.p.rapidapi.com/titles/search/title/De%20Pipo%20is%20here?exact=true&titleType=movie"))
		.header("X-RapidAPI-Key", "4eb08fde59mshf619ed1389ec74ep1c12d5jsnbbdbd29ee814")
		.header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body());
}

}
