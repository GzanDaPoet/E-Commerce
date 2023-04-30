window.addEventListener("DOMContentLoaded", function() {
  // Lấy tất cả các radio button có tên là "ShippingMethod"
  var shippingRadios = document.getElementsByName("ShippingMethod");
  // Lặp qua các radio button và thêm sự kiện click cho mỗi radio button
  shippingRadios.forEach(function(radio) {
    radio.addEventListener("click", function() {
      // Lấy giá của phương thức vận chuyển được chọn
      var price = parseInt(this.value);
      var currentTotal = parseInt(document.getElementById("total-price").textContent);
      // Hiển thị giá lên trang web
      price 
      document.getElementById("shipping-price").textContent = price;
      var newTotal = currentTotal + price;
      document.getElementById("total").textContent = newTotal;
      
    });
  });
});
