package com.ruanko.service;

import java.util.List;

import com.ruanko.dao.TagDao;
import com.ruanko.model.Tag;

public class TagService {
	TagDao tagDao;
	public TagService() {
		tagDao = new TagDao();
	}
	
	public List<Tag> allTags(){
		return tagDao.allTags();
	}
}
