<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Input ${head} data</h3>

<div>

	<form:form class="form-horizontal" action="/${link}" method="post"
		modelAttribute="entity" enctype="multipart/form-data">

		<c:forEach var="entry" items="${entityMap}">

			<div class="form-group">

				<form:label class="control-label col-sm-2" path="${entry.key}">${entry.value}</form:label>

				<div class="col-sm-10">

					<form:input path="${entry.key}" placeholder="Input ${entry.value}" />

					<form:errors class="alert alert-warning" path="${entry.key}" />

				</div>

			</div>

		</c:forEach>

		<div class="form-group">

			<div class="col-sm-offset-2 col-sm-10">

				<button class="btn btn-primary" type="submit" name="submit">Submit</button>

				<!-- 	<button class="btn btn-secondary" type="submit" name="reset">Reset</button> -->

			</div>

		</div>

		<!-- 
	</form>
-->

	</form:form>

</div>