<%@include  file="header.jsp" %>
<h2>Welcome to Dashboard</h2>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form class="search-form">
            <div class="form-group has-feedback">
                <label for="search" class="sr-only">Search</label>
                <input type="text" class="form-control" name="search" placeholder="search">
                <span class="glyphicon glyphicon-search form-control-feedback"></span>
            </div>
        </form>
    </div>
</div>
<div class="pull-right">
    <a href="${SITE_URL}/add" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus">Add</span>
    </a>
</div>
<table class="table">
    <tr style="background-color: tan">
        <th>Product ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Cost Price($)</th>
        <th>Selling Price($)</th>
        <th>Quantity</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr style="background-color: transparent">
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.costPrice}</td>
            <td>${product.sellPrice}</td>
            <td>${product.quantity}</td>
            <td>
                <c:choose>
                    <c:when test="${product.status}">
                        Active
                    </c:when>
                    <c:otherwise>
                        Inactive
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${SITE_URL}/edit/${product.id}" class="btn btn-primary btn-xs">
                    <span class="glyphicon glyphicon-pencil"/>
                </a>
                <a href="${SITE_URL}/delete/${product.id}" class="btn btn-danger btn-xs" onclick="return confirm('Are you sure to delete?')">
                    <span class="glyphicon glyphicon-trash"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp" %>
