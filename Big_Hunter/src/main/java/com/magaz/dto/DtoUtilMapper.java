package com.magaz.dto;

import java.util.HashSet;
import java.util.Set;

import com.magaz.entity.Brend;
import com.magaz.entity.SModel;
import com.magaz.entity.Sizes;
import com.magaz.entity.Sneaker;
import com.magaz.entity.SneakerType;

public class DtoUtilMapper {

	public static SneakerDto sneakerToSneakerDto(Sneaker sneaker) {
		return new SneakerDto(sneaker.getId(), sneaker.getPrice(), String.valueOf(sneaker.getQuantity()));
	}

	public static BrendDto brendToBrendDto(Brend brend) {
		return new BrendDto(brend.getName());
	}

	public static SModelDto modelToModelDto(SModel model) {
		return new SModelDto(model.getName(), model.getPathImage());
	}

	public static TypeDto typetoTypeDto(SneakerType type) {
		return new TypeDto(type.getName());

	}

	public static SizeDto sizeToSizeDto(Sizes size) {
		return new SizeDto(size.getSize());
	}

	public static Set<BrendDto> brendsToBrendsDtos(Set<Brend> brends) {
		Set<BrendDto> brendsDtos = new HashSet<>();
		for (Brend brend : brends) {
			brendsDtos.add(new BrendDto(brend.getName()));

		}

		return brendsDtos;
	}
	
	public static Set<SModelDto> modelToModelsDtos(Set<SModel> models){
		
		Set<SModelDto> modelDtos = new HashSet();
		for(SModel model : models){
			modelDtos.add(new SModelDto(model.getName(),model.getPathImage()));
		}
		
		return modelDtos;
	}
	
	public static Set<TypeDto> typeToTypeDtos(Set<SneakerType> types){
		
		Set<TypeDto> typeDtos = new HashSet();
		for(SneakerType type : types) {
			
			typeDtos.add(new TypeDto(type.getName()));
		}
		return typeDtos;
		
	}
	
//	public static Set<SizeDto> sizeToSizeDtos(Sizes sizes){
//		
//		Set<SizeDto> sizeDtos = new HashSet();
//		for(Sizes size : sizes){
//			
//			sizeDtos.add(new SizeDto(size.getSize()));
//			
//		}
//		return sizeDtos;
//	}
	
	public static Set<SneakerDto> sneakerToSneakerDtos(Set<Sneaker> sneakers){
		
		Set<SneakerDto> sneakerDtos = new HashSet<>();
		
		for(Sneaker sneaker : sneakers){
			
			SneakerDto sneakerDto = sneakerToSneakerDto(sneaker);
//			sneakerDto.setTypes(typeToTypeDtos(sneaker.getTypes()));
			sneakerDto.setModels(modelToModelsDtos(sneaker.getModels()));
//			sneakerDto.setBrends(brendsToBrendsDtos(sneaker.getBrends()));
			//sneakerDto.setSizes(sizeToSizeDtos(sneaker.getSize()));
			
			sneakerDtos.add(sneakerDto);
		}
		return sneakerDtos;
		
	}
	
	
	

}
