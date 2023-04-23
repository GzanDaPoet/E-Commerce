package ptithcm.dto;

import org.springframework.stereotype.Repository;

import ptithcm.model.product.VariationOption;

@Repository
public class ProductVariationOptionDTO {
	private String variationName;
	private String variationOptionValue;
	private int id;
	private int variationId;

	public ProductVariationOptionDTO(VariationOption variationOption) {
		this.variationName = variationOption.getVariation().getName();
		this.variationId = variationOption.getVariation().getId();
		this.variationOptionValue = variationOption.getValue();
		this.id = variationOption.getId();
	}

	public String getVariationName() {
		return variationName;
	}

	public void setVariationName(String variationName) {
		this.variationName = variationName;
	}

	public String getVariationOptionValue() {
		return variationOptionValue;
	}

	public void setVariationOptionValue(String variationOptionValue) {
		this.variationOptionValue = variationOptionValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVariationId() {
		return variationId;
	}

	public void setVariationId(int variationId) {
		this.variationId = variationId;
	}

}
