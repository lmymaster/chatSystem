package com.limingyi.dao;

import java.util.List;

import com.limingyi.entity.Movies;

public interface MoviesMapper {
	int insert(Movies movies);

	List<Movies> getAllMovies();

	int clickAddOne(Integer id);

	Movies selectById(Integer id);
	
	List<Movies> listMostCommentsMovies();
}
