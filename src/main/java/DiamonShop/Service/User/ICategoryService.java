package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductDto;

@Service
public interface ICategoryService {
	public List<ProductDto> getProductsByIDCategory(int id);
	public List<ProductDto> getProductsPagination(int id, int start, int limit);
}
