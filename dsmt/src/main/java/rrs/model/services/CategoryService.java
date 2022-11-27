package rrs.model.services; 

import org.springframework.stereotype.Service;

import rrs.model.entities.Category;
@Service
public class CategoryService extends AbstractService<Category, String>{

	@Override
	protected String getId(Category entity) {
		return entity.getId();
	}

}
