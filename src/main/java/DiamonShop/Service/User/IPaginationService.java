package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginationDto;

@Service
public interface IPaginationService {
	public PaginationDto getInfoPagination(int totalData, int limit, int currentPage);
}
