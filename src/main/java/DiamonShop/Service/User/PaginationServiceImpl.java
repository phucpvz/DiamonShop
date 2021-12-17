package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginationDto;

@Service
public class PaginationServiceImpl implements IPaginationService {
	public PaginationDto getInfoPagination(int totalData, int limit, int currentPage) {
		PaginationDto pagination = new PaginationDto();
		pagination.setLimit(limit);
		pagination.setTotalPage(setInfoTotalPage(totalData, limit));
		pagination.setCurrentPage(checkCurrentPage(currentPage, pagination.getTotalPage()));
		int start = findStart(pagination.getCurrentPage(), limit);
		pagination.setStart(start);
		int end = findEnd(pagination.getStart(), limit, totalData);
		pagination.setEnd(end);
		return pagination;
	}
	
	private int findStart(int currentPage, int limit) {
		return (currentPage - 1) * limit + 1;
	}
	
	private int findEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData : start + limit - 1;
	}
	
	private int setInfoTotalPage(int totalData, int limit) {
		int totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	private int checkCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
