<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
  <div class="form-group">
    <label for="option1">Option 1:</label>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="option1" id="option1a" value="option1a">
      <label class="form-check-label" for="option1a">
        Option 1A
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="option1" id="option1b" value="option1b">
      <label class="form-check-label" for="option1b">
        Option 1B
      </label>
    </div>
  </div>
  
  <div class="form-group">
    <label for="option2">Option 2:</label>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="option2" id="option2a" value="option2a">
      <label class="form-check-label" for="option2a">
        Option 2A
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="option2" id="option2b" value="option2b">
      <label class="form-check-label" for="option2b">
        Option 2B
      </label>
    </div>
  </div>
  
  <button type="submit" class="btn btn-primary">Check out</button>
</form>

</body>
</html>