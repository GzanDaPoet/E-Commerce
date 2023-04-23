package ptithcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.variationOption.VariationOptionDao;
import ptithcm.model.product.VariationOption;

@Service
@Transactional
public class VariationOptionService {
	@Autowired
	VariationOptionDao variationOptionDao;

	public void insertVariationOption(VariationOption variationOption) {
		variationOptionDao.insert(variationOption);
	}

	public List<VariationOption> getAllVariationOptions() {
		return variationOptionDao.getAllVariationOptionons();
	}

	public List<VariationOption> getListPaginatedVariationOptions(int firstResult, int maxResults) {
		return variationOptionDao.listPaginatedVariationOptions(firstResult, maxResults);
	}

	public void deleteVariationOptionById(int variationId) {
		variationOptionDao.deleteById(variationId);
	}

	public VariationOption getVariationOptionById(int variationOptionId) {
		return variationOptionDao.getVariationOptionById(variationOptionId);
	}

	public void updateVariationOption(VariationOption variationOption) {
		variationOptionDao.updateById(variationOption);
	}
}
