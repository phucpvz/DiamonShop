package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.SlidesDao;
import DiamonShop.Entity.Slides;

@Service
public class HomeServiceImpl {
	@Autowired
	private SlidesDao slidesDao;
	
	public List<Slides> getDataSlide() {
		return slidesDao.getDataSlide();
	}
}
