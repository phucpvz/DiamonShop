package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductDto;

@Service
public interface IProductService {
	public ProductDto getProductByID(long id);
	public List<ProductDto> getProductsByIDCategory(int id);
}
