package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.output.NewOutput;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController //dinh nghia responseBody
public class NewAPI {
	@Autowired
	private INewService iNewService;
	
	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam("page") int page) {
		NewOutput output = new NewOutput();
		output.setPage(page);
		output.setTotalPage((int) Math.ceil((double) (iNewService.getTotalItem()) / 4));
		Pageable pageable = new PageRequest(page - 1, 4);
		output.setListResult(iNewService.findAll(pageable));
		return output;
	}
	
	//@RequestMapping(value = "/new", method = RequestMethod.POST)
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return iNewService.save(model);
	}
	
	//@PathVariable("id") long id
	@PutMapping(value = "/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		return iNewService.save(model);
	}
	
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		iNewService.delete(ids);
	}
}
