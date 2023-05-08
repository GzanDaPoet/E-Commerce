package ptithcm.dao.variationOption;

import java.util.List;

import ptithcm.model.product.VariationOption;

public interface VariationOptionDao {

	public void insert(VariationOption variationOption);

	public void deleteById(int variationOptionId);

	public void updateById(VariationOption variationOption);

	public VariationOption getVariationOptionById(int variationOptionId);

	public List<VariationOption> getAllVariationOptionons();

	public List<VariationOption> listPaginatedVariationOptions(int firstResult, int maxResults, String search);
}
