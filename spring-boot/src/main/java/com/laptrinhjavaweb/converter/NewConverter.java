package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO result = new NewDTO();
		result.setCategoryCode(entity.getCategory().getCode());
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setModifiedDate(entity.getModifiedDate());
		result.setModifiedBy(entity.getModifiedBy());
		result.setCreatedDate(entity.getCreatedDate());
		result.setCreatedBy(entity.getCreatedBy());
		return result;	
	}
	
	public NewEntity toEntity(NewDTO dto, CategoryEntity cateDTO) {
		NewEntity result = new NewEntity();
		result.setCategory(cateDTO);	
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	//ap dung tinh da hinh, override
	public NewEntity toEntity(NewDTO dto, CategoryEntity cateDTO, NewEntity result) {
		result.setCategory(cateDTO);	
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
//	public NewEntity toEntity(NewDTO dto) {
//		CategoryEntity cateDTO = new CategoryEntity();
//		NewEntity news = new NewEntity();
//		cateDTO.setCode(dto.getCategoryCode());
//		news.setId(dto.getId());
//		news.setCategory(cateDTO);	
//		news.setTitle(dto.getTitle());
//		news.setShortDescription(dto.getShortDescription());
//		news.setContent(dto.getContent());
//		news.setThumbnail(dto.getThumbnail());
//		return news;
//	} tim hieu them
}
