package com.limingyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.MoviesMapper;
import com.limingyi.entity.Movies;
import com.limingyi.service.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService {
@Autowired MoviesMapper moviesDao;
	@Override
	public boolean addMovies(Movies movies) {
		return moviesDao.insert(movies)>0;
	}
	@Override
	public List<Movies> getAllMovies() {
		// TODO Auto-generated method stub
		return moviesDao.getAllMovies();
	}
	@Override
	public boolean clickAddOne(Integer id) {
		// TODO Auto-generated method stub
		return moviesDao.clickAddOne(id)>0;
	}
	@Override
	public Movies selectById(Integer id) {
		// TODO Auto-generated method stub
		return moviesDao.selectById(id);
	}
	@Override
	public List<Movies> listMostCommentsMovies() {
		// TODO Auto-generated method stub
		return moviesDao.listMostCommentsMovies();
	}

}
