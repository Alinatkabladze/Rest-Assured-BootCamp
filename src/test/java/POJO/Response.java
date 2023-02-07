package POJO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("books")
	private List<BooksItem> books;

	public List<BooksItem> getBooks(){
		return books;
	}
}