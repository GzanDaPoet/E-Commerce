
function addProduct() {

	let productList = document.getElementById("product-list");
	let newProduct = document.createElement("div");
	newProduct.className = "row mb-3 mt-3";
	newProduct.innerHTML = `
                <div class="col">
                  <input type="text" class="form-control" placeholder="Product Item ID" name="productItem">
                </div>
                <div class="col">
                  <input type="text" class="form-control" placeholder="Quanlity" name="qty">
                </div>
                <div class="col">
                  <input type="text" class="form-control" placeholder="Price" name="price">
                </div>
                <div class="col-1">
                  <button type="button" class="btn btn-danger" onclick="removeProduct(this)"><i class="bi bi-trash"></i> Del</button>
                </div>`;
	productList.appendChild(newProduct);
}
function removeProduct(button) {
	button.closest(".row").remove();
}
