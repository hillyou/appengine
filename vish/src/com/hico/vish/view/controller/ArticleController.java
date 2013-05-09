package com.hico.vish.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hico.vish.dao.table.Article;
import com.hico.vish.manager.ArticleManager;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Autowired
	private ArticleManager articleManager;
	
	@RequestMapping("/createarticle")
	public String createArticle() {
		return "article/create";
	}
	
	@RequestMapping("/savearticle")
	public String saveArticle(HttpServletRequest request) {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Article article=new Article(title,content);
		articleManager.save(article);
		request.setAttribute("ARTICLE", article);
		return "article/update";
	}
	
	@RequestMapping("/updatearticle")
	public String updateArticle(Article article) {
//		String articleid=request.getParameter("articleid");
//		String title=request.getParameter("title");
//		String content=request.getParameter("content");
//		Article article=new Article(title,content);
//		article.setKey(Long.valueOf(articleid).longValue());
		articleManager.update(article);
		return "article/update";
	}
	
	@RequestMapping("/ajaxsavearticle")
	public void saveArticleWithAjax(Article article,HttpServletResponse response) {
		articleManager.save(article);
		try {
			response.setContentType("text/plain");
			PrintWriter printWriter=response.getWriter();
			printWriter.print("Save successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
