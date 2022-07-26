package org.gen.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.gen.springboot.bean.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

@RestController
public class BookController {

	// @Autowired
	// Book book;
	//
	// @GetMapping("/book")
	// public String book() {
	//
	// System.out.println(book.toString());
	// return book.toString();
	// }
	
	// @GetMapping("/books")
	// public ModelAndView books() {
	//
	// List<Book> books = new ArrayList<>();
	//
	// Book book1 = new Book();
	// book1.setId(1);
	// book1.setAuthor("罗贯中");
	// book1.setName("三国演义");
	// Book book2 = new Book();
	// book2.setId(2);
	// book2.setAuthor("曹雪芹");
	// book2.setName("红楼梦");
	// books.add(book1);
	// books.add(book2);
	// ModelAndView mView = new ModelAndView();
	// mView.addObject("books", books);
	// // 指定servlet相对路径下的视图文件(即页面名称)
	// mView.setViewName("books");
	// return mView;
	// }

	@GetMapping("/books")
	public List<Book> books() {

		List<Book> books = new ArrayList<>();

		Book book1 = new Book();
		book1.setId(1);
		book1.setAuthor("罗贯中");
		book1.setName("三国演义");
		Book book2 = new Book();
		book2.setId(2);
		book2.setAuthor("曹雪芹");
		book2.setName("红楼梦");
		books.add(book1);
		books.add(book2);
		
		return books;
	}

	@GetMapping("/book")
	public Book book() {

		Book book1 = new Book();
		book1.setId(3);
		book1.setAuthor("吴承恩");
		book1.setName("西游记");

		return book1;
	}
}
