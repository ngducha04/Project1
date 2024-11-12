package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getMapping(@RequestParam (value="name", required = false) String name,
			@RequestParam (value="district", required = false) Integer districtId){
		List<BuildingDTO> result = buildingService.findAll(name, districtId);
		return result;
	}
//	public void validate(BuildingDTO buildingDTO){
//		if(buildingDTO.getNameBuilding() == null || buildingDTO.getNameBuilding().equals("") || buildingDTO.getNumberOfBasement() == null) {
//			throw new FieldRequiredException("name hoặc numberOfBasement is null!");
//		}
//	}

	
//	@PostMapping(value = "/api/building/")
//	public BuildingDTO postBuilding(@RequestBody BuildingDTO buildingDTO) {
//		
//		return buildingDTO;
//	}
	
	@DeleteMapping(value = "/api/building/{id}")
	public void deleteBuilding(@PathVariable Integer id) {
		System.out.print("Đã xóa sản phẩm " + id + " thành công!");
	}

}