$(document).ready(function() {
  // Thiết lập sự kiện click cho tất cả các radio button có tên là "ShippingMethod"
  $('input[name="ShippingMethod"]').click(function() {
    // Lấy giá của phương thức vận chuyển được chọn
    var price = $(this).val();
    // Hiển thị giá lên trang web
    $('#shipping-price').text(price);
  });
});
