package module5.com.library;

import module5.com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("module5/resources/applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.displayBook();
    }
}