package com.hico.vish.manager;

import java.util.Date;

import com.hico.vish.dao.processor.ArticleDao;
import com.hico.vish.dao.table.Article;

public class ArticleManager {
	private ArticleDao articleDao;
	
	public Article getById(Long id) {
		return articleDao.get(id);
	}
	
	public void save(Article article) {
		setDefault(article);
		article.setCreateDate(new Date());
		articleDao.saveOrUpdate(article);
	}

	public void update(Article article) {
		article.setModifyDate(new Date());
		articleDao.saveOrUpdate(article);
	}
	
	public void saveAndPublish(Article article) {
		article.setCreateDate(new Date());
		article.setPublishDate(new Date());
		article.setPublished(true);
		articleDao.saveOrUpdate(article);
	}
	
	public void updateAndPublish(Article article) {
		article.setModifyDate(new Date());
		article.setPublishDate(new Date());
		article.setPublished(true);
		articleDao.saveOrUpdate(article);
	}
	
	public void publish(Article article) {
		article.setModifyDate(new Date());
		article.setPublishDate(new Date());
		article.setPublished(true);
		articleDao.saveOrUpdate(article);
	}
	
	public void withdrawPublish(Article article) {
		article.setModifyDate(new Date());
		article.setPublishDate(new Date());
		article.setPublished(false);
		articleDao.saveOrUpdate(article);
	}


	public void valid(Article article) {
		article.setModifyDate(new Date());
		article.setValid(true);
		articleDao.saveOrUpdate(article);
	}
	
	public void inValid(Article article) {
		article.setModifyDate(new Date());
		article.setValid(false);
		articleDao.saveOrUpdate(article);
	}

	public void delete(Article article) {
		article.setModifyDate(new Date());
		article.setDelete(true);
		articleDao.saveOrUpdate(article);
	}
	
	public void restore(Article article) {
		article.setModifyDate(new Date());
		article.setDelete(false);
		articleDao.saveOrUpdate(article);
	}
	
	private void setDefault(Article article) {
		article.setValid(true);
		article.setDelete(false);
	}
	
	/**
	 * @return the articleDao
	 */
	public ArticleDao getArticleDao() {
		return articleDao;
	}

	/**
	 * @param articleDao
	 *            the articleDao to set
	 */
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
