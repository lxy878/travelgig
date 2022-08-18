<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>View Questions & Answers</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
	<script src="/js/viewQAs.js"></script>
</head>

<body id="userEmail" uemail=${uEmail}>
	<div class="container">
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Hotel Id</th>
					<th scope="col">Question</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody id="questions">
				<tr qaId="0">
					<td>1</td>
					<td>What is the name of this hotel?</td>
					<td><button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#answerForm">To answer</button></td>
				</tr>
			</tbody>
		</table>

		<div class="modal" id="answerForm">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">To Answer The Question</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body" id="form_body">
						<input id="qaId" hidden/>
						<textarea class="form-control" placeholder="Leave an answer here" id="answer"></textarea>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="submitAnswer">Submit Answer</button>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>

</html>