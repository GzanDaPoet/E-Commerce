package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.dto.ProductVariationOptionDTO;
import ptithcm.model.product.Variation;
import ptithcm.model.product.VariationOption;
import ptithcm.service.VariationOptionService;
import ptithcm.service.VariationService;

@Controller
@RequestMapping(value = "admin/product/")
public class VariationOptionController {

	@Autowired
	VariationService variationService;

	@Autowired
	VariationOptionService variationOptionService;

	@RequestMapping(value = "variation-option/new", method = RequestMethod.GET)
	public String showFormNewVariationOption(ModelMap modelMap) {
		List<Variation> allVariations = variationService.getAllVariations();
		modelMap.addAttribute("listVariation", allVariations);
		return "product/variation-option/newVariationOption";
	}

	@RequestMapping(value = "variation-option/new", method = RequestMethod.POST)
	public String handleNewVariationOption(@RequestParam String variationOptionName, @RequestParam String variationId) {
		if (!variationOptionName.trim().isEmpty()
				&& variationService.checkVariationExist(Integer.parseInt(variationId))) {
			VariationOption variationOption = new VariationOption();
			Variation variation = variationService.getVariationById(Integer.parseInt(variationId));
			variationOption.setValue(variationOptionName);
			variationOption.setVariation(variation);
			variationOptionService.insertVariationOption(variationOption);
		}
		return "redirect:/admin/product/variation-option/list.htm";
	}

	@RequestMapping(value = "variation-option/list", method = RequestMethod.GET)
	public String showListVariationOption(ModelMap modelMap, @RequestParam(defaultValue = "5") int limit,
			@RequestParam(defaultValue = "1") int page) {
		List<VariationOption> listVariationOptions = variationOptionService
				.getListPaginatedVariationOptions(limit * (page - 1), limit);
		List<ProductVariationOptionDTO> listProductVariationOptionDTOs = new ArrayList<ProductVariationOptionDTO>();
		for (int i = 0; i < listVariationOptions.size(); i++) {
			ProductVariationOptionDTO productVariationOptionDTO = new ProductVariationOptionDTO(
					listVariationOptions.get(i));
			listProductVariationOptionDTOs.add(productVariationOptionDTO);
		}
		modelMap.addAttribute("listVariationOption", listProductVariationOptionDTOs);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("limit", limit);
		return "product/variation-option/listVariationOption";
	}

	@RequestMapping(value = "variation-option/delete/{id}")
	public String deleteVariationOptionById(@PathVariable int id) {
		variationOptionService.deleteVariationOptionById(id);
		return "redirect:/admin/product/variation-option/list.htm";
	}

	@RequestMapping(value = "variation-option/edit/{id}", method = RequestMethod.GET)
	public String editVariationOptionById(@PathVariable int id, ModelMap modelMap) {
		VariationOption variationOption = variationOptionService.getVariationOptionById(id);
		ProductVariationOptionDTO productVariationOptionDTO = new ProductVariationOptionDTO(variationOption);
		List<Variation> allVariations = variationService.getAllVariations();
		modelMap.addAttribute("currentVariationOption", productVariationOptionDTO);
		modelMap.addAttribute("listVariation", allVariations);
		return "product/variation-option/editVariationOption";
	}

	@RequestMapping(value = "variation-option/edit/{id}", method = RequestMethod.POST)
	public String handleEditVariationOptionById(@RequestParam String variationOptionName,
			@RequestParam String variationOptionId, @RequestParam String variationId) {
		VariationOption variationOption = variationOptionService
				.getVariationOptionById(Integer.parseInt(variationOptionId));
		Variation variation = variationService.getVariationById(Integer.parseInt(variationId));
		variationOption.setValue(variationOptionName);
		variationOption.setVariation(variation);
		variationOptionService.updateVariationOption(variationOption);
		return "redirect:/admin/product/variation-option/list.htm";
	}
}
