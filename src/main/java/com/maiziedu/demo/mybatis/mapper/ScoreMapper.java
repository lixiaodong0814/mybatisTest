package com.maiziedu.demo.mybatis.mapper;

import java.util.List;

import com.maiziedu.demo.mybatis.bean.Score;

public interface ScoreMapper {
	
	public List<Score> getScoreByStudentandKeMu(Score score);
	
}
