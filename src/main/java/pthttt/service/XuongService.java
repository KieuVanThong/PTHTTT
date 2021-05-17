package pthttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.Xuong;
import pthttt.repository.XuongRepository;

@Service
public class XuongService {

	@Autowired
	private XuongRepository xuongRepository;
	
	public Xuong findXuong(int ID) {
		return xuongRepository.findById(ID);
	}
	
	public Xuong save(Xuong xuong) {
		return xuongRepository.save(xuong);
	}
}
