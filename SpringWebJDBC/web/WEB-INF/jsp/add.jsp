<%@include file="header.jsp" %>
<div>
    <h2>Add Product</h2>
</div>
<form method="post" action="${SITE_URL}/save">
    <div class="form-group">
        <label>Product Name</label>
        <input type="text" name="name" required="required" class="form-control" placeholder="Please enter product name"/>
    </div>
    <div class="form-group">
        <label>Description</label>
        <input type="text" name="description" required="required" class="form-control" placeholder="Please enter Description"/>
    </div>
    <div class="form-group">
        <label>Cost Price</label>
        <input type="text" name="costPrice" required="required" class="form-control" placeholder="Please enter your cost price"/>
    </div>
    <div class="form-group">
        <label>Selling Price</label>
        <input type="text" name="sellPrice" required="required" class="form-control" placeholder="Please enter selling price"/>
    </div>
    <div class="form-group">
        <label>Quantity</label>
        <input type="text" name="quantity" required="required" class="form-control" placeholder="Please enter quantity"/>
    </div>
    <div class="checkbox">
        <label ng-style="">Status</label>
        <label><input type="checkbox" name="status"/>Active</label>
    </div>
    <a href="${SITE_URL}" class="btn btn-danger">Back</a>
    <button type="submit" class="btn btn-primary">Save</button>
</form>
<%@include file="footer.jsp" %>
