package com.example.crawling;

import  org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) {
		String url = "https://www.aladin.co.kr/home/webookmain.aspx?start=we_tab";
		Connection conn = Jsoup.connect(url);

		try{
			Document document = conn.get();
			Elements titles = document.select("div.bestseller_book dd h4 a");
			Elements prices = document.select("div.bestseller_book div.price strong");

			for(int i=0; i<10; i++){
				Element title = titles.get(i);
				Element price = prices.get(i);
				System.out.println(title.text() + " " + price.text());
			}
//			for(Element element : titles){
//				System.out.println(element);
//			}
//			for(Element element : prices){
//				System.out.println(element);
//			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}