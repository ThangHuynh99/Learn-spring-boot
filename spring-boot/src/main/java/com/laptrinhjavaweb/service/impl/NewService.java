package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	//ham chung cua ham save and update(Refactory code)
		@Override
		@Transactional
		public NewDTO save(NewDTO saveOrUpdateNew) {
			CategoryEntity categoryEntity = categoryRepository.findOneByCode(saveOrUpdateNew.getCategoryCode());
			NewEntity newEntity = new NewEntity();
			if(saveOrUpdateNew.getId() == null) {
				newEntity = newConverter.toEntity(saveOrUpdateNew, categoryEntity);
			}else if (saveOrUpdateNew.getId() != null) {
				NewEntity oldNew = newRepository.findOne(saveOrUpdateNew.getId());
				newEntity = newConverter.toEntity(saveOrUpdateNew, categoryEntity, oldNew);// dung ham nay vi phai dua tren newEntity cu.
			}
			newEntity = newRepository.save(newEntity);
			return newConverter.toDTO(newEntity);
		}

		//	newEntity = newConverter.toEntity(saveOrUpdateNew); tim hieu them
		@Override
		public List<NewDTO> findAll(Pageable pageable) {
			List<NewDTO> models = new ArrayList<>();
			List<NewEntity> entities = newRepository.findAll(pageable).getContent(); //ham findAll return ra các class implement interface list
			for (NewEntity item: entities) {
				NewDTO newDTO = newConverter.toDTO(item);
				models.add(newDTO);
			}
			return models;
		}

		@Override
		public NewDTO findOne(long id) {
			
			return null;
		}

		@Override
		public int getTotalItem() {
			return (int) newRepository.count();
		}

		@Override
		public void delete(long[] ids) {
			for(long id: ids) {
				newRepository.delete(id);
			}
		}
}
