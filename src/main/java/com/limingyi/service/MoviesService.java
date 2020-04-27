package com.limingyi.service;

import java.util.List;

import com.limingyi.entity.Movies;

public interface MoviesService {

    public boolean addMovies(Movies movies);

	public List<Movies> getAllMovies();

	public boolean clickAddOne(Integer id);

	public Movies selectById(Integer id);
	public List<Movies> listMostCommentsMovies();
}
