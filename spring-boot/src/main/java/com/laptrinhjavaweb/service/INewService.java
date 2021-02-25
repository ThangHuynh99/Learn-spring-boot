package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.NewDTO;

public interface INewService  {
	NewDTO save(NewDTO newDTO);
	List<NewDTO> findAll(Pageable pageable);
	NewDTO findOne(long id);
	int getTotalItem();
	void delete(long ids[]);
}
